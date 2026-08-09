package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LogUtils;

import java.time.Duration;

public class JoinNowPage {

    private static final Logger log = LogUtils.getLogger(JoinNowPage.class);
    WebDriver driver;

    // ---- Form fields ----
    @FindBy(id = "firstName") WebElement firstNameField;
    @FindBy(id = "lastName") WebElement lastNameField;
    @FindBy(id = "emailAddress")
    WebElement emailField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(css = "button[type='submit']") WebElement joinSubmitButton;

 // ---- Validation/error elements ----
    @FindBy(xpath="//span[contains(text(),'email address.')]") WebElement emailError;
	@FindBy(xpath="//span[contains(text(),'Enter a password.')]") WebElement passwordError;
	//------------------Password Validation--------------------------------
	@FindBy(css = "div.sb-expander") WebElement passwordValidationSection;
	
	
    
    // ---- Constructor ----
    public JoinNowPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ---- Wait helper (same pattern as HomePage/SignInPage) ----
    private WebElement waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // ---- Actions ----
    public void enterFirstName(String firstName) {
        log.info("Entering first name: " + firstName);
        waitForElement(firstNameField).clear();
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        log.info("Entering last name: " + lastName);
        waitForElement(lastNameField).clear();
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        log.info("Entering registration email: " + email);
        waitForElement(emailField).clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        log.info("Entering registration password");
        waitForElement(passwordField).clear();
        passwordField.sendKeys(password);
    }

    public void clickJoinSubmit() {
        log.info("Clicking Join Now submit button");
        joinSubmitButton.click();
    }

    // ---- Validations / Assertions support ----
    public boolean areRequiredFieldsDisplayed() {
        log.info("Checking first name, email, and password fields are displayed");
        return waitForElement(firstNameField).isDisplayed()
                && waitForElement(emailField).isDisplayed()
                && waitForElement(passwordField).isDisplayed();
    }

    public String getEmailErrorText() {
        log.info("Getting email validation error text");
        return waitForElement(emailError).getText().trim();
    }

    public String getPasswordErrorText() {
        log.info("Getting password validation error text");
        return waitForElement(passwordError).getText().trim();
    }

    public boolean isPasswordValidationSectionShown() {
        try {
            return passwordValidationSection.isDisplayed();
        } catch (Exception e) {
            log.warn("Password validation section not found");
            return false;
        }
    }
    
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}