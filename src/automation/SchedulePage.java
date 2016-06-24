package automation;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SchedulePage extends BasePage{	
	@AndroidFindBy(id = "com.testingcup:id/logo")
	private AndroidElement testingCupLogo;	
	@AndroidFindBy(id = "com.testingcup:id/title")
	private AndroidElement scheduleTitle;
	@AndroidFindBy(id = "com.testingcup:id/day1Button")
	private AndroidElement buttonDay1;
	@AndroidFindBy(id = "com.testingcup:id/day2Button")
	private AndroidElement buttonDay2;

	public SchedulePage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String getSchedulePageTitle(){
		return scheduleTitle.getText();
	}
	
	
}
