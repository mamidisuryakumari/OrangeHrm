



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class FileUpload {
	@Test
	public void fileUploadMethod() {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://omayo.blogspot.com/");
	driver.findElement(By.id("uploadfile")).sendKeys("C:\\\\Users\\\\kumar\\\\OneDrive\\\\Pictures\\\\peakpx123.jpg");
	

	
    

}
}
