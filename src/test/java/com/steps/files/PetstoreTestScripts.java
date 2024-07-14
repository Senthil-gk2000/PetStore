package com.steps.files;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.base.utils.BaseClass;
import com.petstore.locators.ShippingAddressPageLocators;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PetstoreTestScripts extends BaseClass {

	// @Parameters({ "browser", "url" })
//	@BeforeMethod
//	public void testSetup(String browser, String url) throws IOException {
//		
//
//		
//		browserLaunch(browser, url);
//		driver.manage().window().maximize();
//		createTestName("Petstore Page");
//		reportStatus("pass", "Browser opened");
//	}

	@Test(priority = 1, description = "Browser opening")
	public void open_the_Chrome_browser() throws IOException {
		browserOpen("chrome");
		driver.manage().window().maximize();
		createTestName("Petstore Page");
		reportStatus("pass", "Browser opened");
	}

	@Test(priority = 2, description = "URL Launching")
	public void launch_petstore_url() throws IOException {
		loadUrl("https://petstore.octoperf.com/actions/Catalog.action");
		if (getCurrentUrl().equals("https://petstore.octoperf.com/actions/Catalog.action")) {
			reportStatus("pass", "URL Launched");
		} else {
			reportStatus("fail", "URL not launched");
		}

	}

	// "Click on Sign in menu"
	@Test(priority = 3)
	public void click_on_sign_in_menu() {
		findElementByXpath("//*[text()='Sign In']").click();
	}

	// "Enter Petstore Username"
	@Test(priority = 4)
	public void enter_Petstore_username() {
		findElementByName("username").sendKeys("j2ee");
	}

	// "Enter Petstore Password"
	@Test(priority = 5)
	public void enter_Petstore_password() {
		// findElementByName("password").sendKeys("j2ee");
	}

	// "Click on Petstore Login button"
	@Test(priority = 6)
	public void click_on_Petstore_login_button() {
		findElementByXpath("//input[@value='Login']").click();

	}

	// "Validate User redirects to the Catalog page"
	@Test(priority = 7)
	public void validate_user_redirects_to_the_catalog_page() throws IOException {

		if (isElementDisplayed(findElementByXpath("//*[text()='Sign Out']"))) {
			;
			System.out.println("User Succesfully logged in");
			reportStatus("pass", "User Succesfully logged in");
		} else {
			System.out.println("User not logged in");
			reportStatus("fail", "User not logged in");
		}
	}

	// "Click on the Pet Item 'Birds'"
	@Test(priority = 8)
	public void click_on_the_pet_item() {
		findElementByXpath("(//a[contains(@href, 'BIRDS')])[1]").click();
	}

	// "Click on the Product ID"
	@Test(priority = 9)
	public void click_on_the_product_id() {
		findElementByXpath("//td[contains(text(), 'Finch')]/preceding-sibling::td/child::a").click();
	}

	// "Click on Add to Cart"
	@Test(priority = 10)
	public void click_on_add_to_cart() {
		findElementByXpath("//a[contains(text(), 'Cart')]").click();

	}

	// "Click on Proceed to Checkout"
	@Test(priority = 11)
	public void click_on_proceed_to_checkout() {
		findElementByXpath("//a[contains(text(), 'Checkout')]").click();
	}

	// "Click on Ship to different address"
	@Test(priority = 12)
	public void click_on_ship_to_different_address() {
		findElementByXpath("//*[contains(@name, 'shipping')]").click();

	}

	// "Click on Customer Details Continue button"
	@Test(priority = 13)
	public void click_on_customer_details_continue_button() {
		findElementByXpath("//*[@value='Continue']").click();

	}

	@Test(priority = 14)
	public void user_enter_customer_details() throws Exception {

		ShippingAddressPageLocators sap = new ShippingAddressPageLocators(driver);
		WebElement fName = sap.getFirstNameField();
		fName.clear();
		String sendFname = getTestData("FirstName");
		dataSend(fName, sendFname);

		WebElement lName = sap.getLastNameField();
		lName.clear();
		String sendLname = getTestData("LastName");
		dataSend(lName, sendLname);

		WebElement add1 = sap.getAddress1Field();
		add1.clear();
		String sendAdd1 = getTestData("Address1");
		dataSend(add1, sendAdd1);

		WebElement add2 = sap.getAddress2Field();
		add2.clear();
		String sendAdd2 = getTestData("Address2");
		dataSend(add2, sendAdd2);

		WebElement city = sap.getCityField();
		city.clear();
		String sendCity = getTestData("City");
		dataSend(city, sendCity);

		WebElement state = sap.getStateField();
		state.clear();
		String sendState = getTestData("State");
		dataSend(state, sendState);

		WebElement zip = sap.getZipField();
		zip.clear();
		String sendZip = getTestData("Zip");
		dataSend(zip, sendZip);

		WebElement country = sap.getCountryField();
		country.clear();
		String sendCountry = getTestData("Country");
		dataSend(country, sendCountry);

	}

	@Test(priority = 15, description = "Click on Shipping Address Continue button")
	public void click_on_shipping_address_continue_button() {
		findElementByXpath("//*[@name='newOrder']").click();
	}

	@Test(priority = 16, description = "Click on Confirm button")
	public void click_on_confirm_button() {
		findElementByXpath("//a[contains(text(),'Confirm')]").click();

	}

	@Test(priority = 17, description = "Validate order ID generated")
	public void validate_order_id_generated() throws IOException {

		String url = getCurrentUrl();
		if (url.contains("confirmed")) {
			WebElement orderId = findElementByXpath("//div[@id='Catalog']/descendant::th[contains(text(), 'Order')]");
			System.out.println("Your Purchased Order # is: " + orderId.getText());

			reportStatus("pass with screenshot", "Your order has been submitted");
		}

	}

//	@AfterMethod
//	public void browserClose() {
//		pageClose();
//	}

}
