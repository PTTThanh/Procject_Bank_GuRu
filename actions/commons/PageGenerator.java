package commons;

import org.openqa.selenium.WebDriver;

import pageObject.EditCustomerPageObject;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.NewCustomerPageObject;
import pageObject.RegisterPageObject;


public class PageGenerator {
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static EditCustomerPageObject getEditCustomerPageObject(WebDriver driver) {
		return new EditCustomerPageObject(driver);
	}
	public static NewCustomerPageObject getNewCustomerPageObject(WebDriver driver) {
		return new NewCustomerPageObject(driver);
	}
}
