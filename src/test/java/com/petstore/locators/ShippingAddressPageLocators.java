package com.petstore.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.utils.BaseClass;

public class ShippingAddressPageLocators extends BaseClass {

	public ShippingAddressPageLocators(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Annoations used with PageFactory
	@FindBy(xpath = "//*[@name='order.shipToFirstName']")
	private WebElement firstNameField;
	
	@FindBy(xpath = "//*[@name='order.shipToLastName']")
	private WebElement lastNameField;	
	
	@FindBy(xpath = "//*[@name='order.shipAddress1']")
	private WebElement address1Field;
	
	@FindBy(xpath = "//*[@name='order.shipAddress2']")
	private WebElement address2Field;
	
	@FindBy(xpath = "//*[@name='order.shipCity']")
	private WebElement cityField;
	
	@FindBy(xpath = "//*[@name='order.shipState']")
	private WebElement stateField;
	
	@FindBy(xpath = "//*[@name='order.shipZip']")
	private WebElement zipField;
	
	@FindBy(xpath = "//*[@name='order.shipCountry']")
	private WebElement countryField;
	
	
	public WebElement getFirstNameField() {
		return firstNameField;
	}

	public WebElement getLastNameField() {
		return lastNameField;
	}

	public WebElement getAddress1Field() {
		return address1Field;
	}

	public WebElement getAddress2Field() {
		return address2Field;
	}

	public WebElement getCityField() {
		return cityField;
	}

	public WebElement getStateField() {
		return stateField;
	}

	public WebElement getZipField() {
		return zipField;
	}

	public WebElement getCountryField() {
		return countryField;
	}
	
}
