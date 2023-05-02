package com.ninja.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninja.base.Base;

public class AccountSuccesspage extends Base{

	public AccountSuccesspage() throws IOException {
		super();
	 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='content']/p[contains(text(),'Congratulations! Your new account has been successfully created!')]")
	private WebElement accountSuccessPageHeading;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement emailAddressWarning;
	

	public String retrieveAccountSuccessPageHeading() {
		
		return accountSuccessPageHeading.getText();
	}
	
	public String retrieveDupliceEmailAddressWarning() {
		return emailAddressWarning.getText();
	}
	
}
