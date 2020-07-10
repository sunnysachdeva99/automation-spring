package com.practice.automationspring.kelvin.config;


import com.practice.automationspring.kelvin.annotations.LazyConfiguration;
import com.practice.automationspring.kelvin.annotations.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;


@Profile("!remote")
@LazyConfiguration
public class LocalWebDriverConfig {


    // @Qualifier("firefox")
    //@Primary
    // -Dbrowser=firfox, if we need to run from maven


    @ThreadScopeBean
    @ConditionalOnProperty(name="browser", havingValue = "firefox")
    //@ConditionalOnExpression("${browser} =firefox")
    public WebDriver getFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }



   // @Qualifier("chrome")
   @ThreadScopeBean
   @ConditionalOnMissingBean
   // @ConditionalOnProperty(name="browser", havingValue = "chrome")
    //@ConditionalOnExpression("${browser} =chrome")
    public WebDriver getChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }




}
