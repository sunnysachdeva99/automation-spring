package com.practice.automationspring.googleTests.props;

import com.practice.automationspring.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class PropsTest extends BaseTest {

    @Autowired
    private ResourceLoader resourceLoader;


    @Test
    public void loadPropertyFile() throws IOException {
        Properties properties= PropertiesLoaderUtils.loadProperties(resourceLoader.getResource("classpath:data/app.properties"));
        System.out.println(properties);
    }

}
