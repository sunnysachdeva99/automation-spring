package com.practice.automationspring.page.google;


import com.practice.automationspring.annotations.LazyPage;
import com.practice.automationspring.page.BasePage;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Data
@LazyPage
public class GooglePage extends BasePage {

    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResult searchResult;

    @Value("${url}")
    private String url;

    public void goTo(){
        System.out.println("URL: "+this.url);
        this.driver.navigate().to(this.url);
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }

    public  void  close(){
        this.driver.quit();
    }
}
