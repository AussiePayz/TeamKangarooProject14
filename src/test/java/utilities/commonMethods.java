package utilities;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonMethods extends pageInitializer{
	

	public static void sendKeys(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	public static void clickRadioOrCheckbox(List<WebElement> radioOrCheckbox, String value) {
		String actualValue;

		for (WebElement eachElement : radioOrCheckbox) {
			actualValue = eachElement.getAttribute("value").trim();

			if (eachElement.isEnabled() && actualValue.equals(value)) {
				eachElement.click();
				break;

			}
		}

	}

	public static void clickRadioOrCheckboxText(List<WebElement> radioOrCheckbox, String value) {
		String actualValue;

		for (WebElement eachElement : radioOrCheckbox) {
			actualValue = eachElement.getText().trim();

			if (eachElement.isEnabled() && actualValue.equals(value)) {
				eachElement.click();
				break;

			}
		}
	}

	// select dropdown value

	public static void selectDropDownValue(WebElement element, String textToSelect) {

		try {
			Select select = new Select(element);

			List<WebElement> options = select.getOptions();

			for (WebElement el : options) {
				if (el.getText().equals(textToSelect))
					;
				select.selectByVisibleText(textToSelect);
				break;

			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	// select dropdown by index
	public static void selectDropDownIndex(WebElement element, int indexValue) {

		try {
			Select select = new Select(element);

			int size = select.getOptions().size();
			if (size > indexValue) {
				select.selectByIndex(indexValue);

			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	// alert accept
	public static void acceptAlert() {
		try {
			Alert alert = driver.getDriver().switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	// alert dismiss
	public static void dismissAlert() {
		try {
			Alert alert = driver.getDriver().switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	// alert get text
	public static String getTextAlert() {
		String alertText = null;
		try {
			Alert alert = driver.getDriver().switchTo().alert();
			alert.getText();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return alertText;

	}

	public static void switchToIframeByIndex(WebElement element, int index) {
		try {
			driver.getDriver().switchTo().defaultContent();

			List<WebElement> iframes = driver.getDriver().findElements(By.tagName("iframe"));

			if (index < iframes.size()) {
				driver.getDriver().switchTo().frame(index);
			}
		} catch (NoSuchFrameException e) {
			e.printStackTrace();

		}
	}

	public static void switchToIframeByElement(WebElement element) {
		try {
			driver.getDriver().switchTo().defaultContent();

			driver.getDriver().switchTo().frame(element);
		} catch (NoSuchFrameException e) {

			e.printStackTrace();

		}
	}

	public static void switchToIframeByName(String iframeName) {
		driver.getDriver().switchTo().defaultContent();

		try {
			driver.getDriver().switchTo().frame(iframeName);
		} catch (NoSuchFrameException e) {

			e.printStackTrace();

		}
	}

	public static void switchToChildWindow(String parentWindow) {

		Set<String> windowHandles = driver.getDriver().getWindowHandles();

		for (String window : windowHandles) {
			if (!window.equals(parentWindow)) {
				driver.getDriver().switchTo().window(window);
				break;
			}
		}

	}

	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver.getDriver(), 30);
		return wait;
	}

	public static WebElement waitForClickability(WebElement element) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));

	}

	public static void click(WebElement element) {
		waitForVisibility(element).click();
	}

	public void sendKeys(String Keys, WebElement element) {
		waitForVisibility(element).sendKeys(Keys);
	}

	public static void hoverOverMouse(WebElement element) {
		Actions action = new Actions(driver.getDriver());
		action.moveToElement(element).build().perform();

	}

	public static void dragAndDrop(WebElement element1, WebElement element2) {
		Actions action = new Actions(driver.getDriver());
		action.dragAndDrop(element1, element2).build().perform();
		;
	}

	public static void doubleClick(WebElement element) {
		Actions action = new Actions(driver.getDriver());
		action.doubleClick(element).perform();
		;
	}

	public static String currentURL() {
		return driver.getDriver().getCurrentUrl();
	}

	public static void refresh() {
		driver.getDriver().navigate().refresh();
	}

	public static String getTitle() {
		return driver.getDriver().getTitle();
	}

	public static void navigateBack() {
		driver.getDriver().navigate().back();
	}
	
	 public static void selectOptionByVisibleText(WebElement dropdown, String optionText) {
	        Select select = new Select(dropdown);
	        select.selectByVisibleText(optionText);
	    
	}
}




