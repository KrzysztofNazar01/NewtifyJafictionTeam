package sk.best.newtify.web.gui.component.widget;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sk.best.newtify.api.dto.NameDayDTO;
import sk.best.newtify.api.dto.WeatherDTO;
import sk.best.newtify.web.connector.JokeConnectorService;
import sk.best.newtify.web.connector.WeatherConnectorService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

/**
 * @author Marek Urban
 * Copyright © 2022 BEST Technická univerzita Košice.
 * All rights reserved.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class JokeWidgetComponent extends FlexLayout {

    private static final long serialVersionUID    = 1414727226197592073L;
    private String joke;
    private JokeConnectorService jokeConnectorService = new JokeConnectorService();


    @PostConstruct
    private void init() {

        createWidgetIcon();
        createJokePart();

        this.getStyle()
                .set("background", "var(--lumo-contrast-10pct)")
                .set("border-radius", "1em");
        this.setFlexDirection(FlexDirection.COLUMN);
        this.setAlignItems(Alignment.CENTER);
        this.setWidthFull();
    }


    private void createWidgetIcon() {
        Icon smileyIcon = VaadinIcon.SMILEY_O.create();
        smileyIcon.setSize("5em");
        smileyIcon.setColor("var(--lumo-contrast-color)");

        this.add(smileyIcon);
    }

    private void createJokePart() {
        H4 jokeLabel = new H4();
        String joke = jokeConnectorService.retrieveJoke();
        jokeLabel.setText(joke);

        jokeLabel.getStyle()
                .set("color", "var(--lumo-contrast-color)")
                .set("margin", "1em 0 0 0");

        this.add(jokeLabel);
    }


}