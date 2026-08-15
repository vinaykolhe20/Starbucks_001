package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.SignInPage;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SignInTest extends BaseTest{
	SignInPage signInPage;
	
	
	 @BeforeMethod
	    public void navigateToSignIn() {
	        HomePage homePage = new HomePage(driver);
	        homePage.homeSignIn();
	        signInPage = new SignInPage(driver);
	    }
	 //Data for invalid email id fields
	 @DataProvider(name = "invalidEmails")
	    public Object[][] invalidEmails() {
	        return new Object[][] {
	            { "" },                       // empty
	                  // double dot
	            { "   " }                   // whitespace only
	                     // TLD too short (edge case)
	        };
	    }
	 //Test for checking invalid email input from the data set
	 @Test(dataProvider = "invalidEmails", groups = {"regression", "auth", "negative"}, priority = 23)
	    public void verify_InvalidEmailFormats_ShowValidationError(String email) {
	        //log.info("TC23 [data-driven]: Testing invalid email -> " + email);
	        signInPage.enterEmail(email);
	        signInPage.enterPassword("SomePassword123");
	        signInPage.signInpagebutton();

	        Assert.assertFalse(signInPage.getEmailErrorText().isEmpty(),
	            "Expected validation error for invalid email: '" + email + "'");
	    }
	 
	 
	 
	 //Data for invalid password empty and space
	 @DataProvider(name = "invalidPasswords")
	    public Object[][] invalidPasswords() {
	        return new Object[][] {
	            { "" },                       // empty
	                  // double dot
	            { "   " }                   // whitespace only
	                     // TLD too short (edge case)
	        };
	    }
	 
	//Test for checking invalid email input from the data set
		 @Test(dataProvider = "invalidPasswords", groups = {"regression", "auth", "negative"}, priority = 24)
		    public void verify_InvalidPasswordFormats_ShowValidationError(String password) {
		        //log.info("TC23 [data-driven]: Testing invalid email -> " + email);
		        signInPage.enterEmail("someemail@gmail.com");
		        signInPage.enterPassword(password);
		        signInPage.signInpagebutton();

		        Assert.assertFalse(signInPage.getPasswordErrorText().isEmpty(),
		            "Expected validation error for invalid email: '" + password + "'");
		    }
		 
	 
	 @Test
	 public void verify_SignInPage_Loadwith_EmailPasswordFields() {
		 Assert.assertTrue(signInPage.areLoginpasswordFieldDisplayed());
	 }
	 
	 
	
}
