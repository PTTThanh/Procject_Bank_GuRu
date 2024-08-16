package com.bankguru;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.share.Bank_Register_Login;
import com.bankguru.share.Common_Register;

import commons.BaseTest;
import commons.PageGenerator;
import pageObject.EditCustomerPageObject;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.NewCustomerPageObject;

public class Bank_02_Payment extends BaseTest {
	WebDriver driver;
	private LoginPageObject loginPageObject;
	private HomePageObject homePageObject;
	private EditCustomerPageObject editCustomerPageObject;
	private NewCustomerPageObject newCustomerPageObject;
	private String name,city,state,pin,phone,password, dateOfBirth, address;
	private String editAddress, editCity, editState, editPIN;
	private String email = getEmailRandom();
	private String customerID;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browswer) {
		driver = getBrowserName(browswer);
		loginPageObject = PageGenerator.getLoginPageObject(driver);
		loginPageObject.inputUserIDLogin(Common_Register.userID);
		loginPageObject.inputPasswordLogin(Common_Register.password);
		homePageObject = loginPageObject.clickToLogin();
		Assert.assertEquals(homePageObject.displayMSGHome(), "Welcome To Manager's Page of Guru99 Bank");
		//homePageObject.clickButtonByText("New Customer");
		name ="Automation Testing";
		city="Tampa";
		state="FL";
		pin="466250";
		phone="0987654321";
		password ="automation";
		dateOfBirth ="11-11-2000";
		address = "PO Box 931";
		editAddress ="1336 Curus Advence";
		editCity ="Houston";
		editState ="Texas";
		editPIN ="166455";
	}
	@Test
	public void TC1_Create_Check_Customer_Account() {
		newCustomerPageObject =  homePageObject.clickToNewCustomer();
		newCustomerPageObject.sleepInSecond(3);
		newCustomerPageObject.inputTextBoxByName("name",name);
		newCustomerPageObject.sleepInSecond(3);
		newCustomerPageObject.inputTextBoxByName("dob",dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr",address);
		newCustomerPageObject.inputTextBoxByName("city",city);
		newCustomerPageObject.inputTextBoxByName("state",state);
		newCustomerPageObject.inputTextBoxByName("pinno",pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno",phone);
		newCustomerPageObject.inputTextBoxByName("emailid",email);
		newCustomerPageObject.inputTextBoxByName("password",password);
		homePageObject = newCustomerPageObject.clickToSubmitButton();
		homePageObject.sleepInSecond(5);
		customerID = homePageObject.getTextCustomerID();
//		Assert.assertEquals(homePageObject.verifyInforTextboxByValue("Customer Name"),name);
//		//Assert.assertEquals(homePageObject.verifyInforTextboxByValue("Birthdate"),dateOfBirth);
//		Assert.assertEquals(homePageObject.verifyInforTextboxByValue("Address"),address);
//		Assert.assertEquals(homePageObject.verifyInforTextboxByValue("City"),city);
//		Assert.assertEquals(homePageObject.verifyInforTextboxByValue("State"),state);
//		Assert.assertEquals(homePageObject.verifyInforTextboxByValue("Pin"),pin);
//		Assert.assertEquals(homePageObject.verifyInforTextboxByValue("Mobile No."),phone);
//		Assert.assertEquals(homePageObject.verifyInforTextboxByValue("Email"),email);
	}
	@Test
	public void TC_Edit_Check_Account() {
		homePageObject.clickButtonByText("Edit Customer");
		editCustomerPageObject = PageGenerator.getEditCustomerPageObject(driver);
		editCustomerPageObject.inputTextBoxByName("cusid", customerID);
		editCustomerPageObject.clickButtonByName("AccSubmit");
		editCustomerPageObject.inputTextAreaByName("addr",editAddress);
		editCustomerPageObject.inputTextBoxByName("city",editCity);
		editCustomerPageObject.inputTextBoxByName("state",editState);
		editCustomerPageObject.inputTextBoxByName("pinno",editPIN);
		editCustomerPageObject.clickButtonByName("sub");
		editCustomerPageObject.sleepInSecond(5);
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}
