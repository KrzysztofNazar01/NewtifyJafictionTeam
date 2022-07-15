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
public class WeatherWidgetComponent extends FlexLayout {

    private static final long serialVersionUID    = 1414727226197592073L;
    private double longtitude;
    private double latitude;
    private WeatherConnectorService weatherConnectorService = new WeatherConnectorService();
    private H4 temperatureLabel = new H4();


    @PostConstruct
    private void init() {

        createWidgetIcon();
        createEntryPart();

        this.getStyle()
                .set("background", "var(--lumo-contrast-10pct)")
                .set("border-radius", "1em");
        this.setFlexDirection(FlexDirection.COLUMN);
        this.setAlignItems(Alignment.CENTER);
        this.setWidthFull();
    }


    private void createWidgetIcon() {
        Icon cloudIcon = VaadinIcon.CLOUD.create();
        cloudIcon.setSize("5em");
        cloudIcon.setColor("var(--lumo-contrast-color)");

        this.add(cloudIcon);
    }

    private void createEntryPart() {
        TextField longitudeTextField = new TextField();
        longitudeTextField.setValue("");
        longitudeTextField.setLabel("Longtitude");
        longitudeTextField.setRequiredIndicatorVisible(true);
        longitudeTextField.setErrorMessage("This field is required");

        TextField latitudeTextField = new TextField();
        latitudeTextField.setValue("");
        latitudeTextField.setLabel("Latitude");
        latitudeTextField.setRequiredIndicatorVisible(true);
        latitudeTextField.setErrorMessage("This field is required");

        H4 todayWeatherTitle = new H4("Today the weather is");
        todayWeatherTitle.getStyle()
                .set("color", "var(--lumo-contrast-color)");

        H3 todayWeatherValue = new H3();

        Button button = new Button("Fetch weather");
        button.addClickListener(buttonClickEvent -> {
            todayWeatherValue.removeAll();
            if (longitudeTextField.getValue() != null) {
                longtitude = Double.parseDouble(longitudeTextField.getValue());
            }

            if (latitudeTextField.getValue() != null) {
                latitude = Double.parseDouble(latitudeTextField.getValue());
            }
            todayWeatherValue.add("Longitude: " + longtitude + ", Latitude: " + latitude);
            createResponsePart();
        });

        todayWeatherValue.getStyle()
                .set("color", "white")
                .set("font-style", "italic")
                .set("margin", "0");

        this.add(latitudeTextField, longitudeTextField, button);
    }

    private void createResponsePart() {
        double data = weatherConnectorService.retrieveWeather(latitude, longtitude);

        if (data != -100.0) {
            temperatureLabel.removeAll();
            temperatureLabel.setText("The temperature is: "+data);
        }
        temperatureLabel.getStyle()
                .set("color", "var(--lumo-contrast-color)")
                .set("margin", "1em 0 0 0");

        this.add(temperatureLabel);
    }


}