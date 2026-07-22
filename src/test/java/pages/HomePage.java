package pages;

import java.awt.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;

    // Locators
    By menuLink = By.xpath("(//a[contains(text(),'Menu')])[1]");
    By signInBtn = By.xpath("//a[contains(text(),'Sign in')]");
    By searchIcon = By.xpath("//button[@aria-label='Search']");
    By searchInput   = By.xpath("//input[@placeholder='Search']");
    By searchResults = By.xpath("//ul[contains(@class,'search-results')]//li");
    
    
    //Homepage related locators
    //Homepage title @FindBy(css = "a[href='/']") WebElement logo;
    
    @FindBy(css="a[href='/']") WebElement logo;
    
    
    
 // Create a reusable wait method in BaseTest.java
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    public WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    
    //Here we replaced POM with pagefactory
//    public HomePage(WebDriver driver) {
//        this.driver = driver;
//    }

    public void clickMenu() {
    	 waitForElement(menuLink).click();
    }

    public void clickSignIn() {
        driver.findElement(signInBtn).click();
    }
    
    public void clickSearch() {
    	waitForElement(searchIcon).click();
    }
    
    public void enterSearchText(String drinkName) {
        WebElement input = waitForElement(searchInput);
        input.clear();
        input.sendKeys(drinkName);
    }
    // Testcase HP02
    public boolean logo() {
    	return logo.isDisplayed();
    }
    
    //

    // Get results list
}	


//1 - Verify homepage loads successfully with correct title "Starbucks Coffee Company"
//Verify Starbucks logo is displayed and links to homepage
//Verify main nav links (Menu, Rewards, Gift Cards) are visible and clickable
//Verify "Find a store" link navigates to store locator page
//Verify "Sign in" link navigates to sign-in page
//Verify "Join now" link navigates to account creation page
//Verify "Start an order" button navigates to Menu page
//Verify hero banner images load correctly
//Verify promotional carousel/banner "Learn more" and "Order now" links work
//Verify footer sections (About Us, Careers, Social Impact, etc.) are present
