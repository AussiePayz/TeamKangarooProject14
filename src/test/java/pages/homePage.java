package pages;

import org.openqa.selenium.support.PageFactory;

import utilities.driver;

public class homePage {
	public homePage() {
		
		PageFactory.initElements(driver.getDriver(), this);
		}
	
	
	

}
