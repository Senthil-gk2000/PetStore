package testng.extent.reports;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.base.utils.BaseClass;

public class PetStoreReport extends BaseClass{

	@Test
	public void fbLogin2() throws InterruptedException, IOException {
		createTestName("Petstore Website");
		
		reportStatus("pass", "Browser opened");
		
		browserLaunch("chrome", "https://petstore.octoperf.com/actions/Catalog.action");
		Thread.sleep(2000);
		if(getCurrentUrl().equals("https://petstore.octoperf.com/actions/Catalog.action")) {
			reportStatus("pass", "URL Launched");
		}else {
			reportStatus("fail", "URL not launched");
		}
		findElementById("email").sendKeys("j2ee");
		reportStatus("pass", "Username entered");
		findElementByXpath("//th[contains(text(), 'Payment')]");
		reportStatus("pass with screenshot", "Your order has been submitted");
		Thread.sleep(3000);
		pageClose();
	}
}
