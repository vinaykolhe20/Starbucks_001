package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AddToCart {

	
	WebDriver driver;
	public AddToCart(WebDriver driver) {
        this.driver = driver;
        
    }
	By menuLink = By.xpath("(//a[contains(text(),'Trending')])[1]");
	By itemtoCart = By.xpath("(//span[contains(text(),'mores Frappuccino')]/ancestor::a)[1]");
	
	By Add = By.xpath("(//button[contains(text(), 'Add to Order')])");
	
	public WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
	
	
	public void clickTrending() {
    	 waitForElement(menuLink).click();
    	 
    }
	
	public void getItemView() {
		waitForElement(itemtoCart).click();
	}
	
	public void AddtoCartButton() {
		waitForElement(Add).click();
	}
}
