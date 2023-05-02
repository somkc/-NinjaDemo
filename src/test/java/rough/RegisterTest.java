package rough;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninja.base.Base;
import com.ninja.utils.Util;

public class RegisterTest extends Base {
	public RegisterTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;
	@BeforeMethod
	public void setup() {
	intialize();
		
	}


	@Test
	public void register() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
		driver.get("http://www.tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();
        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Amar_");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Kane");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("Ray@hotmail.com");
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("04123456789");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String expected =driver.findElement(By.xpath("//div[@id='content']/p[contains(text(),'Congratulations! Your new account has been successfully created!')]")).getText();
		
		Assert.assertEquals(expected, "Congratulations! Your new account has been successfully created!");

	}
}
