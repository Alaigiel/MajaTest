package automation;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SpeakerInfoPage extends BasePage{
	@AndroidFindBy(id = "com.testingcup:id/speaker_image")
	private AndroidElement speakerImage;
	@AndroidFindBy(id = "com.testingcup:id/speaker_text")
	private AndroidElement speakerName;
	@AndroidFindBy(id = "com.testingcup:id/like")
	private AndroidElement speakerLike;
	@AndroidFindBy(id = "com.testingcup:id/speaker_info")
	private AndroidElement speakerInfo;
	
	public SpeakerInfoPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public boolean speakersInfoIsEmpty(){
		return (speakerInfo.getText() != "");
	}
}
