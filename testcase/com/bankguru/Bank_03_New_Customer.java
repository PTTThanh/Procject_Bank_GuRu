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

public class Bank_03_New_Customer extends BaseTest {
	WebDriver driver;
	private LoginPageObject loginPageObject;
	private HomePageObject homePageObject;
	private NewCustomerPageObject newCustomerPageObject;
	private String name, city, state, pin, phone, password, dateOfBirth, address;
	private String email = getEmailRandom();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browswer) {
		driver = getBrowserName(browswer);
		loginPageObject = PageGenerator.getLoginPageObject(driver);
		loginPageObject.inputUserIDLogin(Common_Register.userID);
		loginPageObject.inputPasswordLogin(Common_Register.password);
		homePageObject = loginPageObject.clickToLogin();
		Assert.assertEquals(homePageObject.displayMSGHome(), "Welcome To Manager's Page of Guru99 Bank");
		// homePageObject.clickButtonByText("New Customer");
		name = "Automation Testing";
		city = "Tampa";
		state = "FL";
		pin = "466250";
		phone = "0987654321";
		password = "automation";
		dateOfBirth = "11-11-2000";
		address = "PO Box 931";
	}

	@Test
	public void TC1_Verify_Name_Filed_Name_Cannot_Empty() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", "");
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message"),
				"Customer name must not be blank");
	}

	@Test
	public void TC2_Verify_Name_Filed_Name_Cannot_Numeric() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", "1234");
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message"), "Numbers are not allowed");
	}

	@Test
	public void TC3_Verify_Name_Filed_Name_Cannot_Special_Character() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", "!@#$%");
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message"),
				"Special characters are not allowed");
	}

	@Test
	public void TC4_Verify_Name_Filed_Name_Cannot_First_Chracter() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", " ");
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message"),
				"First character can not have space");
	}

	@Test
	public void TC5_Verify_Address_Cannot_Empty() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", "");
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message3"),
				"Address Field must not be blank");
	}

	@Test
	public void TC6_Verify_Address_Cannot_First_Chracter() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", " ");
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message3"),
				"First character can not have space");
	}

	@Test
	public void TC7_Verify_Filed_City_Cannot_Empty() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", "");
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message4"),
				"City Field must not be blank");
	}

	@Test
	public void TC8_Verify_Filed_City_Cannot_Numeric() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", "12345");
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message4"), "Numbers are not allowed");
	}

	@Test
	public void TC9_Verify_Filed_City_Cannot_Special_Character() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", "!@#$%");
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message4"),
				"Special characters are not allowed");
	}

	@Test
	public void TC10_Verify_Filed_City_Cannot_First_Chracter() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", " ");
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message4"),
				"First character can not have space");
	}

	@Test
	public void TC11_Verify_Filed_state_Cannot_Empty() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", "");
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message5"), "State must not be blank");
	}

	@Test
	public void TC12_Verify_Filed_State_Cannot_Numeric() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", "12345");
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message5"), "Numbers are not allowed");
	}

	@Test
	public void TC13_Verify_Filed_State_Cannot_Special_Character() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", "!@#$%");
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message5"),
				"Special characters are not allowed");
	}

	@Test
	public void TC14_Verify_Filed_State_Cannot_First_Chracter() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", " ");
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message5"),
				"First character can not have space");
	}

	@Test
	public void TC15_Verify_Filed_Pin_Cannot_Chracter() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", "abcdef");
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message6"),
				"Characters are not allowed");
	}

	@Test
	public void TC16_Verify_Filed_Pin_Cannot_Empty() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", "");
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message6"),
				"PIN Code must not be blank");
	}

	@Test
	public void TC17_Verify_Filed_Pin_Must_Have_6_Digit() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", "1234");
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message6"),
				"PIN Code must have 6 Digits");
	}

	@Test
	public void TC18_Verify_Filed_Pin_Special_Character() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", "!@$%^");
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message6"),
				"Special characters are not allowed");
	}

	@Test
	public void TC19_Verify_Filed_Pin_First_Blank() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", " ");
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message6"),
				"First character can not have space");
	}

	@Test
	public void TC20_Verify_Filed_Telephone_Cannot_Empty() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", "");
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message7"),
				"Mobile no must not be blank");
	}

	@Test
	public void TC21_Verify_Filed_Telephone_Cannot_First_Character() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", " ");
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message7"),
				"First character can not have space");
	}

	@Test
	public void TC22_Verify_Filed_Telephone_Cannot_Have_Space() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", "123 123");
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message7"),
				"Characters are not allowed");
	}

	@Test
	public void TC23_Verify_Filed_Telephone_Cannot_Special_Character() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", "!@#$%^");
		newCustomerPageObject.inputTextBoxByName("emailid", email);
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message7"),
				"Special characters are not allowed");
	}

	@Test
	public void TC24_Verify_Filed_Email_Cannot_Empty() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", "");
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message9"),
				"Email-ID must not be blank");
	}

	@Test
	public void TC25_Verify_Filed_Email_Cannot_Incorrect_Format() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", "maxgmail.com");
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message9"), "Email-ID is not valid");
	}

	@Test
	public void TC26_Verify_Filed_Email_Cannot_Blank_First() {
		newCustomerPageObject = homePageObject.clickToNewCustomer();
		newCustomerPageObject.inputTextBoxByName("name", name);
		newCustomerPageObject.inputTextBoxByName("dob", dateOfBirth);
		newCustomerPageObject.inputTextAreaByName("addr", address);
		newCustomerPageObject.inputTextBoxByName("city", city);
		newCustomerPageObject.inputTextBoxByName("state", state);
		newCustomerPageObject.inputTextBoxByName("pinno", pin);
		newCustomerPageObject.inputTextBoxByName("telephoneno", phone);
		newCustomerPageObject.inputTextBoxByName("emailid", " ");
		newCustomerPageObject.inputTextBoxByName("password", password);
		newCustomerPageObject.sleepInSecond(2);
		Assert.assertEquals(newCustomerPageObject.verifyErrorMeasageTextboxByID("message9"),
				"First character can not have space");
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}
