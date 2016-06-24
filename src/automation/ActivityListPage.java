package automation;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ActivityListPage extends BasePage{	
	@AndroidFindBys({
		@AndroidFindBy(id = "android:id/list"),
		@AndroidFindBy(id = "com.testingcup:id/ftitle")
	})
	private List<AndroidElement> scheduleActivityNamesList;

	public ActivityListPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String getActivityTitleOnTheList(int id){
		return (scheduleActivityNamesList.get(id).getText());
	}
	
	public ActivityDetailsPage clickOnActivity(int id){
		waitAndClickElement(scheduleActivityNamesList.get(id));
		return new ActivityDetailsPage(driver);
	}

}
