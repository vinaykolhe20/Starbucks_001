package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddToCart;
import pages.HomePage;
import pages.NutritionBlock;
import pages.WhatsIncluded;

public class TC005CheckDropDown extends BaseTest{

	
	@Test(retryAnalyzer = utils.RetryAnalyzer.class)
	public void verifyTrendingNavigation() {
        HomePage home = new HomePage(driver);
        home.clickMenu();
        AddToCart cart = new AddToCart(driver);
        
        cart.clickTrending();
        cart.getItemView();
        
        WhatsIncluded wi = new WhatsIncluded(driver);
        
        wi.selectDrink("Nonfat Milk");
        
        
        
}
}
