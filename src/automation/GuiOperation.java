package automation;

import io.appium.java_client.android.AndroidElement;

interface GuiOperation {

	public void waitForElement(AndroidElement element);
	
	public void waitAndClickElement(AndroidElement element);

	public String waitAndGetText(AndroidElement element);

}
