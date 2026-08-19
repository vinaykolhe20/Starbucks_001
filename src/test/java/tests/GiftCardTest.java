package tests;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.GiftCardPage;
import pages.HomePage;
import pages.SignInPage;
import utils.LogUtils;

public class GiftCardTest extends BaseTest{
	private static final Logger log = LogUtils.getLogger(GiftCardPage.class);
	

	@BeforeMethod
	public void GiftCardTest() {
        HomePage homePage = new HomePage(driver);
        homePage.homeGifts();
        
        
    }
	
	
	@Test(groups = {"regression", "giftcards"}, priority = 41)
	public void verify_FeaturedSection_LoadsCorrectNumberOfCards() {
	    log.info("TC41: Verifying Featured section card count");
	    
	    int actualCount = GiftCardPage.getCardCountInCategory("FEATURED");
	    int expectedCount = 4;  // from your screenshot — adjust if this changes
	    
	    Assert.assertEquals(actualCount, expectedCount,
	        "Expected " + expectedCount + " cards in Featured section, but found " + actualCount);
	}
}
