package com.practice.automationspring.kelvin.config;


import com.practice.automationspring.kelvin.annotations.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;


@LazyConfiguration
public class WebDriverWaitConfig {


    // we cant have singleton scope in this class because when we put singleton, then its tightly coupled with
    // webdriver, which can be closed and new instance can be created
    // so it should prototype or browserscope, but browserscope that we created was for webdriver only, besides
    // for  webdriver we can validate if browser is open but how do we validate same for webdriverwait
    // hence go for prototype

    @Value("${DEFAULT_TIMEOUT:30}")
    private long timeout;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public WebDriverWait webDriverWait(WebDriver driver)
    {
        return  new WebDriverWait(driver,this.timeout);
    }
}
