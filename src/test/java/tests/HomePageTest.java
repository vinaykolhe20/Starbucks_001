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

	@Test(groups = { "regression", "homepage" }, priority = 1)
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

	@Test(groups = { "smoke", "homepage" }, priority = 4)
	public void storeFinderpageTitle() {
		home.storeFinder();
		String titleStore = driver.getTitle();
		Assert.assertTrue(titleStore.contains("Store"));
	}
	
	@Test(groups = { "smoke", "homepage" }, priority = 5)
	public void verify_home_signIn_navigation_signin_page() {
		home.homeSignIn();
		String titleStore = driver.getTitle();
		Assert.assertTrue(titleStore.contains("Account sign"));
	}
	
	@Test(groups = { "smoke", "homepage" }, priority = 6)
	public void verify_home_JoinNow_navigation_JoinNow_page() {
		home.homeJoinNow();
		String titleStore = driver.getTitle();
		Assert.assertTrue(titleStore.contains("Create a Starbucks"));
	}
	
	@Test(groups = { "smoke", "homepage" }, priority = 7)
	public void verify_home_StartOrder_navigation_StartOrder_page() {
		home.homeStartOrder();
		String titleStore = driver.getTitle();
		Assert.assertTrue(titleStore.contains("Menu"));
	}
	
	
	
}