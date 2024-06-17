package genericmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	private static boolean bstatus;
	private WebDriverWait wait;

	public static boolean waitForElementPresent(WebDriver driver, By locator, Duration timeout) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
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

	public static boolean waitForElementClikable(WebDriver driver, By locator, Duration timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			System.out.println("Element " + locator + " is clickable");
			return true;
		} catch (Exception e) {
			System.out.println("Element" + locator + " is not clickable after waiting");
		}
		return false;
	}

	public static boolean waitForElementVisible(WebDriver driver, By locator, Duration timeout) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));

			return true;
		} catch (Exception e) {
			System.out.println("Element" + locator + " is not visible after waiting");
		}
		return false;
	}
}