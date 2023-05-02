package com.ninja.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninja.base.Base;

public class Registerpage extends Base{

	public Registerpage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstNameField;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastNameField;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailAddressField ;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephoneField;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passwordField;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement passwordConfirmField;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement privacyField;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement privacyPolicyWarning ;
	
	@FindBy(xpath="//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	WebElement firstNameWarning ;
	
	@FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	WebElement lastNameWarning ;
	
	@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	WebElement emailWarning ;
	
	@FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	WebElement telephoneWarning ;
	
	@FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	WebElement passwordWarning;
	
public void enterFirstName(String firstNameText) {
	firstNameField.sendKeys(firstNameText);
}
public void enterLastName(String lastNameText) {
	lastNameField.sendKeys(lastNameText);
}
public void enterEmailAddress(String emailText) {
	emailAddressField.sendKeys(emailText);
}
public void enterTelephoneNumber(String telephoneText) {
	telephoneField.sendKeys(telephoneText);
}
public void enterPassword(String passwordText) {
	passwordField.sendKeys(passwordText);
}
public void enterConfirmPassword(String passwordText) {
	passwordConfirmField.sendKeys(passwordText);
}
public void selectPrivacyPolicy() {
privacyField.click();
}
public AccountSuccesspage clickOnContinueButton() throws IOException {
	continueButton.click();
	return new AccountSuccesspage();
}

public String retrievePrivacyPolicyWarning() {
	return privacyPolicyWarning.getText();
}
public String retrieveFirstNameWarning() {
	return firstNameWarning.getText();
}
public String retrieveLastNameWarning() {
	
	return lastNameWarning.getText();
}
public String retrieveEmailWarning() {
	return emailWarning.getText();
}
public String retrieveTelephoneWarning() {
	return telephoneWarning.getText();
}
public String retrievePasswordWarning() {
	return passwordWarning.getText();
}

public AccountSuccesspage register(String firstNameText,String lastNameText,String emailText,String telephoneText,String passwordText) throws IOException {
	firstNameField.sendKeys(firstNameText);
	lastNameField.sendKeys(lastNameText);
	emailAddressField.sendKeys(emailText);
	telephoneField.sendKeys(telephoneText);
	passwordField.sendKeys(passwordText);
	passwordConfirmField.sendKeys(passwordText);
	privacyField.click();
	continueButton.click();
	return new AccountSuccesspage();
	
}
}
