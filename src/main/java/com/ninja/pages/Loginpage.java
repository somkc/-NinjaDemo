package com.ninja.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninja.base.Base;

public class Loginpage extends Base {

	public Loginpage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailAddressField;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement noMatchEmailPassword;
	
	public void enterEmailAddress(String emailText) {
		
		emailAddressField.sendKeys(emailText);
		
	}
public void enterPassword(String passwordText) {
		
		passwordField.sendKeys(passwordText);
		
	}
public Accountpage clickOnLoginButton() throws IOException {
	
	loginButton.click();
	return new Accountpage();
	
}
public Accountpage login(String emailText,String passwordText) throws IOException {
	emailAddressField.sendKeys(emailText);
	passwordField.sendKeys(passwordText);
	loginButton.click();
	return new Accountpage();
	
}
public String retrieveWarningMessage() {
	return noMatchEmailPassword.getText();
}
	
}
