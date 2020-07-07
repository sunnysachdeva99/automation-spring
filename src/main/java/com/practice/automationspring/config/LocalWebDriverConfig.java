package com.practice.automationspring.config;


import com.practice.automationspring.annotations.LazyConfiguration;
import com.practice.automationspring.annotations.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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
   // @ConditionalOnExpression("${browser} =chrome")
    public WebDriver getChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }




}
