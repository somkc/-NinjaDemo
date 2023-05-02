package com.ninja.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ninja.config.Constants;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	FileInputStream fis;
	
	
	public Base() throws IOException {
		prop= new Properties();
		try {
			fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ninja\\config\\config.properties");
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		prop.load(fis);
		
		
	}
	public static void intialize() {
		String browserName=prop.getProperty("Browser").toLowerCase();
		String url=prop.getProperty("Url");
		switch(browserName) {
		case "chrome":
			driver= new ChromeDriver();
			break;
		case "firefox":
			driver= new FirefoxDriver();
			break;
		case "edge":
			driver= new EdgeDriver();
			break;
			default:
				System.out.println("Invalid Browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_TIMEOUT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_TIMEOUT));
		driver.get(url);
		
	}

}
