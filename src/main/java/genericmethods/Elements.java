package genericmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.bytebuddy.asm.Advice.Return;

public class Elements {

	public static boolean bstatus;

	public static boolean checkCheckbox(WebDriver driver, By locator) {
		bstatus = Wait.waitForCheckboxChecked(driver, locator, Constants.maxWaitTime);
		if (bstatus) {
			try {
				doClick(driver, locator);
				return true;
			} catch (Exception e) {
				Messages.errorMsg = e.getMessage();
				System.out.println("unable checking the check box due to" + locator + Messages.errorMsg);
			}
		}
		return false;
	}
	
	
	

	public static boolean unSelectCheckBox(WebDriver driver, By locator) {
		bstatus =checkCheckbox(driver, locator);
		if(!bstatus) {
			try {
				doClick(driver, locator);
				return true;
			}
			catch (Exception e) {
			Messages.errorMsg = e.getMessage();
			System.out.println("Unchecking the check box due to :" +Messages.errorMsg);
			}
		}
		return false;
		
	}
	
	// click

	public static boolean doClick(WebDriver driver, By locator) {
		bstatus = Wait.waitForElementPresent(driver, locator, Constants.maxWaitTime);
		if (bstatus) {
			try {
				driver.findElement(locator).click();
				return true;
			} catch (Exception e) {
				System.out.println("unable to click" + locator + "due to" + Messages.errorMsg);
			}
		}
		return false;

	}

	public static boolean doSendKeys(WebDriver driver, By locator, String value, Duration waitTime) {
		bstatus = Wait.waitForElementPresent(driver, locator, waitTime);
		try {
			if (bstatus) {
				driver.findElement(locator).sendKeys(value);
			}
			return true;
		} catch (Exception e) {

		}
		return false;
	}
}
