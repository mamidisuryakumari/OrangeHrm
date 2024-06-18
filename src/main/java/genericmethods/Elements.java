package genericmethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
		bstatus = checkCheckbox(driver, locator);
		if (!bstatus) {
			try {
				doClick(driver, locator);
				return true;
			} catch (Exception e) {
				Messages.errorMsg = e.getMessage();
				System.out.println("Unchecking the check box due to :" + Messages.errorMsg);
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

	public static WebElement getWebElement(WebDriver driver, By locator) {
		bstatus = Verify.verifyElementVisible(driver, locator);
		if (bstatus) {
		WebElement elements = driver.findElement(locator);
			return elements;
		}
		Messages.errorMsg = locator + "is not vosible and is not used";
		System.out.println(Messages.errorMsg);
		return null;
	}



	public static List<WebElement> getWebElements(WebDriver driver, By locator) {
		bstatus = Verify.verifyElementVisible(driver, locator);
		if (bstatus) {
			List<WebElement> listElements = driver.findElements(locator);
			return listElements;
		}  
		Messages.errorMsg = locator + "is not visible and is not used";
		System.out.println(Messages.errorMsg);
		return null;
	}
	
	
	
	public static boolean selectDropDownByvisibleText(WebDriver driver,By locator,String sText) {
		bstatus =Wait.waitforElementPresent(driver, locator);
		if(bstatus) {
			try {
				Select dropdown = new Select(Elements.getWebElement(driver, locator));
				dropdown.selectByVisibleText(sText);
				return true;
			}catch (Exception e) {
				Messages.errorMsg ="Exception occured while selecting the text :"+e.getMessage();
				System.out.println(Messages.errorMsg);
			}
		}
		return false;		
		
	}
	
	
	public static boolean selectDropDownByIndex(WebDriver driver,By locator,int index) {
		bstatus =Wait.waitforElementPresent(driver, locator);
		if(bstatus) {
			try {
				Select dropdown = new Select(Elements.getWebElement(driver, locator));
				dropdown.selectByIndex(index);
				return true;
			}catch (Exception e) {
				Messages.errorMsg ="Exception occured while selecting the text :"+e.getMessage();
				System.out.println(Messages.errorMsg);
			}
		}
		return false;		
		
		
	}
	public static boolean selectDropDownByValue(WebDriver driver,By locator,String value) {
		bstatus =Wait.waitforElementPresent(driver, locator);
		if(bstatus) {
			try {
				Select dropdown = new Select(Elements.getWebElement(driver, locator));
				dropdown.selectByValue(value);
				return true;
			}catch (Exception e) {
				Messages.errorMsg ="Exception occured while selecting the text :"+e.getMessage();
				System.out.println(Messages.errorMsg);
			}
		}
		return false;		
		
		
	}
}
