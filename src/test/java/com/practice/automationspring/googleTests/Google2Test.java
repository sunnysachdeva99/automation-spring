package com.practice.automationspring.googleTests;

import com.google.common.util.concurrent.Uninterruptibles;
import com.practice.automationspring.page.google.GooglePage;
import com.practice.automationspring.util.ScreenshotUtil;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Google2Test extends BaseTest {


    @Autowired
    private GooglePage googlePage;

    @Autowired
    @Lazy
    private ScreenshotUtil screenshotUtil;

    @Test
    public void googleTests() throws IOException {
        googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        this.googlePage.getSearchComponent().searchFor(" selenium ");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount()>2);
       this.screenshotUtil.takeScreenshot();
    }
}
