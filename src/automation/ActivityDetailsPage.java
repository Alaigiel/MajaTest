package automation;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ActivityDetailsPage extends BasePage{
	@AndroidFindBy(id = "com.testingcup:id/ftitle")
	private AndroidElement activityTitle;
	
	public ActivityDetailsPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public String getActivityTitle(){
		return activityTitle.getText();
	}
}
