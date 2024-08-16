package com.bankguru.share;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGenerator;
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;


public class Common_Register extends BaseTest {
	WebDriver driver;
	String loginPageUrl;
	public static String userID, password;
	private LoginPageObject loginPageObject;
	private RegisterPageObject registerPageObject;
	private String email  = getEmailRandom();

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browser) {
		//log.info("Pre-Condition - Open browser and navigate to app Url");
		driver = getBrowserName(browser);
		loginPageObject = PageGenerator.getLoginPageObject(driver);
		//log.info("Register - Step 01: Get Login Page Url");
		loginPageUrl = loginPageObject.getLoginPageUrl();
		//log.info("Register - Step 02: Click to 'here' link");
		registerPageObject = loginPageObject.clickToHereLink();
		//log.info("Register - Step 03: input to Email textbox:");
		registerPageObject.inputEmail(email);
		//log.info("Register - Step 04: Click to Submit button");
		registerPageObject.clickToSubmit();
		//log.info("Register - step 05: Get UserID/Password information");
		userID = registerPageObject.getValueOfUserID();
		password = registerPageObject.getValueOfPassword();
		closeBrowser();

	}

}
