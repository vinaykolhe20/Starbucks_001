package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class HomePageTest extends BaseTest {

	HomePage home;

	@BeforeMethod
	public void initPages() {
		home = new HomePage(driver); // ← runs before EVERY test ✓
	}

	@Test(groups = { "smoke", "homepage" }, priority = 1)
	public void verifyHomePageTitle() {

		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Starbucks"));
	}

	@Test(groups = { "regression", "homepage" }, priority = 2)
	public void verifyMenuNavigation() {

		home.clickMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("menu"));
	}

	@Test(groups = { "regression", "homepage" }, priority = 3)
	public void verify_Logo_IsDisplayed_AndLinksToHome() {
		Assert.assertTrue(home.logo());
	}

}