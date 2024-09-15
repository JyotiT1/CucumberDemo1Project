package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	private By login = By.cssSelector("div[class=\"_2msBFL\"] a[class=\"_1TOQfO\"] span");
	private By emailOrMobileinput = By.cssSelector("input[class=\"r4vIwl BV+Dqf\"]");
	private By requestOtpbutton = By.cssSelector("button[class=\"QqFHMw twnTnD _7Pd1Fp\"]");
	private By requestOTPvalidation = By.cssSelector("span.llBOFA");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getApplicationPageTitle() {
		return driver.getTitle();
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public void clickOnLogin() {
		
		driver.findElement(login).click();
	}

	public void enterEmailOrMobile(String emailormobile) {
		driver.findElement(emailOrMobileinput).sendKeys(emailormobile);
	}

	public void clickOnRequestOtp() {
		driver.findElement(requestOtpbutton).click();
	}

	public String getRequestotpBlankValidation() {
		return driver.findElement(requestOTPvalidation).getText();
	}
}
