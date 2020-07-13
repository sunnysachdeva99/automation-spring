package com.practice.automationspring.page.flights;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource("classpath:data/language/${app.locale}.properties")
@Getter
public class FlightAppDetails {

    @Value("${flight.app.url}")
    private String url;


    @Value("${flight.app.labels}")
    private List<String> labels;


}
