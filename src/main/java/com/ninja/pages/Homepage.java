package com.ninja.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninja.base.Base;

public class Homepage extends Base {
	
	public Homepage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//span[normalize-space()='My Account']")
 private WebElement myAccountDropDown;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	private WebElement registerOption;
	

	@FindBy(xpath="	//a[normalize-space()='Login']")
	 private WebElement loginOption;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private   WebElement searchBoxField;
	
	@FindBy(xpath="//i[@class='fa fa-search']")
	private WebElement searchButton;
	
	public void clickMyAccount() {
		myAccountDropDown.click();
	}
	
	public Loginpage selectLoginOption() throws IOException {
		loginOption.click();
		return new Loginpage();
	}
	
	public Loginpage navigateToLoginPage() throws IOException {
		myAccountDropDown.click();
		loginOption.click();
		return new Loginpage();
		
	}

	public Registerpage selectRegisterOption() throws IOException {
		registerOption.click();
		return new Registerpage();
	}
	
	public Registerpage navigateToRegisterPage() throws IOException {
		myAccountDropDown.click();
		registerOption.click();
		return new Registerpage();
		
	}
	public void enterProductIntoSearchBoxField(String productText) {
		searchBoxField.sendKeys(productText);
	}
	
public Searchpage clickOnSearchButton() throws IOException {
	searchButton.click();
	return new Searchpage();
}
public Searchpage searchForAProduct(String productText) throws IOException {
	searchBoxField.sendKeys(productText);
	searchButton.click();
	return new Searchpage();
	
}
}
