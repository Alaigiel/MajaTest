package automation;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BasePage implements GuiOperation{
	protected AndroidDriver<AndroidElement> driver;
	
	public BasePage(AndroidDriver<AndroidElement> driver){
		this.driver = driver;
	}

	@Override
	public void waitForElement(AndroidElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(element));	
	}

	@Override
	public void waitAndClickElement(AndroidElement element) {
		waitForElement(element);
		element.click();	
	}

	@Override
	public String waitAndGetText(AndroidElement element) {
		waitForElement(element);
		return (element.getText());
	}
}
