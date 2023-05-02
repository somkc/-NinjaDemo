package rough;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ninja.utils.MyExtentReport;

public class SearchTest {
	public WebDriver driver;

	@Test
	public void search() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
		driver.get("http://www.tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Apple");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	
		
	}
}
