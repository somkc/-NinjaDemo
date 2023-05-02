package com.ninja.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ninja.base.Base;
import com.ninja.utils.MyExtentReport;
import com.ninja.utils.Util;

public class MyListeners implements ITestListener {
	ExtentReports extentreports;
	ExtentTest extentTest;
	@Override
	public void onStart(ITestContext context) {
		
		extentreports=MyExtentReport.generateExtentReport();
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName=result.getName();
		 extentTest= extentreports.createTest(testName);
		extentTest.log(Status.INFO, testName+" started Executing");
		
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS, result.getName()+" got Successfully Executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
	try {
		Base.driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String destinationScreenshotPath= Util.getScreenshot(result.getName());
	   extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
	   extentTest.log(Status.INFO,result.getThrowable());
	   extentTest.log(Status.FAIL,result.getName()+" gotFailed");
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+" got Skipped");
	
	}

	

	@Override
	public void onFinish(ITestContext context) {
		extentreports.flush();
		String pathOfExtentReports=System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreport.html";
		File extentReport = new File(pathOfExtentReports);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
