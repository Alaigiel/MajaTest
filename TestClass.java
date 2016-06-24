package automation;

import java.awt.Frame;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Appium appium = new Appium();
		

		try {
			appium.setUp();

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		Frame frame = null;
		//JOptionPane.showMessageDialog(frame, appium.driver.findElement(By.id("com.marketlytics.calabashtest:id" + "/radio0")).getText());
		
		//appium.buttonClick();
		//guiOperation.ButtonClick(appium.getDriver());

		//String testCases[] = {"abc", "¹æê³óñ¿", "~!@#$%^&*()", ""};
		String[][] testCases = {{"WithoutPolish","abc"},
				{"Symbol", "~!@#$%^&*()"}, {"Empty", ""}};
		
		
		for (int i = 0; i < testCases.length; i++) {
			//appium.fillInTheInput(testCases[i][0], testCases[i][1]);
			//appium.getDriver().navigate().back();
			//appium.getDriver().findElement(By.id("com.marketlytics.calabashtest:id/editText1")).clear();
		}

		appium.tearDown();
	}

}
