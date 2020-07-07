package com.practice.automationspring.util;

import com.github.javafaker.Faker;
import com.practice.automationspring.annotations.LazyConfiguration;
import com.practice.automationspring.config.FakerConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@LazyConfiguration
public class ScreenshotUtil {

    @Autowired
    private TakesScreenshot driver;

    @Value("${screenshot.path}")
    private Path path;

    @Autowired
    private Faker faker;

    public void takeScreenshot() throws IOException {
       File sourceFile = this.driver.getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile,this.path.resolve(faker.name().firstName()+".png").toFile());
    }


//    @PostConstruct
//    public void init(){
//        for (int i=0; i < 10; i ++){
//            try{
//                Thread.sleep(1000);
//            }catch(Exception e){
//
//            }
//            System.out.println("Sleeping ....");
//        }
//    }
}
