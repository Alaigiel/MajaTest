package automation;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewsPage extends BasePage{

	@AndroidFindBy(id = "com.testingcup:id/logo")
	private AndroidElement testingCupLogo;
	
	@AndroidFindBy(id = "com.testingcup:id/title")
	private AndroidElement newsTitle;
	

	public NewsPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String getNewsPageTitle(){
		return(waitAndGetText(newsTitle));
	}
	

}
