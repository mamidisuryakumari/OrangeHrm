package genericmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Table {
	public static boolean bstatus;

	public static boolean table(WebDriver driver, By locator) {
		bstatus = Wait.waitForTablePresent(driver, locator);
		if (bstatus) {
			try {
				return true;
			} catch (Exception e) {
				Messages.errorMsg = "Unable to get table data" + e.getMessage();
				System.out.println(Messages.errorMsg);

			}
		}
		return false;

	}
}
