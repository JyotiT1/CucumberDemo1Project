package com.demo.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */
	public WebDriver init_driver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");  // Run Chrome in headless mode
	        options.addArguments("--start-maximized");  // Start maximized (optional in headless mode)
	        options.addArguments("--disable-extensions");  // Disable extensions
			tlDriver.set(new ChromeDriver(options));
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else
			System.out.println("Please pass the correct browser " + browser);

//		getDriver().manage().deleteAllCookies();
//		getDriver().manage().window().maximize();

		return getDriver();
	}

	public static synchronized WebDriver getDriver() {

		return tlDriver.get();
	}

}
