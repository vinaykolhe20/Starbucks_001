package tests;

import base.BaseTest;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {   // extends BaseTest for driver setup

    // Step 1 — DataProvider method (data source)
    @DataProvider(name = "drinkData")
    public Object[][] getDrinkData() {
        return new Object[][] {
            {"Latte"},
            {"Frappuccino"},
            {"Cappuccino"},
            {"Cold Brew"}
        };
    }

    // Step 2 — Test method that uses the DataProvider
    @Test(dataProvider = "drinkData", retryAnalyzer = utils.RetryAnalyzer.class)
    public void searchDrinks(String drinkName) {
        HomePage home = new HomePage(driver);
        home.clickMenu();
        home.clickSearch();
        home.enterSearchText(drinkName);
        
    }
}