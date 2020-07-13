package com.practice.automationspring.flight;

import com.practice.automationspring.BaseTest;
import com.practice.automationspring.page.flights.FlightAppDetails;
import com.practice.automationspring.page.flights.FlightPage;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;


public class FlightTests extends BaseTest {

    @Autowired
    private FlightPage flightPage;

    @Autowired
    private FlightAppDetails flightAppDetails;

    @Test
    public void testFlight(){
        this.flightPage.goTo(this.flightAppDetails.getUrl());
        Assert.assertTrue(this.flightPage.isAt());

        Assert.assertEquals(this.flightPage.getLabels(),this.flightAppDetails.getLabels());
    }

}
