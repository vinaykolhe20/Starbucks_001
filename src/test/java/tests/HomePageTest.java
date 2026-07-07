package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageTitle() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Starbucks"));
    }

    @Test
    public void verifyMenuNavigation() {
        HomePage home = new HomePage(driver);
        home.clickMenu();
        Assert.assertTrue(driver.getCurrentUrl().contains("menu"));
    }
}