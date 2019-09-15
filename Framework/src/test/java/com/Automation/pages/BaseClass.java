package com.Automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnAutomation.Utilities.BrowserFactory;
import com.learnAutomation.Utilities.ConfigDataProvider;
import com.learnAutomation.Utilities.ExcelDataProvider;
import com.learnAutomation.Utilities.Helper;

public class BaseClass {
public WebDriver driver;
public ExcelDataProvider excel;
public ConfigDataProvider config;
public ExtentReports report;
public ExtentTest logger;
	@BeforeSuite
	public void setupSuite()
	{
		//to generate the logs ie if u cant to see in console what method is being executed and all
		Reporter.log("setting up the reports and test is getting ready", true);
		
		 excel=new ExcelDataProvider();
		 config=new ConfigDataProvider();
		//code for extent report 
		 ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Wordpress_"+Helper.getCurrentDateTime()+".html")); 
		 report=new ExtentReports();
		 report.attachReporter(extent);
		//creating end log
		 Reporter.log("setting is done ---- test can be started ", true);
	}


	@BeforeClass
	public void setup()
	{
		 Reporter.log("Trying to start the browser and getting application ready ", true);
		
	driver =BrowserFactory.startApplication(driver, config.getBrowser(),config.getStagingUrl());
		
	 Reporter.log("Browser and application is Up and Running ", true);
	}
	
	@AfterClass
	public void teardown()
	{
		BrowserFactory.quitBrowser(driver);	
	}
	@AfterMethod
	public void tearDownMethod(ITestResult result ) throws IOException {
		
		 Reporter.log("Test is about to end ", true);
	
		if(result.getStatus()==ITestResult.FAILURE)
		{
		//to attach screenshot to the report
		logger.fail("Test Failed ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
				
		}
		
		
		//to flush the report
		report.flush();
		 Reporter.log("Test completed >> Reports Generated", true);
	}
	
}
