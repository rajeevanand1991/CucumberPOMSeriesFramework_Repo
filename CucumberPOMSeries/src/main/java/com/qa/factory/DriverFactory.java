package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	//ThreadLocal is used to run the execution in the parallel mode
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */
	
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is: "+browser);
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver()); //initialize chrome driver and set it to the ThreadLocalDriver
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver()); //initialize firefox driver and set it to the ThreadLocalDriver
		}
		else if(browser.equals("safari")) {
			tlDriver.set(new SafariDriver()); //initialize safari driver and set it to the ThreadLocalDriver
		}
		else {
			System.out.println("Please pass the correct browser value: "+browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}