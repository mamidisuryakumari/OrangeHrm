package genericmethods;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Window {
	public static boolean bstatus;
	
	public static boolean windowHandle(WebDriver driver,By locator) {
		bstatus =Wait.waitforWindowPresent(driver, locator);
		if(bstatus) {
			try {
				String parrnetWindowID =driver.getWindowHandle();
				System.out.println(parrnetWindowID);
				
				Set<String> handles = driver.getWindowHandles();
				System.out.println(handles);
				for (String hanndle : handles) {
					
					if(hanndle != parrnetWindowID)
					{
						driver.switchTo().window(hanndle);
						String title = driver.getTitle();
						System.out.println(title);
					}
					}
				}catch (Exception e) {
					Messages.errorMsg = "Unable to get handle due to" + e.getMessage();
					System.out.println(Messages.errorMsg);
			}
		}
		return false;
	}

}
