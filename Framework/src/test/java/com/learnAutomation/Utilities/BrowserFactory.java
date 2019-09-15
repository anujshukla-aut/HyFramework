package com.learnAutomation.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	
	public static WebDriver startApplication(WebDriver driver,String browserName,String appUrl)
	{
		if(browserName.equals("Crome")) {
			String exePath = "./Drivers/chromedriver (2).exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver=new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		else if(browserName.equals("firefox")){
			//write same for rest browser
		}
		else if(browserName.equals("Iexplorer")){
			
			
		}
		else {
			System.out.println("sorry we dont support this browser");
		}
		//maximizing the browser
		driver.manage().window().maximize();
		//fetching the application Url
		driver.get(appUrl);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return driver;
	}
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	
}
