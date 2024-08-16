package pageObject;

import org.openqa.selenium.WebDriver;

import com.bankguru.ui.LoginPageUI;
import com.bankguru.ui.RegisterPageUI;

import commons.BasePage;
import commons.PageGenerator;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToHereLink() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, LoginPageUI.CLICK_TO_HERE_REGISTER);
		clickToElement(driver, LoginPageUI.CLICK_TO_HERE_REGISTER);
		return new RegisterPageObject(driver);
	}

	public void inputUserIDLogin(String valueUserID) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.INPUT_USER_NAME_LOGIN);
		sendkeyToElement(driver, LoginPageUI.INPUT_USER_NAME_LOGIN, valueUserID);
	}

	public void inputPasswordLogin(String valuePassword) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.INPUT_PASSWORD_LOGIN);
		sendkeyToElement(driver, LoginPageUI.INPUT_PASSWORD_LOGIN, valuePassword);
	}

	public HomePageObject clickToLogin() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, LoginPageUI.CLICK_TO_LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.CLICK_TO_LOGIN_BUTTON);
		return PageGenerator.getHomePageObject(driver);
	}

	public String getLoginPageUrl() {
		// TODO Auto-generated method stub
		return getCurrentURL(driver);
	}
	
}
