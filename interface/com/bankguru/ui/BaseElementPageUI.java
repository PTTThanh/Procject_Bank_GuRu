package com.bankguru.ui;

public class BaseElementPageUI {
	public static final String DYNAMIC_MENU_BY_TEXT = "xpath=//a[contains(text(),'%s')]";
	public static final String DYNAMIC_MENU_BY_NAME = "xpath=//td//input[@name='%s']";
	public static final String DYNAMIC_TEXT_BOX_BY_NAME = "xpath=//td//input[@name='%s']";
	public static final String DYNAMIC_TEXT_AREA_BY_NAME = "xpath=//td//textarea[@name='%s']";
	public static final String DYNAMIC_TEXT_INFOR_BY_VALUE = "xpath=//tr//td[contains(text(),'%s')]/following-sibling::td";
	public static final String DYNAMIC_ERROR_TEXTBOX_BY_ID ="xpath=//td//label[@id='%s']";
}
