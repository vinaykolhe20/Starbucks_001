package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WhatsIncluded {

	
	WebDriver driver;
	
	public WhatsIncluded(WebDriver driver) {
        this.driver = driver;
         
    }

	
	
	
	public void selectDrink(String option) {
     //   By drop = By.xpath("//select[@aria-label='Lemonade']");
        By dropMilk = By.xpath("//select[@aria-describedby='milk-options-one-select-secondaryLabel']");
        
        
       // By dro2 = By.xpath("//select[@aria-label='Lemonade']");
        
        WebElement dropdownElement = driver.findElement(dropMilk);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(option);
    }
	
	 
}
