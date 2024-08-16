package pageObject;

import org.openqa.selenium.WebDriver;

import com.bankguru.ui.HomePageUI;
import com.bankguru.ui.LoginPageUI;
import com.bankguru.ui.RegisterPageUI;

import commons.BaseElement;
import commons.BasePage;
import commons.PageGenerator;

public class HomePageObject extends BaseElement {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String displayMSGHome() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, HomePageUI.GET_TEXT_AT_HOME_PAGE);
		return getTextElement(driver, HomePageUI.GET_TEXT_AT_HOME_PAGE);
	}

	public NewCustomerPageObject clickToNewCustomer() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.CLICK_TO_MENU_NEW_CUSTOMER);
		clickToElement(driver, HomePageUI.CLICK_TO_MENU_NEW_CUSTOMER);
		return PageGenerator.getNewCustomerPageObject(driver);
	}

	public String getTextCustomerID() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, HomePageUI.GET_TEXT_CUSTOMER_ID);
		return getTextElement(driver, HomePageUI.GET_TEXT_CUSTOMER_ID);
	}
}
