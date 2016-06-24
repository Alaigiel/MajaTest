package automation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Facebook {
	private AndroidDriver<AndroidElement> driver;
	private static String expectedUrl = "https://m.facebook.com/TestingCup";
	
	public Facebook(AndroidDriver<AndroidElement> driver){
		this.driver = driver;
	}
	
	public AndroidDriver<AndroidElement> getDriver(){
		return driver;
	}
	
	public String getExpectedUrl(){
		return expectedUrl;
	}
}
