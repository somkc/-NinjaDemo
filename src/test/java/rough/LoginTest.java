package rough;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	public WebDriver driver ;
	
	@Test
	public void verifyLoginWithValidCredentials() {
    driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
		driver.get("http://www.tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("som.jasban@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("sagarsomaiah");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Edit your account information']")).isDisplayed());
		
		driver.quit();
		
		
	}
	
	@Test
	public void verifyLoginWithInValidCredentials() {
	    driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
			driver.get("http://www.tutorialsninja.com/demo/");
			driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
			driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("som.@gmail.com");
			driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			String actualMessage=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
			String expectedMessage="Warning: No match for E-Mail Address and/or Password.";
			Assert.assertTrue(actualMessage.contains("Warning: No match for E-Mail Address and/or Password."),expectedMessage);
			
			driver.quit();
			
			
		}

}
