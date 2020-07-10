package com.practice.automationspring.googleTests;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;

public class ResourceTest extends BaseTest{

    @Value("classpath:data/testdata.csv")
    private Resource resource;

    @Test
    public void testResource() throws IOException {
        Files.readAllLines(resource.getFile().toPath())
                .forEach(System.out::println);
    }


    // @Autowired
    // private ResourceLoader resourceLoader;
    // we can use ResourceLoader for cases where files are dynamic
    // resourceLoader.getResource(url).getInputStream()

}
