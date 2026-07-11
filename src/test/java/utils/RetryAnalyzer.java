package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

//Create RetryAnalyzer.java in utils/
public class RetryAnalyzer implements IRetryAnalyzer {
 int count = 0;
 int maxRetry = 2;

 public boolean retry(ITestResult result) {
     if (count < maxRetry) {
         count++;
         return true;
     }
     return false;
 }


//Apply to tests
@Test(retryAnalyzer = RetryAnalyzer.class)
public void verifyMenuNavigation() {
 // test code
}

}