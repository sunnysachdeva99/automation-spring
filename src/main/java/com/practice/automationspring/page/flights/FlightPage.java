package com.practice.automationspring.page.flights;

import com.practice.automationspring.kelvin.annotations.LazyPageComponent;
import com.practice.automationspring.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Lazy
public class FlightPage extends BasePage {

    @FindBy(css="a.gws-travel-header__nav-item span.gws-travel-header__nav-label")
    private List<WebElement> elements;

    public void goTo(final String url){
        this.driver.get(url);
    }


    public List<String> getLabels(){
        return this.elements
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());

    }


    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d) -> !this.elements.isEmpty());
    }
}
