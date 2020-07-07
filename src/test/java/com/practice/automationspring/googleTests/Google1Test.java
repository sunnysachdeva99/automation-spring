package com.practice.automationspring.googleTests;

import com.google.common.util.concurrent.Uninterruptibles;
import com.practice.automationspring.annotations.LazyAutowired;
import com.practice.automationspring.page.google.GooglePage;
import com.practice.automationspring.util.ScreenshotUtil;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Google1Test extends BaseTest {



    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotUtil screenshotUtil;

    @Test
    public void googleTests() throws IOException {
        googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        this.googlePage.getSearchComponent().searchFor(" spring boot ");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount()>2);
        this.screenshotUtil.takeScreenshot();
    }
}
