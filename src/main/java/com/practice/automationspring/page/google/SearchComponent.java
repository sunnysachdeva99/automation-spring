package com.practice.automationspring.page.google;


import com.practice.automationspring.annotations.LazyPageComponent;
import com.practice.automationspring.page.BasePage;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@LazyPageComponent
public class SearchComponent extends BasePage {


    @FindBy(name ="q")
    private WebElement searchBox;

    @FindBy(name ="btnK")
    private List<WebElement> searchBtn;

    public void searchFor(final String keyword){
        this.searchBox.sendKeys(keyword);
        this.searchBtn.stream()
                .filter(e-> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(e ->e.click());
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d) -> this.searchBox.isDisplayed());
    }
}
