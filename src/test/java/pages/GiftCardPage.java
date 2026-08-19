package pages;


import org.apache.logging.log4j.Logger;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.LogUtils;

public class GiftCardPage {

	
	private static final Logger log = LogUtils.getLogger(GiftCardPage.class);
    WebDriver driver;

    public GiftCardPage(WebDriver driver) {
        this.driver = driver;
    }

    private void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//h2[contains(text(),'FEATURED')] | //h2[contains(text(),'Featured')]")));
    }

    public int getCardCountInCategory(String categoryName) {
        waitForPageLoad();
        log.info("Counting gift cards in category: " + categoryName);

        // XPath: find the heading matching categoryName, then get cards inside 
        // its following sibling container
        String xpath = String.format(
            "//h2[contains(text(),'%s')]/following-sibling::*[1]//img", 
            categoryName
        );

        List<WebElement> cards = driver.findElements(By.xpath(xpath));
        log.info(categoryName + " section has " + cards.size() + " cards");
        return cards.size();
    }
}
