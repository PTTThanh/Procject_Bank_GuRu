package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;

public class EditCustomerPageObject extends BaseElement {
	WebDriver driver;

	public EditCustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
