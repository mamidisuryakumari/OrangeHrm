package genericmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.annotations.VisibleForTesting;

public class Wait {

	private static boolean bstatus;
	private WebDriverWait wait;

	public static boolean waitForElementVisible(WebDriver driver, By locator) {
		try {
			new WebDriverWait(driver,Constants.maxWaitTime).until(ExpectedConditions.visibilityOfElementLocated(locator));
			bstatus = Verify.verifyElementVisible(driver, locator);
			if (bstatus) {
				return true;
			}
		} catch (Exception e) {
			Messages.errorMsg = e.getMessage();
			System.out.println("Element" + locator + "is not found" + Messages.errorMsg);
		}
		return false;
	}

	public static boolean waitForCheckboxChecked(WebDriver driver, By locator, Duration timeout) {

		new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
		bstatus = Verify.verifyCheckboxChecked(driver, locator);

		if (!bstatus) {
			try {
				return true;
			} catch (Exception e) {
				System.out.println("Exception is occured when checkbox is checked" + e);
			}
			return false;
		}
		return false;
	}
	
	
	public static boolean waitforElementPresent(WebDriver driver,By locator) {
		new WebDriverWait(driver, Constants.maxWaitTime).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		bstatus = Verify.verifyElementPresent(driver, locator,Constants.searchText);
		if(bstatus) {
			try {
				return true;
			}catch (Exception e) {
				Messages.errorMsg =e.getMessage();
				System.out.println("Element not present due to :"+Messages.errorMsg);
			}
		}
		return false;
	}

	
	public static boolean waitforAlertPresent(WebDriver driver,By locator) {
		new WebDriverWait(driver, Constants.maxWaitTime).until(ExpectedConditions.visibilityOfElementLocated(locator));
		bstatus =Verify.verifyAlertPresent(driver, locator);
		if (bstatus) {
			
			try {
				return true;
				
			} catch (Exception e) {
				System.out.println("Unable to get the alert popup due to :"+e.getMessage());
			}
			
		}
		return false;
	}
	
	public static boolean waitforWindowPresent(WebDriver driver,By locator) {
		new WebDriverWait(driver,Constants.maxWaitTime).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		bstatus =Verify.verifyWindowPresent(driver, locator);
		if(bstatus) {
			try {
				return true;
			}catch (Exception e) {
				System.out.println("Unable to get the window due to"+e.getMessage());
			}
		}
		return false;
	}
	
	public static Boolean waitForFileExist(WebDriver driver,By locator)
	{
		new WebDriverWait(driver, Constants.maxWaitTime).until(ExpectedConditions.visibilityOfElementLocated(locator));
		bstatus=  Verify.verifyFileExist(driver, locator, Constants.filePath);
		if(bstatus)
		{
			try {
				return true;
				
			} catch (Exception e) {
				System.out.println("Exception occured when fecthing the file: "+e.getMessage());
			}
		}
		
		return false;
	}
	
}