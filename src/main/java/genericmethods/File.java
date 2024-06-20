package genericmethods;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.util.Assert;

public class File {

	public static boolean bstatus;

	public static boolean fileUpload(WebDriver driver, By locator) {
	
		try {
	        bstatus = Wait.waitForFileExist(driver, locator);
	        if (!bstatus) {
	            throw new Exception("file not found");
	        }
	   
	    } catch (Exception e) {
	        Messages.errorMsg = "An unexpected error occurred: " + e;
	        System.out.println(Messages.errorMsg);
	        return false;
	    }
	    
		if (bstatus) {
			Elements.doSendKeys(driver, locator, Constants.filePath);
			return true;

		}
		
		return false;
	}
}
