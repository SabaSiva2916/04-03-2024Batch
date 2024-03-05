package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// 1.By Locators
	private By username = By.id("username");
	private By password = By.id("password");
	private By loginBtn = By.id("login");
	private By forgotPwdLink = By.linkText("Forgot Password?");

	// 2.constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3.page action

	public String getTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUsername(String user) {
		driver.findElement(username).sendKeys(user);
	}

	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);

	}

	public void clickOnLogin() {
		driver.findElement(loginBtn).click();
	}

	public SearchPage doLogin(String user, String pass) {
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBtn).click();
		
		return new SearchPage(driver);
	}
}
