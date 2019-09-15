package com.learnAutomation.TestCases;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.Automation.pages.BaseClass;
import com.Automation.pages.loginPage;
import com.learnAutomation.Utilities.ExcelDataProvider;
import com.learnAutomation.Utilities.Helper;

public class loginTestCRM extends BaseClass {
	
	@Test
	public void loginApp()
		{
		logger=report.createTest("Login to wordpress");
		
		loginPage LoginPage =PageFactory.initElements(driver, loginPage.class);
		
		logger.info("starting application");
		
		LoginPage.loginToCRM(excel.getstringData("Login", 0, 0), excel.getstringData("Login", 0, 1));
		
		logger.pass("Login :) successfully");
		}
		
		
	
}
