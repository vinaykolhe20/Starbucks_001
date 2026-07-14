package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NutritionBlock {

    WebDriver driver;
    WebDriverWait wait;        // ✅ add wait as class field

    // Constructor
    public NutritionBlock(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15)); // ✅ initialize here
    }

    // Locators
    By ingredientsList = By.xpath("(//a[contains(text(),'Full nutrition & ingredients list')])[1]");
    //By nutrition = By.xpath("//span[contains(text(),'Nutrition')]"); // ✅ use data-e2e

    // Click ingredients link
    public void clickIngredients() {
    	WebElement element = wait.until(ExpectedConditions
    	        .presenceOfElementLocated(ingredientsList));  // ✅ presence not clickable
    	    ((JavascriptExecutor) driver)
    	        .executeScript("arguments[0].scrollIntoView(true);", element); // ✅ scroll to it
    	    ((JavascriptExecutor) driver)
    	        .executeScript("arguments[0].click();", element);
    }

    // Check nutrition section visible
    public boolean isNutritionSectionDisplayed() {
        try {
            WebElement nutritionEl = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[contains(text(),'Nutrition')]")));  // ✅ uses class-level wait
            return nutritionEl.isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Nutrition section not found");
            return false;
        }
    }
}