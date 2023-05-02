package com.ninja.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ninja.base.Base;
import com.ninja.pages.Homepage;
import com.ninja.pages.Searchpage;

public class SearchTest extends Base {
	Homepage homepage;
	Searchpage searchpage;
	public SearchTest() throws IOException {
		super();
		
	}
	@BeforeMethod
	public void setup() throws IOException {
	intialize();
	homepage= new Homepage();
		
	}
	
	@Test
	public void verifysearchWithValidProduct() throws IOException {
		//homepage= new Homepage();
		searchpage=homepage.searchForAProduct("Apple");
		
		assertEquals(searchpage.displayStatusOfValidProduct(), true);
		
	}
	@Test
	public void verifySearchWithInValidProduct() throws IOException {
		//homepage= new Homepage();
		//searchpage = new Searchpage();
		searchpage=homepage.searchForAProduct("Honda");
		
		assertEquals(searchpage.retrieveNoProductMessageText(), "There is no product that matches the search criteria.");
		
	}
	
	@Test
	public void verifysearchWithoutAnyProduct() throws IOException {
		//homepage= new Homepage();
		//searchpage = new Searchpage();
		searchpage=homepage.clickOnSearchButton();
		
		assertEquals(searchpage.retrieveNoProductMessageText(), "There is no product that matches the search criter");
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}

