package com.Automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {
	WebDriver driver;
	//we will store all the locators
	//to fail we need to seed error in xpath (in anyone of it)
	//this is new commint
	
	//creating constructor
	public loginPage(WebDriver ldriver) {
		this.driver=ldriver;
		
	}
	
	@FindBy(xpath=".//input[@id='user_login']") WebElement uname;
	
	@FindBy(xpath=".//input[@id='user_pass']") WebElement password;
	
	@FindBy(xpath=".//input[@id='wp-submit']") WebElement login;
	
	public void loginToCRM(String username,String pwd) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			
			
		}
		
		uname.sendKeys(username);
		password.sendKeys(pwd);
		login.click();
	}
	
}
