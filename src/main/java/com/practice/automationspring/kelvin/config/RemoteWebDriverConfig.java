package com.practice.automationspring.kelvin.config;


import com.practice.automationspring.kelvin.annotations.LazyConfiguration;
import com.practice.automationspring.kelvin.annotations.ThreadScopeBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

import java.net.URL;


@LazyConfiguration
@Profile("remote")
public class RemoteWebDriverConfig {

    @Value("${selenium.grid.url}")
    private URL url;

    @ThreadScopeBean
    @ConditionalOnProperty(name="browser", havingValue = "firefox")
    public WebDriver remoteFirefoxDriver(){
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        return new RemoteWebDriver(url,dc);
    }


    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver remoteChromeDriver(){
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        return new RemoteWebDriver(url,dc);
    }
}
