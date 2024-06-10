package genericmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Elements {

	public static boolean bstatus;

	public static boolean selectCheckbox(WebDriver driver, By locator, Duration time) {
		try {
			bstatus = Wait.waitForCheckboxChecked(driver, locator, time);
			if (bstatus) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(" Element" + locator + " has not been selected");
		}
		return false;
	}

	public static boolean unSelectCheckBox(WebDriver driver, By locator, Duration time) {
		try {
			bstatus = Wait.waitForCheckboxChecked(driver, locator, time);
			if (bstatus) {
				driver.findElement(locator).click();
				System.out.println("The checckbox  has been deselected successfully");
				return true;
			}
		} catch (Exception e) {
			System.out.println("can not unchecck the checkbox ");
		}
		return false;
	}

	public static boolean doClick(WebDriver driver, By locator, Duration waitTime) {
		bstatus = Wait.waitForElementPresent(driver, locator, waitTime);
		try {
			if (bstatus) {
				driver.findElement(locator).click();
				System.out.println("The button " + locator + " clicked successfully");
				return true;
			}

		} catch (Exception e) {
			System.out.println("The button" + locator + " is not clicked successfully");
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
