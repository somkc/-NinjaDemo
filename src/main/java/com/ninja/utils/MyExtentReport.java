package com.ninja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyExtentReport {
	
	public  static ExtentReports generateExtentReport() {
		
		ExtentReports extentReport= new ExtentReports();
		File file= new File(System.getProperty("user.dir")+"//test-output/ExtentReports//extentreport.html");
		
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Test Automation Ninja Results");
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");
		extentReport.attachReporter(spark);
		
		Properties prop=new Properties();
		FileInputStream fis;
		try {
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ninja\\config\\config.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentReport.setSystemInfo("Browser", prop.getProperty("Browser"));
		extentReport.setSystemInfo("URL", prop.getProperty("Url"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("Username", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extentReport;
	}
	
	public static void main(String args[]) {
		generateExtentReport();
	}

}
