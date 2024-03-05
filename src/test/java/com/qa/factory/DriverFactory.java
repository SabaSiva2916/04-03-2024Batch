package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * This method is used to initialize the threadlocal driver on the basis of
	 * given browser
	 * 
	 * @param browser
	 * @return this will return tlDriver.
	 */

	public WebDriver init_driver(String browser) {
		System.out.println("browser value is: " + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if (browser.equals("egde")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new EdgeDriver());
		} else {
			System.out.println("Please pass the correct browser value:" + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();

		return getDriver();

	}
	
	/**
	 * This is used to get the driver with ThreadLocal
	 * @return
	 */

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
