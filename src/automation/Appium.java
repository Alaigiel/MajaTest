package automation;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Appium {

	private AndroidDriver<AndroidElement> driver;
	private WebElement chromeDriver;

	private MainPage mainPage;
	private NewsPage newsPage;
	private SchedulePage schedulePage;
	private SpeakersPage speakersPage;
	private ParticipantsPage participantsPage;
	private SponsorsPage sponsorsPage;
	private PlacePage placePage;
	private AboutTestingCupPage aboutTestingCupPage;
	private AboutApplicationPage aboutApplicationPage;
	private Facebook facebook;
	private Menu menu;
	private SingleParticipantPage singleParticipantPage;
	private TeamParticipantPage teamParticipantPage;
	private ArticlePage articlePage;

	private String newsExpectedHeader;
	private String scheduleExprectedHeader;
	private String speakersExpectedHeader;
	private String participantExpectedHeader;
	private String sponsorsExpectedHeader;
	private String placeExpectedHeader;
	private String aboutExpectedHeader;
	private String aboutApplicationExpectedHeader;
	private String applicationVersion;

	@AndroidFindBy(id = "com.testingcup:id/text")
	private AndroidElement mainTitle;

	@AndroidFindBy(id = "com.testingcup:id/like")
	private AndroidElement favourite;

	@AndroidFindBy(id = "com.testingcup:id/participants_drawer_text")
	private AndroidElement classificationMenuElement;

	private Dimension screenSize;
	private Gesture gesture;

	public static String url = "http://127.0.0.1:4723/wd/hub";

	public AndroidDriver<AndroidElement> getDriver() {
		return driver;
	}

	@BeforeClass
	public void setUp() throws MalformedURLException {
		/*
		 * try { process = Runtime.getRuntime().exec(
		 * "\"C:/Appium/node.exe\" \"C:/Appium/node_modules/appium/bin/Appium.js\" --local-timezone"
		 * ); } catch (IOException e) {
		 * 
		 * }
		 */
		// address and port are visible when starting Appium server
		// url = "http://127.0.0.1:4723/wd/hub";

		// File app = new File
		// ("D:/Maja-dokumenty/TMSampleAndroid-master/TMSampleAndroid-master/app/build/outputs/apk",
		// "app-debug.app");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities = DesiredCapabilities.android();
		//// capabilities.setCapability("automationName", "Selendroid");
		capabilities.setCapability("device", "Android");
		// capabilities.setCapability(CapabilityType.BROWSER_NAME, ""); //Name
		// of mobile web browser to automate. Should be an empty string if
		// automating an app instead.
		// capabilities.setCapability(CapabilityType.VERSION, "4.1.2");
		// capabilities.setCapability(CapabilityType.PLATFORM, "Windows");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.0"); // Replace this
																// with your iOS
																// version
		// capabilities.setCapability("platformVersion", "4.1.2");
		capabilities.setCapability("deviceName", "Sgs5"); // Replace this
															// with your
															// simulator/device
															// version
		//// capabilities.setCapability("deviceName", "LG5lII");
		// capabilities.setCapability("appPackage",
		//// "com.marketlytics.calabashtest"); // Replace
		// with
		// your
		// app's
		// package
		capabilities.setCapability("appPackage", "com.testingcup");
		capabilities.setCapability("appActivity", "com.testingcup.SplashScreen"); // Replace
		// with
		// app's
		// Activity

		// driver = new RemoteWebDriver(new URL(url), capabilities);
		driver = new AndroidDriver<AndroidElement>(new URL(url), capabilities);

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		mainPage = new MainPage(driver);

		screenSize = driver.manage().window().getSize();
		gesture = new Gesture(driver);

		newsExpectedHeader = "AKTUALNOŒCI";
		scheduleExprectedHeader = "HARMONOGRAM";
		speakersExpectedHeader = "MÓWCY";
		participantExpectedHeader = "KLASYFIKACJA";
		sponsorsExpectedHeader = "SPONSORZY";
		placeExpectedHeader = "MIEJSCE";
		aboutExpectedHeader = "O TESTINGCUP";
		aboutApplicationExpectedHeader = "O PROGRAMIE";
		applicationVersion = "1.8.1";
	}

	@BeforeMethod
	public void returnToMainPage() {
		mainPage.navigateToMainPage();
	}

	@Test(enabled = false)
	public void newsButtonClick() {
		newsPage = mainPage.navigateToNewsPage();
		String newsHeader = newsPage.getNewsPageTitle();

		Assert.assertEquals(newsHeader, newsExpectedHeader);
	}

	@Test(enabled = false)
	public void newsTileTitleCheck() {
		String newsTileTitle = mainPage.getNewsTileTitle();

		Assert.assertEquals(newsTileTitle, newsExpectedHeader);
	}
	
	@Test(enabled = false)
	public void newsReadArticle(){
		newsPage = mainPage.navigateToNewsPage();
				
		int id = 1;
		String articleTitleOnTheList = newsPage.getArticleTitleOnTheList(id);
		articlePage = newsPage.openArticle(id);
		String articleTitle = articlePage.getArticleTitle();
		
		Assert.assertEquals(articleTitle, articleTitleOnTheList);
	}

	@Test(enabled = false)
	public void scheduleButtonClick() {
		schedulePage = mainPage.navigateToSchedulePage();
		String scheduleHeader = schedulePage.getSchedulePageTitle();

		Assert.assertEquals(scheduleHeader, scheduleExprectedHeader);
	}

	@Test(enabled = false)
	public void scheduleTileTitleCheck() {
		String scheduleTileTitle = mainPage.getScheduleTileTitle();

		Assert.assertEquals(scheduleTileTitle, scheduleExprectedHeader);
	}

	@Test(enabled = false)
	public void speakersButtonClick() {
		speakersPage = mainPage.navigateToSpeakersPage();
		String speakersHeader = speakersPage.getSpeakersPageTitle();

		Assert.assertEquals(speakersHeader, speakersExpectedHeader);
	}

	@Test(enabled = false)
	public void speakersTileTitleCheck() {
		String speakersTileTitle = mainPage.getSpeakersTileTitle();

		Assert.assertEquals(speakersTileTitle, speakersExpectedHeader);
	}

	@Test(enabled = false)
	public void participantsButtonClick() {
		participantsPage = mainPage.navigateToParticipantsPage();
		String participantsHeader = participantsPage.getParticipantsPageTitle();

		Assert.assertEquals(participantsHeader, participantExpectedHeader);
	}

	@Test(enabled = false)
	public void participantsTileTitleCheck() {
		String participantsTileTitle = mainPage.getParticipantsTileTitle();

		Assert.assertEquals(participantsTileTitle, participantExpectedHeader);
	}

	@Test(enabled = false)
	public void sponsorsButtonClick() {
		sponsorsPage = mainPage.navigateToSponsorsPage();
		String sponsorsHeader = sponsorsPage.getSponsorsPageTitle();

		Assert.assertEquals(sponsorsHeader, sponsorsExpectedHeader);
	}

	@Test(enabled = false)
	public void sponsorsTileTitleCheck() {
		String sponsorsTileTitle = mainPage.getSponsorsTileTitle();

		Assert.assertEquals(sponsorsTileTitle, sponsorsExpectedHeader);
	}

	@Test(enabled = false)
	public void placeButtonClick() {
		placePage = mainPage.navigateToPlacePage();
		String placeHeader = placePage.getPlacePageTitle();

		Assert.assertEquals(placeHeader, placeExpectedHeader);
	}

	@Test(enabled = false)
	public void placeTileTitleCheck() {
		// wait for main page to load - important!
		mainPage.waitForElement(mainTitle);
		//swipeVertically();
		gesture.scrollDown();
		String placeTileTitle = mainPage.getPlaceTileTitle();

		Assert.assertEquals(placeTileTitle, placeExpectedHeader);
	}

	@Test(enabled = false)
	public void aboutTestingCupButtonClick() {
		aboutTestingCupPage = mainPage.navigateToAboutTestingCupPage();
		String aboutTestingCupHeader = aboutTestingCupPage.getAboutTestingCupPageTitle();

		Assert.assertEquals(aboutTestingCupHeader, aboutExpectedHeader);
	}

	@Test(enabled = false)
	public void aboutTestingCupTileTitleCheck() {
		mainPage.waitForElement(mainTitle);
		//swipeVertically();
		gesture.scrollDown();
		String aboutTestingCupTileTitle = mainPage.getAboutTestingCupTileTitle();

		Assert.assertEquals(aboutTestingCupTileTitle, aboutExpectedHeader);
	}

	@Test(enabled = false)
	public void facebookButtonClick() {
		mainPage.waitForElement(mainTitle);
		gesture.scrollDown();

		facebook = mainPage.navigateToFacebook();
		String facebookExpectedUrl = facebook.getExpectedUrl();
		//this is the key!
		String facebookActualUrl = driver.findElementById("com.android.chrome:id/url_bar").getText();
		
		driver.navigate().back();

		Assert.assertEquals(facebookExpectedUrl, facebookActualUrl);
	}
	
	@Test
	public void menuLogoClick(){
		mainPage.waitForElement(mainTitle);
		menu = new Menu(driver);
		menu.navigateToCompanyWebPage();
		
		String companyExpectedUrl = menu.getCompanyWebPageUrl();
		String companyActualUrl = driver.findElementById("com.android.chrome:id/url_bar").getText();
		
		driver.navigate().back();
		
		Assert.assertEquals(companyActualUrl, companyExpectedUrl);
	}

	@Test(enabled = false)
	public void menuNewsClick() {
		menu = new Menu(driver);
		newsPage = menu.navigateToNewsPage();
		String newsHeader = newsPage.getNewsPageTitle();

		Assert.assertEquals(newsHeader, newsExpectedHeader);
	}

	@Test(enabled = false)
	public void menuScheduleClick() {
		menu = new Menu(driver);
		schedulePage = menu.navigateToSchedulePage();
		String scheduleHeader = schedulePage.getSchedulePageTitle();

		Assert.assertEquals(scheduleHeader, scheduleExprectedHeader);
	}

	@Test(enabled = false)
	public void menuSpeakersClick() {
		menu = new Menu(driver);
		speakersPage = menu.navigateToSpeakersPage();
		String speakersHeader = speakersPage.getSpeakersPageTitle();

		Assert.assertEquals(speakersHeader, speakersExpectedHeader);
	}

	@Test(enabled = false)
	public void menuParticipantsClick() {
		menu = new Menu(driver);
		participantsPage = menu.navigateToParticipantsPage();
		String participantsHeader = participantsPage.getParticipantsPageTitle();

		Assert.assertEquals(participantsHeader, participantExpectedHeader);
	}

	@Test(enabled = false)
	public void menuSponsorsClick() {
		menu = new Menu(driver);
		sponsorsPage = menu.navigateToSponsorsPage();
		String sponsorsHeader = sponsorsPage.getSponsorsPageTitle();
		
		Assert.assertEquals(sponsorsHeader, sponsorsExpectedHeader);
	}
	
	@Test(enabled = false)
	public void menuPlaceClick(){
		menu = new Menu(driver);
		placePage = menu.navigateToPlacePage();
		String placeHeader = placePage.getPlacePageTitle();
		
		Assert.assertEquals(placeHeader, placeExpectedHeader);
	}
	
	@Test(enabled = false)
	public void menuAboutTestingCupClick(){
		menu = new Menu(driver);
		aboutTestingCupPage = menu.navigateToAboutTestingCupPage();
		String aboutTestingCupHeader = aboutTestingCupPage.getAboutTestingCupPageTitle();
		
		Assert.assertEquals(aboutTestingCupHeader, aboutExpectedHeader);
	}
	
	@Test(enabled = false)
	public void menuAboutApplicationClick(){
		menu = new Menu(driver);
		aboutApplicationPage = menu.navigateToAboutApplicationPage();
		String aboutApplicationHeader = aboutApplicationPage.getAboutApplicationPageTitle();
		
		Assert.assertEquals(aboutApplicationHeader, aboutApplicationExpectedHeader);
	}
	
	@Test(enabled = false)
	public void checkApplicationVersion(){
		menu = new Menu(driver);
		aboutApplicationPage = menu.navigateToAboutApplicationPage();
		String applicationVersionFromMobile = aboutApplicationPage.getApplicationVersion();
		
		Assert.assertEquals(applicationVersionFromMobile, applicationVersion);
	}
	
	@Test(enabled = false)
	public void participantsSingleNameCheck(){
		participantsPage = mainPage.navigateToParticipantsPage();
		participantsPage.singleButtonClick();
		
		int id = 2;		
		String singleParticipantNameOnList = participantsPage.getParticipantName(id);	
		singleParticipantPage = participantsPage.checkInformationAboutSingleParticipant(id);
		
		String singleParticipantName = singleParticipantPage.getName();
		
		Assert.assertEquals(singleParticipantName, singleParticipantNameOnList);
	}
	
	@Test(enabled = false)
	public void participantsTeamNameCheck(){
		participantsPage = mainPage.navigateToParticipantsPage();	
		participantsPage.teamsButtonClick();
		
		int id = 4;		
		String teamParticipantNameOnList = participantsPage.getParticipantName(id);		
		teamParticipantPage = participantsPage.checkInformationAboutTeamParticipant(id);
		
		String teamParticipantName = teamParticipantPage.getTeamName();
		
		Assert.assertEquals(teamParticipantName, teamParticipantNameOnList);
	}
	
	@Test(enabled = false)
	public void checkIfLeaderIsMarked(){
		participantsPage = mainPage.navigateToParticipantsPage();
		participantsPage.teamsButtonClick();
		
		int id = 3;
		teamParticipantPage = participantsPage.checkInformationAboutTeamParticipant(id);
		String teamLeaderName = teamParticipantPage.getTeamLeader();
		
		Assert.assertEquals(teamLeaderName.contains("(C)"), true);
	}
	
	@Test(enabled = false)
	public void checkIfPointsGainedIsShown(){
		participantsPage = mainPage.navigateToParticipantsPage();
		participantsPage.singleButtonClick();
		
		int id = 21;
		participantsPage = participantsPage.getParticipantsPageForGivenIdSingleList(id);
		singleParticipantPage = participantsPage.checkInformationAboutSingleParticipant(id);
		String pointsGained = singleParticipantPage.getPointsGained();
		
		Assert.assertEquals(pointsGained.isEmpty(), false);
	}
	
	@Test(enabled = false)
	public void addSpeakerToFavourite(){
		speakersPage = mainPage.navigateToSpeakersPage();		
		int id = 2;
		
		Assert.assertEquals(speakersPage.checkIfLikeClicked(id), true);
	}



	@DataProvider(name = "text")
	public Object[][] testText() {
		return new Object[][] { { "WithoutPolish", "abc" } };// , { "Symbol",
																// "~!@#$%^&*()"
																// }, { "Empty",
																// "" } };
	}

	/*
	 * @Test(dataProvider = "text") public void fillInTheInput(String testCase,
	 * String text) {
	 * 
	 * // filling in the input
	 * driver.findElement(By.id("com.marketlytics.calabashtest:id/editText1")).
	 * sendKeys(text);
	 * driver.findElement(By.id("com.marketlytics.calabashtest:id/button2")).
	 * click();
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, 15);
	 * wait.until(ExpectedConditions.elementToBeClickable(By.id(
	 * "android:id/timePickerLayout")));
	 * 
	 * WebElement label =
	 * driver.findElement(By.id("com.marketlytics.calabashtest:id/textView1"));
	 * Assert.assertEquals(label.getText(), "User had put in text: " + text); }
	 */

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
