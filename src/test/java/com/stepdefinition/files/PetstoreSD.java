package com.stepdefinition.files;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebElement;
import com.base.utils.BaseClass;
import com.petstore.locators.ShippingAddressPageLocators;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PetstoreSD extends BaseClass {

	@Given("Open the Chrome browser")
	public void open_the_Chrome_browser() {
		browserOpen("chrome");
		driver.manage().window().maximize();
	}

	@Given("Launch petstore url")
	public void launch_petstore_url() throws IOException {
		loadUrl("https://petstore.octoperf.com/actions/Catalog.action");
		if(getCurrentUrl().equals("https://petstore.octoperf.com/actions/Catalog.action")) {
			reportStatus("pass", "URL Launched");
		}else {
			reportStatus("fail", "URL not launched");
		}
		
		
	}

	@When("Click on Sign in menu")
	public void click_on_sign_in_menu() {
		findElementByXpath("//*[text()='Sign In']").click();
	}
	
	
	@When("Enter Petstore Username")
	public void enter_Petstore_username() {
		findElementByName("username").sendKeys("j2ee");
	}

	@When("Enter Petstore Password")
	public void enter_Petstore_password() {
		//findElementByName("password").sendKeys("j2ee");
	}

	@When("Click on Petstore Login button")
	public void click_on_Petstore_login_button() {
		findElementByXpath("//input[@value='Login']").click();
		
	}	


	@Then("Validate User redirects to the Catalog page")
	public void validate_user_redirects_to_the_catalog_page() {

		if (isElementDisplayed(findElementByXpath("//*[text()='Sign Out']"))) {
			;
			System.out.println("User Succesfully logged in");
		} else {
			System.out.println("User not logged in");
		}
	}

	@When("Click on the Pet Item 'Birds'")
	public void click_on_the_pet_item() {
		findElementByXpath("(//a[contains(@href, 'BIRDS')])[1]").click();
	}

	@When("Click on the Product ID")
	public void click_on_the_product_id() {
		findElementByXpath("//td[contains(text(), 'Finch')]/preceding-sibling::td/child::a").click();
	}

	@When("Click on Add to Cart")
	public void click_on_add_to_cart() {
		findElementByXpath("//a[contains(text(), 'Cart')]").click();

	}

	@When("Click on Proceed to Checkout")
	public void click_on_proceed_to_checkout() {
		findElementByXpath("//a[contains(text(), 'Checkout')]").click();
	}
	

	@When("Click on Ship to different address")
	public void click_on_ship_to_different_address() {
		findElementByXpath("//*[contains(@name, 'shipping')]").click();

	}

	@When("Click on Customer Details Continue button")
	public void click_on_customer_details_continue_button() {
		findElementByXpath("//*[@value='Continue']").click();

	}

	@When("User Enter Customer details asMap")
	public void user_enter_customer_details_as_map(DataTable dataTable) {
		
		Map<String, String> data = dataTable.asMap();
		
		ShippingAddressPageLocators sap = new ShippingAddressPageLocators(driver);
		WebElement fName = sap.getFirstNameField();
		fName.clear();
		String sendFname = data.get("First name");
		dataSend(fName, sendFname);
		
		WebElement lName = sap.getLastNameField();
		lName.clear();
		String sendLname = data.get("Last name");
		dataSend(lName, sendLname);
		
		WebElement add1 = sap.getAddress1Field();
		add1.clear();
		String sendAdd1 = data.get("Address 1");
		dataSend(add1, sendAdd1);
		
		WebElement add2 = sap.getAddress2Field();
		add2.clear();
		String sendAdd2 = data.get("Address 2");
		dataSend(add2, sendAdd2);
		
		WebElement city = sap.getCityField();
		city.clear();
		String sendCity = data.get("City");
		dataSend(city, sendCity);
		
		WebElement state = sap.getStateField();
		state.clear();
		String sendState = data.get("State");
		dataSend(state, sendState);
		
		WebElement zip = sap.getZipField();
		zip.clear();
		String sendZip = data.get("Zip");
		dataSend(zip, sendZip);

		WebElement country = sap.getCountryField();
		country.clear();
		String sendCountry = data.get("Country");
		dataSend(country, sendCountry);
		
		
		System.out.println(data.get("First name"));
		System.out.println(data.get("Last name"));
		System.out.println(data.get("Address 1"));
		System.out.println(data.get("Address 2"));
		System.out.println(data.get("City"));
		System.out.println(data.get("State"));
		System.out.println(data.get("Zip"));
		System.out.println(data.get("Country"));

	}

	@When("Click on Shipping Address Continue button")
	public void click_on_shipping_address_continue_button() {
		findElementByXpath("//*[@name='newOrder']").click();
	}

	@When("Click on Confirm button")
	public void click_on_confirm_button() {
		findElementByXpath("//a[contains(text(),'Confirm')]").click();

	}

	@Then("Validate order ID generated")
	public void validate_order_id_generated() throws IOException {
	
	String url = getCurrentUrl();
	if(url.contains("confirmed")) {
	WebElement orderId = findElementByXpath("//div[@id='Catalog']/descendant::th[contains(text(), 'Order')]");
	System.out.println("Your Purchased Order # is: " + orderId.getText());		
	
	reportStatus("pass with screenshot", "Your order has been submitted");
	}
	
	}

}
