package automation;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ArticlePage extends BasePage{

	@AndroidFindBy(id = "com.testingcup:id/news_title")
	private AndroidElement articleTitle;
	@AndroidFindBy(id = "com.testingcup:id/news_pubDate")
	private AndroidElement publishingDate;
	@AndroidFindBy(id = "com.testingcup:id/news_content")
	private AndroidElement articleText;
	
	public ArticlePage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String getArticleTitle(){
		return articleTitle.getText();
	}
}
