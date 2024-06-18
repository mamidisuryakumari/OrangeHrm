package genericmethods;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Verify {

	public static boolean bstatus;

	public static boolean verifyElementVisible(WebDriver driver, By locator) {
		bstatus = driver.findElement(locator).isDisplayed();
		if (bstatus) {
			return true;
		}

		Messages.errorMsg = locator + "not visible";
		System.out.println(Messages.errorMsg);
		return false;
	}

	public static boolean verifyCheckboxChecked(WebDriver driver, By locator) {
		bstatus = verifyElementVisible(driver, locator);
		if (!bstatus) {
			System.out.println("check box has not be checked because" + Messages.errorMsg);
			return false;
		}
		bstatus = driver.findElement(locator).isSelected();
		if (bstatus) {
			try {
				return true;
			} catch (Exception e) {
				System.out.println(locator + "is not checked");
			}

		}
		return false;

	}

	// Dropdowns

	public static boolean verifyElementPresent(WebDriver driver, By locator, String sText) {
		Select select = new Select(Elements.getWebElement(driver, locator));
		List<WebElement> list = select.getOptions();
		for (WebElement webElement : list) {
			if (webElement.getText().equals(sText)) {
				return true;
			}
		}

		Messages.errorMsg = sText + "Is not present in" + locator;
		System.out.println(Messages.errorMsg);
		return false;
	}
	
	

	

}
