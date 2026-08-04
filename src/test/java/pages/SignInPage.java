package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

	WebDriver driver;

	@FindBy(id = "username") WebElement username;
	@FindBy(id = "password") WebElement userPswd;
	@FindBy(xpath = "//a[contains(text(),'store')]") WebElement store;
	@FindBy(xpath="//button[contains(text(),'SignIn')]") WebElement signIn;
	
	
	@FindBy(xpath="//span[contains(text(),'Username or email address')]") WebElement enterEmail;
	@FindBy(xpath="//span[contains(text(),'Password')]") WebElement enterPassword;
	
	@FindBy(xpath="//span[contains(text(),'Enter an email/username.')]") WebElement emailError;
	@FindBy(xpath="//span[contains(text(),'Enter a password.')]") WebElement passwordError;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private WebElement waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public boolean areLoginpasswordFieldDisplayed() {
		return waitForElement(username).isDisplayed() && waitForElement(userPswd).isDisplayed();
	}
	
	public void signInpagebutton() {
		signIn.click();
	}
	
	public void enterEmail(String email) {
        //log.info("Entering email: " + email);
        waitForElement(enterEmail).clear();
        enterEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
       // log.info("Entering password");
        waitForElement(enterPassword).clear();
        enterPassword.sendKeys(password);
    }
    
    
    
    
}
