package base;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.starbucks.com");
        
        
    }
 // Add this in BaseTest.java after driver.get()
    public void handleCookiePopup() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement acceptBtn = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[contains(text(),'Accept')]")));
            acceptBtn.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            // No popup appeared, continue
            System.out.println("No cookie popup found");
        }
    }
    
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    
    
}
    

