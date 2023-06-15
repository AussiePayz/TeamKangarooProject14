package pages;

import org.openqa.selenium.support.PageFactory;

import utilities.driver;

public class checkoutPage {
	
	public checkoutPage() {
		
		PageFactory.initElements(driver.getDriver(), this);
	}
	

}
