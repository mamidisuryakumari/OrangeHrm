package folders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverManager;
import pages.LoginPage;


public class BaseTest {
	protected WebDriver driver;
	protected String filePath = "./src/test/resources/config.properties";
	protected Properties properties;
	protected FileInputStream fileInputStream;
	
	@BeforeMethod	
	public void startDriver() throws IOException, InterruptedException{
		driver = new DriverManager().initializeDriver();
		properties = new Properties(); 
		fileInputStream = new FileInputStream(filePath);
		properties.load(fileInputStream);
		fileInputStream.close();
		driver.get(properties.getProperty("baseUrl"));
		Thread.sleep(10000);
	}
	@AfterMethod	
	public void quitDriver() {
		//driver.quit();
		
	}
	  

}
