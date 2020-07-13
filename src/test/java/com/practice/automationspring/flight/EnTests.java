package com.practice.automationspring.flight;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = "app.locale=en")
public class EnTests extends FlightTests {
}
