package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	/*
	 * Inside html elements: 
	 * 		<div id="center_column" class="center_column col-xs-12 col-sm-12">
	 * 		<span>Order history and details</span>
	 * 		<span>My credit slips</span>
	 * 		<span>My addresses</span>
	 * 		<span>My personal information</span>
	 * 		<span>My wishlists</span>
	 * 		<span> <i class="icon-chevron-left"> </i> Home </span>
	 * WE HAVE TAKEN FIRST AS DIV ID AND TAKE ALL THE SPAN TAG TO COLLECT ALL VALUES FROM THE ACCOUNTS SECTION
	 * So, the cssSelector = div#center_column span ===> will take all the above 6 values
	 */
	
	// 1. By Locators: Object Repository OR
	private By accountSections = By.cssSelector("div#center_column span");
	
	// 2. Constructor of the page class:
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// 3. page actions: features(behavior) of the page the form of methods:
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}

	public int getAccountsSectionCount() {
		//return driver.findElements(accountSections).size()-1; //This code to take 5 values and exclude value as Home, but while execution takes all 6 WebElements inclusion of Home as well 
		return driver.findElements(accountSections).size();
	}

	public List<String> getAccountsSectionsList() {

		List<String> accountsList = new ArrayList<>(); //This list is to store all the account section values
		List<WebElement> accountsHeaderList = driver.findElements(accountSections); // To take all values in account section

		for (WebElement e : accountsHeaderList) {
			String text = e.getText();
			System.out.println(text);
			accountsList.add(text);
		}

		return accountsList;

	}
}