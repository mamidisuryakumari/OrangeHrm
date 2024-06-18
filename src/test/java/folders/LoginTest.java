package folders;

import org.testng.annotations.Test;

import genericmethods.Constants;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void userLogin() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);

		// loginPage.login(properties.getProperty("userName"),properties.getProperty("password"),Constants.waitTime);

	//	loginPage.checkboxCheck(Constants.waitTime);
	//	Thread.sleep(5000);
	//	loginPage.uncheckboxCheck(Constants.waitTime);
		
	//	loginPage.selectDrodownText();
	//	loginPage.selectDrodownByIndex();
		
		loginPage.selectDropdownByValue();
	}
}
