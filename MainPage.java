package automation;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainPage extends BasePage{
	
	@AndroidFindBy(id = "com.testingcup:id/logo")
	private AndroidElement testingCupLogo;
	
	@AndroidFindBy(id="com.testingcup:id/text")
	private AndroidElement mainTitle;
	
	@AndroidFindBy(id = "com.testingcup:id/news_image")
	private AndroidElement news;	
	@AndroidFindBy(id = "com.testingcup:id/news_text")
	private AndroidElement newsText;
	
	@AndroidFindBy(id = "com.testingcup:id/schedule_image")
	private AndroidElement schedule;
	@AndroidFindBy(id = "com.testingcup:id/schedule_text")
	private AndroidElement scheduleText;
	
	@AndroidFindBy(id ="com.testingcup:id/speakers_image")
	private AndroidElement speakers;
	@AndroidFindBy(id = "com.testingcup:id/speakers_text")
	private AndroidElement speakersText;
	
	@AndroidFindBy(id = "com.testingcup:id/participants_image")
	private AndroidElement participants;
	@AndroidFindBy(id = "com.testingcup:id/participants_text")
	private AndroidElement participantsText;
	
	@AndroidFindBy(id = "com.testingcup:id/sponsors_image")
	private AndroidElement sponsors;
	@AndroidFindBy(id = "com.testingcup:id/sponsors_text")
	private AndroidElement sponsorsText;
	
	@AndroidFindBy(id = "com.testingcup:id/map_image")
	private AndroidElement place;
	@AndroidFindBy(id = "com.testingcup:id/map_text")
	private AndroidElement placeText;
	
	@AndroidFindBy(id = "com.testingcup:id/testingcup_image")
	private AndroidElement aboutTestingCup;
	@AndroidFindBy(id = "com.testingcup:id/testingcup_text")
	private AndroidElement aboutTestingCupText;
	
	@AndroidFindBy(id = "com.testingcup:id/facebook_image")
	private AndroidElement facebook;
	
	@AndroidFindBy(id = "com.testingcup:id/twitter_image")
	private AndroidElement tweeter;
	@AndroidFindBy(id = "com.testingcup:id/twitter_text")
	private AndroidElement tweeterText;
	

	public MainPage(AndroidDriver<AndroidElement> driver){
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String getNewsTileTitle(){
		return newsText.getText();
	}
	
	public NewsPage navigateToNewsPage(){
		waitAndClickElement(news);
		return new NewsPage(driver);
	}
	
	public String getScheduleTileTitle(){
		return scheduleText.getText();
	}
	
	public SchedulePage navigateToSchedulePage(){
		waitAndClickElement(schedule);
		return new SchedulePage(driver);
	}
	
	public String getSpeakersTileTitle(){
		return speakersText.getText();
	}
	
	public SpeakersPage navigateToSpeakersPage(){
		waitAndClickElement(speakers);
		return new SpeakersPage(driver);
	}
	
	public String getParticipantsTileTitle(){
		return participantsText.getText();
	}
	
	public ParticipantsPage navigateToParticipantsPage(){
		waitAndClickElement(participants);
		return new ParticipantsPage(driver);
	}
	
	public String getSponsorsTileTitle(){
		return sponsorsText.getText();
	}
	
	public SponsorsPage navigateToSponsorsPage(){
		waitAndClickElement(sponsors);
		return new SponsorsPage(driver);
	}
	
	public String getPlaceTileTitle(){		
		return waitAndGetText(placeText);
	}
	
	public PlacePage navigateToPlacePage(){
		waitAndClickElement(place);
		return new PlacePage(driver);
	}
	
	public String getAboutTestingCupTileTitle(){
		return waitAndGetText(aboutTestingCupText);
	}
	
	public AboutTestingCupPage navigateToAboutTestingCupPage(){
		waitAndClickElement(aboutTestingCup);
		return new AboutTestingCupPage(driver);
	}
	
	public Facebook navigateToFacebook(){
		waitAndClickElement(facebook);
		return new Facebook(driver);
	}
	
	public void navigateToMainPage(){
		waitAndClickElement(testingCupLogo);
	}
	


}
