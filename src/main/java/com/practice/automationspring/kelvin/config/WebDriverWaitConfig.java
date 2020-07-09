package com.practice.automationspring.config;


import com.practice.automationspring.kelvin.annotations.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;



@LazyConfiguration
public class WebDriverWaitConfig {

    @Value("${DEFAULT_TIMEOUT:30}")
    private long timeout;

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver)
    {
        return  new WebDriverWait(driver,this.timeout);
    }
}
