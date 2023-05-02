package com.ninja.testcases;



import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ninja.base.Base;
import com.ninja.pages.AccountSuccesspage;
import com.ninja.pages.Homepage;
import com.ninja.pages.Registerpage;
import com.ninja.utils.Util;

public class RegisterTest extends Base{
	
	Registerpage registerpage;
	AccountSuccesspage accountsuccesspage;
	public RegisterTest() throws IOException {
		super();
		
	}
	@BeforeMethod
	public void setup() throws IOException {
	intialize();
	Homepage homepage=new Homepage();
	
	registerpage=homepage.navigateToRegisterPage();
	
		
	}

	@Test(priority=1)
	public void verifyRegisteringAccountByProvidingAllFields() throws IOException {
		
		//Registerpage registerpage= new Registerpage();
		accountsuccesspage=registerpage.register("Amar", "kane", "Amar"+Util.getRandomEmail()+"@hotmail.com", "04123456789", "12345");
		
		
	  // AccountSuccesspage accountsuccesspage = new AccountSuccesspage();
	
		
		Assert.assertEquals(accountsuccesspage.retrieveAccountSuccessPageHeading(), "Congratulations! Your new account has been successfully created!");
		
		
	}
	@Test(priority=2)
	public void verifyRegisteringAccountWithExistingEmailAddress() throws IOException {
		
		//Registerpage registerpage= new Registerpage();
		accountsuccesspage=registerpage.register("Amar", "kane", "som.jasban@gmail.com", "04123456789", "12345");
		
		
	  // AccountSuccesspage accountsuccesspage = new AccountSuccesspage();
	
		
		Assert.assertEquals(accountsuccesspage.retrieveDupliceEmailAddressWarning(), "Warning: E-Mail Address is already registered!");
		
		
	}
	@Test(priority=3)
	public void verifyRegisteringAccountWithouFillingAnyDetails() throws IOException {
		//Registerpage registerpage= new Registerpage();
		accountsuccesspage= registerpage.clickOnContinueButton();
		String actualPrivacyPolicyWarning=registerpage.retrievePrivacyPolicyWarning();
		Assert.assertTrue(actualPrivacyPolicyWarning.contains("Warning: You must agree to the Privacy Policy!"),"Warning message regarding privacy policy is not displayed ");
		String actualFirstNameWarning=registerpage.retrieveFirstNameWarning();
		Assert.assertTrue(actualFirstNameWarning.contains("First Name must be between 1 and 32 characters!"),"Warning message regarding First Name  is not displayed ");
		String actualLastNameWarning=registerpage.retrieveLastNameWarning();
		Assert.assertTrue(actualLastNameWarning.contains("Last Name must be between 1 and 32 characters!"),"Warning message regarding Last Name is not displayed ");
		String actualEmailWarning=registerpage.retrieveEmailWarning();
		Assert.assertTrue(actualEmailWarning.contains("E-Mail Address does not appear to be valid!"),"Warning message regarding Email is not displayed ");
		String actualTelephone=registerpage.retrieveTelephoneWarning();
		Assert.assertTrue(actualTelephone.contains("Telephone must be between 3 and 32 characters!"),"Warning message regarding Telephone is not displayed ");
		String actualPasswordWarning=registerpage.retrievePasswordWarning();
		Assert.assertTrue(actualPasswordWarning.contains("Password must be between 4 and 20 characters!"),"Warning message regarding Password  is not displayed ");
		
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}


