package com.ninja.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninja.base.Base;

public class Accountpage extends Base{

	public Accountpage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[normalize-space()='Edit your account information']")
	WebElement editYourAccountInformationOption;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement warningNoEmailPassword;
	
	
	public boolean getDisplayStatusofEditYourAccountInformationOption() {
	boolean displayStatus=	editYourAccountInformationOption.isDisplayed();
	return displayStatus;
	}
	
	public String retrieveEmailPasswordNotMatchingWarningMessage() {
		return	warningNoEmailPassword.getText();
		
		}
}
