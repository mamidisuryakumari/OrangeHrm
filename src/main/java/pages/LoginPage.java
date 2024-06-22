package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import genericmethods.Alert;
import genericmethods.Constants;
import genericmethods.Elements;
import genericmethods.File;
import genericmethods.Table;
import genericmethods.Verify;
import genericmethods.Wait;
import genericmethods.Window;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private final By userNameFld = By.name("username");
	private final By passwordFld = By.name("password");
	private final By submitBtn = By.xpath("//button[@type='submit']");

	private final By checkBox = By.id("hindichbx");

	private final By dropDown = By.id("course");

	private final By alertConfirmButton = By.id("confirmBox");

	private final By newWindowButton = By.id("newWindowBtn");
	private final By firstNameField = By.id("firstName");

	private final By uploadFile = By.id("uploadfile");

	private final By tableid = By.xpath("//table[@id='customers']");

	// public HomePage login(String userName,String password,Duration waitTime) {
	// Elements.doSendKeys(driver, userNameFld, password, waitTime);
	// Elements.doSendKeys(driver, passwordFld, password, waitTime);
	// Elements.doClick(driver,submitBtn, waitTime);
	// return new HomePage(driver);
	// }

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
		Elements.selectDropDownByIndex(driver, dropDown, Constants.dropdownIndex);
		return this;
	}

	public LoginPage selectDropdownByValue() {
		Elements.selectDropDownByValue(driver, dropDown, Constants.dropdownValue);
		return this;
	}

	public LoginPage acceptAlert() {
		Alert.acceptAlert(driver, alertConfirmButton);
		return this;
	}

	public LoginPage windowHandle() {
		Window.windowHandle(driver, newWindowButton);
		Elements.doSendKeys(driver, firstNameField, Constants.firstName);
		return this;
	}

	public LoginPage uploadFile() {
		File.fileUpload(driver, uploadFile);
		return this;

	}

	public LoginPage table() {
		Table.table(driver, tableid);
		return this;
	}
}
