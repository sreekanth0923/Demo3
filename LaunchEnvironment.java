package com.gcreddyClasses.Selenium.appModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gcreddyClasses.Selenium.Reports.Log;
import com.gcreddyClasses.Selenium.Reports.Reports;

public class LaunchEnvironment {
	public static boolean flag;
	public static WebDriver driver;
/**
 * @author sreekanth 
 * @param browser
 * @return
 */
	public static boolean LaunchBrowser(String browser) {
		flag = false;
		Log.info("Provided browser is " + browser);
		try {
			if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("Webdriver,chrome.driver", "E:\\Apron\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				flag = true;
			} else {
				Log.info("Invalid data Provided");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(e.fillInStackTrace().toString());
			// Reports.info("", e.toString());
		}
		return flag;

	}
	
//----------------------------------------------------------------------------------	
	
/**
 * @author sreekanth 
 * @param url
 * @return
 */
	public static boolean launchUrl(String url) {
		flag = false;
		Log.info("Provided Url is: " + url);
		try {
			driver.get(url);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(e.fillInStackTrace().toString());

		}

		return flag;

	}

	//------------------------------------------------------------------------------------------
			public static void closeBrowser(){      
				driver.close();
				}
		
}
