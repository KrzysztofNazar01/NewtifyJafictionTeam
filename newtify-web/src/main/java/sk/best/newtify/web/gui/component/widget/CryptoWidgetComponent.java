package sk.best.newtify.web.gui.component.widget;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sk.best.newtify.web.connector.CryptoConnectorService;

import javax.annotation.PostConstruct;

/**
 * @author Marek Urban
 * Copyright © 2022 BEST Technická univerzita Košice.
 * All rights reserved.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CryptoWidgetComponent extends FlexLayout {

    private static final long serialVersionUID    = 1414727226197592073L;
    private String cryptoVl;
    private CryptoConnectorService cryptoConnectorService = new CryptoConnectorService();


    @PostConstruct
    private void init() {

        createWidgetIcon();
        createResponsePart();

        this.getStyle()
                .set("background", "var(--lumo-contrast-10pct)")
                .set("border-radius", "1em");
        this.setFlexDirection(FlexDirection.COLUMN);
        this.setAlignItems(Alignment.CENTER);
        this.setWidthFull();
    }


    private void createWidgetIcon() {
        Icon icon = VaadinIcon.COIN_PILES.create();
        icon.setSize("5em");
        icon.setColor("var(--lumo-contrast-color)");

        this.add(icon);
    }

    private void createResponsePart() {
        H4 cryptoLabel = new H4("Fear and greed index for bitcoin:");
        H4 cryptoLabelTitle = new H4("Fear and greed index for bitcoin:");

        String cryptoInfo = cryptoConnectorService.retrieveCrypto();
        cryptoLabel.setText(cryptoInfo);

        cryptoLabel.getStyle()
                .set("color", "var(--lumo-contrast-color)")
                .set("margin", "1em 0 0 0");

        this.add(cryptoLabelTitle, cryptoLabel);
    }


}