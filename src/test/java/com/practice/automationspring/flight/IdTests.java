package com.practice.automationspring.flight;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = "app.locale=id")
public class IdTests extends FlightTests {
}
