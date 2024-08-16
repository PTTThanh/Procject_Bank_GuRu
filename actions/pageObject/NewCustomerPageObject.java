package pageObject;

import org.openqa.selenium.WebDriver;

import com.bankguru.ui.NewCustomerPageUI;

import commons.BaseElement;
import commons.PageGenerator;

public class NewCustomerPageObject extends BaseElement {
	WebDriver driver;

	public NewCustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public HomePageObject clickToSubmitButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, NewCustomerPageUI.CLICK_TO_SUBMIT);
		clickToElement(driver, NewCustomerPageUI.CLICK_TO_SUBMIT);
		return PageGenerator.getHomePageObject(driver);
	}

}
