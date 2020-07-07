package com.practice.automationspring.page;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


public abstract class BasePage {

  // @Qualifier("firefox")
    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait webDriverWait;

    public abstract boolean isAt();

    @PostConstruct
    private void init(){
        PageFactory.initElements(driver,this);
    }
}
