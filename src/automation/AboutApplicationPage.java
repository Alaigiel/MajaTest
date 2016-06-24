package automation;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AboutApplicationPage extends BasePage{
	
	@AndroidFindBy(id = "com.testingcup:id/title")
	private AndroidElement aboutApplicationTitle;
	@AndroidFindBy(id = "com.testingcup:id/program_version")
	private AndroidElement version;
	@AndroidFindBy(id = "com.testingcup:id/logo_black")
	private AndroidElement logo;
	@AndroidFindBy(id = "com.testingcup:id/program_info")
	private AndroidElement applicationInfo;
	@AndroidFindBy(id = "com.testingcup:id/developer_text")
	private AndroidElement developerText;

	public AboutApplicationPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String getAboutApplicationPageTitle(){
		return aboutApplicationTitle.getText();
	}
	
	public String getApplicationVersion(){
		return version.getText();
	}

}
