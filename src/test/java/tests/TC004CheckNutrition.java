package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddToCart;
import pages.HomePage;
import pages.NutritionBlock;

public class TC004CheckNutrition extends BaseTest{

	
	@Test(retryAnalyzer = utils.RetryAnalyzer.class)
	public void verifyTrendingNavigation() {
        HomePage home = new HomePage(driver);
        home.clickMenu();
        AddToCart cart = new AddToCart(driver);
        
        cart.clickTrending();
        cart.getItemView();
        
        NutritionBlock nutrition = new NutritionBlock(driver);
        
        nutrition.clickIngredients();
        boolean isNutritionDisplayed = nutrition.isNutritionSectionDisplayed();

        // Step 5 - Assert
        Assert.assertTrue(isNutritionDisplayed,
            "Nutrition section is NOT displayed on product page");
        
    }
	
}
