package com.learnAutomation.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	
	public static  String captureScreenshot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String srceenshotPath =System.getProperty("user.dir")+"/Screenshots/WordPress"+getCurrentDateTime()+".png";
		try {
			FileHandler.copy(src, new File(srceenshotPath));
			
			System.out.println("screenshot captured");
		
		} catch (IOException e) {
			System.out.println("unable to capture screenshot"+e.getMessage());
		}
		return srceenshotPath;
	}
	public static String getCurrentDateTime() 
	{
		DateFormat Customformat=new SimpleDateFormat("MM_DD_YY_HH_mm_ss"); 
		
		Date currentdate=new Date();
		
		return Customformat.format(currentdate);
		
	}
	
}
