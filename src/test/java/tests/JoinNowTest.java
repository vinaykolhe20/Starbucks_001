package tests;

import base.BaseTest;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JoinNowPage;
import utils.ExcelUtility;
import utils.LogUtils;

public class JoinNowTest extends BaseTest {

    private static final Logger log = LogUtils.getLogger(JoinNowTest.class);
    JoinNowPage joinNowPage;

    @BeforeMethod
    public void navigateToJoinNow() {
        HomePage homePage = new HomePage(driver);
        homePage.homeJoinNow();
        joinNowPage = new JoinNowPage(driver);
    }

    @Test(groups = {"smoke", "auth"}, priority = 27)
    public void verify_JoinNowForm_LoadsRequiredFields() {
        log.info("TC27: Verifying Join Now form loads required fields");
        Assert.assertTrue(joinNowPage.areRequiredFieldsDisplayed());
    }

    // ---------- Email validation, Excel-driven ----------

    @DataProvider(name = "joinNowEmails")
    public Object[][] joinNowEmails() {
        return ExcelUtility.getTestData("JoinNowEmails");
    }

    @Test(dataProvider = "joinNowEmails",
          groups = {"regression", "auth", "negative"}, priority = 27)
    public void verify_JoinNow_InvalidEmail_ShowsValidationError(String email, String expectedResult, String description) {
        log.info("TC27 [Excel-driven]: " + description + " -> email='" + email + "'");
        joinNowPage.enterEmail(email);
        joinNowPage.enterPassword("ValidPass123!");
        joinNowPage.clickJoinSubmit();

        Assert.assertFalse(joinNowPage.getEmailErrorText().isEmpty(),
            "Expected validation error for: " + description + " (email: '" + email + "')");
    }

    // ---------- Password strength, Excel-driven ----------

    @DataProvider(name = "joinNowPasswords")
    public Object[][] joinNowPasswords() {
        return ExcelUtility.getTestData("JoinNowPasswords");
    }

    @Test(dataProvider = "joinNowPasswords",
          groups = {"regression", "auth"}, priority = 28)
    public void verify_JoinNow_PasswordStrengthValidation(String password, String expectedResult, String description) {
        log.info("TC28 [Excel-driven]: " + description + " -> password='" + password + "', expected=" + expectedResult);
        joinNowPage.enterEmail("uniqueTestUser" + System.currentTimeMillis() + "@example.com");
        joinNowPage.enterPassword(password);
        joinNowPage.clickJoinSubmit();

        Assert.assertTrue(joinNowPage.isPasswordValidationSectionShown(),
                "Expected password validation feedback to be shown for: " + description);
    }
}