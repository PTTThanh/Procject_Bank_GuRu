package com.bankguru;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Bank_01_Login extends BaseTest {
	WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass (String browswer) {
		driver = getBrowserName(browswer);
	}
	@Test
	public void test() {
		
	}
	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}
