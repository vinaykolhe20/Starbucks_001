package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddToCart;
import pages.HomePage;

public class TC003AddToCart extends BaseTest {

	
	@Test
	public void verifyTrendingNavigation() {
        HomePage home = new HomePage(driver);
        home.clickMenu();
        AddToCart cart = new AddToCart(driver);
        
        cart.clickTrending();
        cart.getItemView();
        cart.AddtoCartButton();
    }
	
}
