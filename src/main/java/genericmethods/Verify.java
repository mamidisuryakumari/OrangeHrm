package genericmethods;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.StaticInitializerCoercer;

public class Verify {

	public static boolean bstatus;

	public static boolean verifyElementVisible(WebDriver driver, By locator) {
		try {
			bstatus = driver.findElement(locator).isDisplayed();
			System.out.println("Element" + locator + "is visible");
			return bstatus;
		} catch (Exception e) {
			System.out.println("Element" + locator + "is  not visible");

		}
		return false;
	}

	public static boolean verifyCheckboxChecked(WebDriver driver, By locator) {
		bstatus = verifyElementVisible(driver, locator);
		if (bstatus) {
			try {
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		bstatus = driver.findElement(locator).isSelected();
		if (bstatus) {
			try {
				return true;
			} catch (Exception e) {
				System.out.println("unable to select the checkbox" + e);
			}

		}
		return false;

	}
	
	
	

	public static boolean verifyElementPresent(WebDriver driver, By locator) {
		try {
			driver.findElement(locator);
			System.out.println("Element" + locator + " is present in DOM");
			return true;
		} catch (Exception e) {
			System.out.println("Element" + locator + " is not present in DOM");
		}
		return false;
	}

	public static boolean verifyTextVisible(WebDriver driver, String text) {
		try {
			bstatus = driver.getPageSource().contains(text);
			if (bstatus) {
				System.out.println("The Text" + text + " is present in the current page");
				return true;
			}
		} catch (Exception e) {
			System.out.println("The Text" + text + " is not found in the current page");
		}
		return false;
	}

	public static boolean verifyTextVisible(WebDriver driver, By locator, String text) {

		bstatus = verifyElementVisible(driver, locator);
		if (!bstatus) {
			System.out.println("The text is not present in the element");
			return false;
		}
		try {
			bstatus = driver.findElement(locator).getText().contains(text);
			if (bstatus) {
				System.out.println("The Text" + text + "is present in the element" + locator);
				return true;
			}
		} catch (Exception e) {
			System.out.println("The Text" + text + "is not present in the locator" + locator);
		}
		return false;
	}

	public static boolean verifyChecked(WebDriver driver, By locator) {
		bstatus = verifyElementVisible(driver, locator);
		if (!bstatus) {
			System.out.println("The checkbox is not visible");
			return false;
		}
		try {
			bstatus = driver.findElement(locator).isSelected();
			if (bstatus) {
				System.out.println("The check box has already been selected");
				return true;
			}
		} catch (Exception e) {
			System.out.println("The check box is not selected");
		}
		return false;
	}

	public static boolean verifyFileExists(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			System.out.println(fileName + "exist in directory");
			return true;
		}
		System.out.println(fileName + "does not exist in the directory");
		return false;
	}

	public static boolean verifyElementClikable(WebDriver driver, By locator) {
		bstatus = verifyElementVisible(driver, locator);
		if (!bstatus) {
			System.out.println("Element is not clickable");
			return false;
		}
		try {
			WebElement element = driver.findElement(locator);
			element.click();
			System.out.println("Element is clickable");
			return true;

		} catch (Exception e) {
			System.out.println("Element is not clickable");

		}
		return false;
	}

}
