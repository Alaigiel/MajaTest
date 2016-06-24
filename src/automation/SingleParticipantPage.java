package automation;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SingleParticipantPage extends BasePage{
	@AndroidFindBy(id = "com.testingcup:id/single_logo")
	private AndroidElement logo;
	@AndroidFindBy(id = "com.testingcup:id/name")
	private AndroidElement name;
	@AndroidFindBy(id = "com.testingcup:id/place")
	private AndroidElement place;
	@AndroidFindBy(id = "com.testingcup:id/pointsResultRound1")
	private AndroidElement pointsLabel;
	@AndroidFindBy(id = "com.testingcup:id/pointsResultRound1Value")
	private AndroidElement pointsGained;
	
	public SingleParticipantPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String getName(){
		return name.getText();
	}
	
	public String getPointsLabel(){
		return pointsLabel.getText();
	}
	
	public String getPointsGained(){
		return pointsGained.getText();
	}
}
