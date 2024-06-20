import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Table {
	@Test
	public void tableMethod() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/2021/08/webtable-in-html.html");
		//no of columns
		List<WebElement> allHeaders=driver.findElements(By.xpath("//table[@id='customers']//th"));
		System.out.println(allHeaders.size());
		
		//no of rows
		List<WebElement> allRows=driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println(allRows.size());
		
		List<WebElement> allData=driver.findElements(By.xpath("//table[@id='customers']//td"));
		System.out.println(allData);
		
	}

}
