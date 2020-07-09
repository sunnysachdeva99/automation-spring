package com.practice.automationspring.page.google;


import com.practice.automationspring.kelvin.annotations.LazyPageComponent;
import com.practice.automationspring.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


@LazyPageComponent
public class SearchResult extends BasePage {

    @FindBy(css="div.rc")
    private List<WebElement> results;

    @Override
    public boolean isAt() {
       return this.webDriverWait.until(d-> this.results.size()>0);
    }

    public int getCount(){
        return results.size();
    }
}
