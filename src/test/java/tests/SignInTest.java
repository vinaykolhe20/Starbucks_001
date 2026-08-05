package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.SignInPage;

public class SignInTest extends BaseTest{
	SignInPage signInPage;
	
	
	 @BeforeMethod
	    public void navigateToSignIn() {
	        HomePage homePage = new HomePage(driver);
	        homePage.homeSignIn();
	        signInPage = new SignInPage(driver);
	    }
	 
	 @DataProvider(name = "invalidEmails")
	    public Object[][] invalidEmails() {
	        return new Object[][] {
	            { "" },                       // empty
	                  // double dot
	            { "   " }                   // whitespace only
	                     // TLD too short (edge case)
	        };
	    }
	 
	 @Test(dataProvider = "invalidEmails", groups = {"regression", "auth", "negative"}, priority = 23)
	    public void verify_InvalidEmailFormats_ShowValidationError(String email) {
	        //log.info("TC23 [data-driven]: Testing invalid email -> " + email);
	        signInPage.enterEmail(email);
	        signInPage.enterPassword("SomePassword123");
	        signInPage.signInpagebutton();

	        Assert.assertFalse(signInPage.getEmailErrorText().isEmpty(),
	            "Expected validation error for invalid email: '" + email + "'");
	    }
	 
	 @Test
	 public void verify_SignInPage_Loadwith_EmailPasswordFields() {
		 Assert.assertTrue(signInPage.areLoginpasswordFieldDisplayed());
	 }
	 
	 
	
}
