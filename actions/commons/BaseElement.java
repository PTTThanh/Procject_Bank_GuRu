package commons;

import org.openqa.selenium.WebDriver;

import com.bankguru.ui.BaseElementPageUI;



public class BaseElement extends BasePage {
	WebDriver driver;

	public BaseElement(WebDriver driver) {
		this.driver = driver;
	}
	public void clickButtonByText(String textMenu) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver,BaseElementPageUI.DYNAMIC_MENU_BY_TEXT, textMenu);
		clickToElement(driver,BaseElementPageUI.DYNAMIC_MENU_BY_TEXT, textMenu);
	}
	public void inputTextBoxByName (String name, String value) {
		waitForElementVisible(driver, BaseElementPageUI.DYNAMIC_TEXT_BOX_BY_NAME, name);
		if(name.equals("dob")){
			removeAttributeInDOM(driver,BaseElementPageUI.DYNAMIC_TEXT_BOX_BY_NAME,"type",name);
		}
		sendkeyToElement(driver, BaseElementPageUI.DYNAMIC_TEXT_BOX_BY_NAME, value, name);
	}
	public void clickButtonByName(String name) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver,BaseElementPageUI.DYNAMIC_TEXT_BOX_BY_NAME, name);
		clickToElement(driver,BaseElementPageUI.DYNAMIC_TEXT_BOX_BY_NAME, name);
	}
	public void inputTextAreaByName (String name, String value) {
		waitForElementVisible(driver, BaseElementPageUI.DYNAMIC_TEXT_AREA_BY_NAME, name);
		sendkeyToElement(driver, BaseElementPageUI.DYNAMIC_TEXT_AREA_BY_NAME, value, name);
	}
	public String verifyInforTextboxByValue(String value) {
		waitForElementVisible(driver, BaseElementPageUI.DYNAMIC_TEXT_INFOR_BY_VALUE, value);
		return getTextElement(driver,  BaseElementPageUI.DYNAMIC_TEXT_INFOR_BY_VALUE, value);
	}
	public String verifyErrorMeasageTextboxByID(String id) {
		waitForElementVisible(driver, BaseElementPageUI.DYNAMIC_ERROR_TEXTBOX_BY_ID, id);
		return getTextElement(driver, BaseElementPageUI.DYNAMIC_ERROR_TEXTBOX_BY_ID, id);
	}

}
