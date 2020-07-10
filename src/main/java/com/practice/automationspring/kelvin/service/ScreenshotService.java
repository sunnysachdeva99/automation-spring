package com.practice.automationspring.kelvin.service;

import com.github.javafaker.Faker;
import com.practice.automationspring.kelvin.annotations.LazyService;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.util.FileCopyUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@LazyService
public class ScreenshotService {

    @Autowired
    //private TakesScreenshot driver;
    private ApplicationContext context;
    @Value("${screenshot.path}")
    private Path path;

    @Autowired
    private Faker faker;

    public void takeScreenshot() throws IOException {
       File sourceFile = this.context.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
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
