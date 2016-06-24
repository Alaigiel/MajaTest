package automation;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/*
 * TO DO:
 * add logic for scrolling articles list
 */

public class NewsPage extends BasePage{

	@AndroidFindBy(id = "com.testingcup:id/logo")
	private AndroidElement testingCupLogo;
	
	@AndroidFindBy(id = "com.testingcup:id/title")
	private AndroidElement newsTitle;
	
	@AndroidFindBys({
		@AndroidFindBy(id = "android:id/list"),
		@AndroidFindBy(id = "com.testingcup:id/title")
	})
	private List<AndroidElement> newsList;
	

	public NewsPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String getNewsPageTitle(){
		return(waitAndGetText(newsTitle));
	}
	
	public String getArticleTitleOnTheList(int id){
		return(waitAndGetText(newsList.get(id)));
	}
	
	public ArticlePage openArticle(int id){
		waitAndClickElement(newsList.get(id));
		return new ArticlePage(driver);
	}
	
}
