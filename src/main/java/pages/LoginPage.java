package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import genericmethods.Alert;
import genericmethods.Constants;
import genericmethods.Elements;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private final By userNameFld = By.name("username");
	private final By passwordFld = By.name("password");
	private final By submitBtn = By.xpath("//button[@type='submit']");
	
    private final By checkBox = By.id("hindichbx");
    
    private final By dropDown =By.id("course");
    
    private final By alert =By.id("confirmBox");
		
	

	
	//public HomePage login(String userName,String password,Duration waitTime) {
		//Elements.doSendKeys(driver, userNameFld, password, waitTime);
		//Elements.doSendKeys(driver, passwordFld, password, waitTime);
	//	Elements.doClick(driver,submitBtn, waitTime);
	//	return new HomePage(driver);
	//}
    
    public LoginPage checkboxCheck(Duration waitTime) {
    	Elements.checkCheckbox(driver, checkBox);
    	return this;
    }

	public LoginPage uncheckboxCheck(Duration waitTime) {
		Elements.unSelectCheckBox(driver, checkBox);
		return this;
	}
	
	public LoginPage selectDrodownText() {
		Elements.selectDropDownByvisibleText(driver, dropDown, Constants.searchText);
		return this;
	}
	
	public LoginPage selectDrodownByIndex() {
		Elements.selectDropDownByIndex(driver, dropDown,Constants.dropdownIndex);
		return this;
	}
	
	public LoginPage selectDropdownByValue() {
		Elements.selectDropDownByValue(driver, dropDown,Constants.dropdownValue);
		return this;
	}
	
	public LoginPage acceptAlert() {
	Elements.doClick(driver, alert);
	Alert.acceptAlert(driver, alert);
	return this;
	}
}
