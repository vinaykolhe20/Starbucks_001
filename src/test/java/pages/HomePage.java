package pages;

import java.awt.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    
 // Create a reusable wait method in BaseTest.java
    public WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

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

    // Get results list
}	
