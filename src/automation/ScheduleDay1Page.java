package automation;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ScheduleDay1Page extends BasePage{
	@AndroidFindBy(id = "com.testingcup:id/day1place1Button")
	private AndroidElement day1Place;
	
	private ActivityListPage activityListPage;
	
	public ScheduleDay1Page(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		activityListPage = new ActivityListPage(driver);
	}
	
	

}
