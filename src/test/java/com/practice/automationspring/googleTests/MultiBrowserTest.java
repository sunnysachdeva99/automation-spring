package com.practice.automationspring.googleTests;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

public class MultiBrowserTest extends BaseTest {


    @Autowired
    private ApplicationContext context;


    @Test
    public void browserTest(){
        this.context.getBean("getChromeDriver", WebDriver.class);
        this.context.getBean("getFirefoxDriver", WebDriver.class);
    }
}
