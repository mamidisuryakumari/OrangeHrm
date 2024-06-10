package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import genericmethods.Elements;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private final By userNameFld = By.name("username");
	private final By passwordFld = By.name("password");
	private final By submitBtn = By.xpath("//button[@type='submit']");
	


	
	public HomePage login(String userName,String password,Duration waitTime) {
		Elements.doSendKeys(driver, userNameFld, password, waitTime);
		Elements.doSendKeys(driver, passwordFld, password, waitTime);
		Elements.doClick(driver,submitBtn, waitTime);
		return new HomePage(driver);
	}

	
}
