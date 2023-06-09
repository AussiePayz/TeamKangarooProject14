package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.driver;

public class hooks {
	
	@Before
	public void openBrowser() {
		
		driver.getDriver();
	}
	
	//@After
	public void tearDown() {
		
		driver.tearDown();
	}

}
