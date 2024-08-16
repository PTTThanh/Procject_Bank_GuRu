package com.bankguru.share;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalContants;
import commons.PageGenerator;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;

public class Bank_Register_Login extends BaseTest {
	WebDriver driver;
	private LoginPageObject loginPageObject;
	private RegisterPageObject registerPageObject;
	private HomePageObject homePageObject;
	//private HomePageObject homePageObject;
	private String email  = getEmailRandom();
	public String getCurrentURL;
	private static String valueUserID,valuePassword;
	
	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String browser) {
		driver = getBrowserName(browser);
		registerPageObject = PageGenerator.getRegisterPageObject(driver);
		registerPageObject.sleepInSecond(3);
		registerPageObject.inputEmail(email);
		registerPageObject.clickToSubmit();
		valueUserID = registerPageObject.getValueOfUserID();
		valuePassword = registerPageObject.getValueOfPassword();
		registerPageObject.getURL(driver, GlobalContants.DEV_BANK_GURU_LOG_IN);
		loginPageObject = PageGenerator.getLoginPageObject(driver);
		loginPageObject.inputUserIDLogin(valueUserID);
		loginPageObject.inputPasswordLogin(valuePassword);
		homePageObject = loginPageObject.clickToLogin();
		Assert.assertEquals(homePageObject.displayMSGHome(), "Welcome To Manager's Page of Guru99 Bank");
		closeBrowser();
	}
}
