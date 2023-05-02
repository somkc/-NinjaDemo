package com.ninja.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninja.base.Base;

public class Searchpage extends Base {
	
	public Searchpage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[normalize-space()='Apple Cinema 30\"']")
	private WebElement validAppleProduct;
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement noProductMessage;
	
	public boolean displayStatusOfValidProduct() {
		return validAppleProduct.isDisplayed();
	}
	
	public String retrieveNoProductMessageText() {
		return noProductMessage.getText();
	}

}
