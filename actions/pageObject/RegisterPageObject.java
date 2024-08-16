package pageObject;

import org.openqa.selenium.WebDriver;

import com.bankguru.ui.RegisterPageUI;

import commons.BasePage;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputEmail(String value) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.INPUT_VALUE_EMAIL_ID);
		sendkeyToElement(driver, RegisterPageUI.INPUT_VALUE_EMAIL_ID, value);
	}

	public void clickToSubmit() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, RegisterPageUI.CLICK_TO_SUBMIT);
		clickToElement(driver, RegisterPageUI.CLICK_TO_SUBMIT);
	}

	public String getValueOfUserID() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.GET_VALUE_USER_ID);
		return getTextElement(driver, RegisterPageUI.GET_VALUE_USER_ID);
	}

	public String getValueOfPassword() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.GET_VALUE_PASSWORD);
		return getTextElement(driver, RegisterPageUI.GET_VALUE_PASSWORD);
	}
	

}
