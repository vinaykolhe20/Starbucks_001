package base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentVinay;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp(Method method) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.starbucks.com");
        handleCookiePopup();
        ExtentVinay.getInstance();
        ExtentVinay.test = ExtentVinay.extent
            .createTest(method.getName());
        
    }
    
    public WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
 // Add this in BaseTest.java after driver.get()
    public void handleCookiePopup() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement acceptBtn = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//button[contains(text(),'Accept')]")));
            acceptBtn.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            // No popup appeared, continue
            System.out.println("No cookie popup found");
        }
    }
    
 // Add this in BaseTest.java
    public void takeScreenshot(String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String path = "screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
        try {
            FileUtils.copyFile(src, new File(path));
            ExtentVinay.test.addScreenCaptureFromPath(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
    	if (result.getStatus() == ITestResult.FAILURE) {
            ExtentVinay.test.fail(result.getThrowable());
            takeScreenshot(result.getName());
        } else {
            ExtentVinay.test.pass("Test passed");
        }
        driver.quit();
    }
    @AfterSuite
    public void flushReport() {
        ExtentVinay.extent.flush();
    }
    
}
    

