package automation;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Menu extends BasePage{
	@AndroidFindBy(id = "com.testingcup:id/menu")
	private AndroidElement menu;

	@AndroidFindBy(id = "com.testingcup:id/developer")
	private AndroidElement logo21cn;
	
	@AndroidFindBy(id = "com.testingcup:id/news_drawer_image")
	private AndroidElement newsIcon;
	
	@AndroidFindBy(id = "com.testingcup:id/news_drawer_text")
	private AndroidElement newsMenuText;
	
	@AndroidFindBy(id = "com.testingcup:id/schedule_drawer_image")
	private AndroidElement scheduleIcon;
	
	@AndroidFindBy(id = "com.testingcup:id/schedule_drawer_text")
	private AndroidElement scheduleMenuText;
	
	@AndroidFindBy(id = "com.testingcup:id/speakers_drawer_image")
	private AndroidElement speakersIcon;
	
	@AndroidFindBy(id = "com.testingcup:id/speakers_drawer_text")
	private AndroidElement speakersMenuText;
	
	@AndroidFindBy(id = "com.testingcup:id/participants_drawer_image")
	private AndroidElement participantsIcon;
	
	@AndroidFindBy(id = "com.testingcup:id/participants_drawer_text")
	private AndroidElement participantsMenuText;
	
	@AndroidFindBy(id = "com.testingcup:id/sponsors_drawer_image")
	private AndroidElement sponsorsIcon;
	
	@AndroidFindBy(id = "com.testingcup:id/sponsors_drawer_text")
	private AndroidElement sponsorsMenuText;
	
	@AndroidFindBy(id = "com.testingcup:id/map_drawer_image")
	private AndroidElement placeIcon;
	
	@AndroidFindBy(id = "com.testingcup:id/map_drawer_text")
	private AndroidElement placeMenuText;
	
	@AndroidFindBy(id = "com.testingcup:id/testingcup_drawer_image")
	private AndroidElement aboutTestingCupIcon;
	
	@AndroidFindBy(id = "com.testingcup:id/testingcup_drawer_text")
	private AndroidElement aboutTestingCupMenuText;
	
	@AndroidFindBy(id = "com.testingcup:id/program_drawer_image")
	private AndroidElement aboutAppIcon;
	
	@AndroidFindBy(id = "com.testingcup:id/program_drawer_text")
	private AndroidElement aboutAppMenuText;
	
	private static String companyWebPage = "21cn.pl";
	
	public Menu(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String getCompanyWebPageUrl(){
		return companyWebPage;
	}
	
	public String getNewsMenuText(){
		return newsMenuText.getText();
	}
	
	public NewsPage navigateToNewsPage(){
		waitAndClickElement(menu);
		waitAndClickElement(newsMenuText);
		return new NewsPage(driver);
	}
	
	public String getScheduleMenuText(){
		return scheduleMenuText.getText();
	}
	
	public SchedulePage navigateToSchedulePage(){
		waitAndClickElement(menu);
		waitAndClickElement(scheduleMenuText);
		return new SchedulePage(driver);
	}

	public String getSpeakersMenuText(){
		return speakersMenuText.getText();
	}
	
	public SpeakersPage navigateToSpeakersPage(){
		waitAndClickElement(menu);
		waitAndClickElement(speakersMenuText);
		return new SpeakersPage(driver);
	}
	
	public String getParticipantsMenuText(){
		return participantsMenuText.getText();
	}
	
	public ParticipantsPage navigateToParticipantsPage(){
		waitAndClickElement(menu);
		waitAndClickElement(participantsMenuText);
		
		return new ParticipantsPage(driver);
	}
	
	public String getSponsorsMenuText(){
		return sponsorsMenuText.getText();
	}
	
	public SponsorsPage navigateToSponsorsPage(){
		waitAndClickElement(menu);
		waitAndClickElement(sponsorsMenuText);
		
		return new SponsorsPage(driver);
	}
	
	public String getPlaceMenuText(){
		return placeMenuText.getText();
	}
	
	public PlacePage navigateToPlacePage(){
		waitAndClickElement(menu);
		waitAndClickElement(placeMenuText);
		
		return new PlacePage(driver);
	}
	
	public String getAboutTestingCupMenuText(){
		return aboutTestingCupMenuText.getText();
	}
	
	public AboutTestingCupPage navigateToAboutTestingCupPage(){
		waitAndClickElement(menu);
		waitAndClickElement(aboutTestingCupMenuText);
		
		return new AboutTestingCupPage(driver);
	}
	
	public String getAboutApplicationMenuText(){
		return aboutAppMenuText.getText();
	}
	
	public AboutApplicationPage navigateToAboutApplicationPage(){
		waitAndClickElement(menu);
		waitAndClickElement(aboutAppMenuText);
		
		return new AboutApplicationPage(driver);
	}
	
	public void navigateToCompanyWebPage(){
		waitAndClickElement(menu);
		waitAndClickElement(logo21cn);
	}
}
