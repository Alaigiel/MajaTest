package automation;

import org.openqa.selenium.Dimension;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Gesture {
	private AndroidDriver<AndroidElement> driver;
	private Dimension screenSize;
	
	public Gesture(AndroidDriver<AndroidElement> driver){
		this.driver = driver;
		screenSize = driver.manage().window().getSize();
	}
	
	public void scrollDown(){
		int swipeStartY = (int) (screenSize.height * 0.5);
		int swipeEndY = (int) (screenSize.height * 0.2);
		int swipeStartX = (int) (screenSize.width / 2);
		int duration = 3000;

		driver.swipe(swipeStartX, swipeStartY, swipeStartX, swipeEndY, duration);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
