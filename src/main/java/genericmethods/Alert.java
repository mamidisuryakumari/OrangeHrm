package genericmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.bytebuddy.asm.Advice.Return;

public class Alert {
	public static boolean bstatus;

	public static boolean acceptAlert(WebDriver driver,By locator) {

		bstatus = Wait.waitforAlertPresent(driver, locator);
		if (bstatus) {
			try {

				driver.switchTo().alert().accept();
				return true;

			} catch (Exception e) {
				Messages.errorMsg = "Unable to accept Alert message due to" + e.getMessage();
				System.out.println(Messages.errorMsg);
			}
		}
		return false;
	}
	

	public static boolean acceptDismiss(WebDriver driver, By locator) {

		bstatus = Wait.waitforAlertPresent(driver, locator);
		if (bstatus) {
			try {

				driver.switchTo().alert().dismiss();
				return true;

			} catch (Exception e) {
				Messages.errorMsg = "Alert is not accepted" + e.getMessage();
				System.out.println(Messages.errorMsg);
			}
		}
		return false;
	}
	
	public static String getAlertMessage(WebDriver driver,By locator)
	{
		bstatus= Wait.waitforAlertPresent(driver, locator);
		if(bstatus)
		{ 
			String alertMessag =  driver.switchTo().alert().getText();
			return alertMessag;
		}
		return null;
	}
	

}
