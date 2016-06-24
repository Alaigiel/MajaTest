package automation;

import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Appium {

	private AndroidDriver<AndroidElement> driver;

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

	@Test
	public void newsButtonClick() {
		newsPage = mainPage.navigateToNewsPage();
		String newsHeader = newsPage.getNewsPageTitle();

		Assert.assertEquals(newsHeader, newsExpectedHeader);
	}

	@Test
	public void newsTileTitleCheck() {
		String newsTileTitle = mainPage.getNewsTileTitle();

		Assert.assertEquals(newsTileTitle, newsExpectedHeader);
	}

	@Test(enabled = true)
	public void scheduleButtonClick() {
		schedulePage = mainPage.navigateToSchedulePage();
		String scheduleHeader = schedulePage.getSchedulePageTitle();

		Assert.assertEquals(scheduleHeader, scheduleExprectedHeader);
	}

	@Test
	public void scheduleTileTitleCheck() {
		String scheduleTileTitle = mainPage.getScheduleTileTitle();

		Assert.assertEquals(scheduleTileTitle, scheduleExprectedHeader);
	}

	@Test
	public void speakersButtonClick() {
		speakersPage = mainPage.navigateToSpeakersPage();
		String speakersHeader = speakersPage.getSpeakersPageTitle();

		Assert.assertEquals(speakersHeader, speakersExpectedHeader);
	}

	@Test
	public void speakersTileTitleCheck() {
		String speakersTileTitle = mainPage.getSpeakersTileTitle();

		Assert.assertEquals(speakersTileTitle, speakersExpectedHeader);
	}

	@Test
	public void participantsButtonClick() {
		participantsPage = mainPage.navigateToParticipantsPage();
		String participantsHeader = participantsPage.getParticipantsPageTitle();

		Assert.assertEquals(participantsHeader, participantExpectedHeader);
	}

	@Test
	public void participantsTileTitleCheck() {
		String participantsTileTitle = mainPage.getParticipantsTileTitle();

		Assert.assertEquals(participantsTileTitle, participantExpectedHeader);
	}

	@Test
	public void sponsorsButtonClick() {
		sponsorsPage = mainPage.navigateToSponsorsPage();
		String sponsorsHeader = sponsorsPage.getSponsorsPageTitle();

		Assert.assertEquals(sponsorsHeader, sponsorsExpectedHeader);
	}

	@Test
	public void sponsorsTileTitleCheck() {
		String sponsorsTileTitle = mainPage.getSponsorsTileTitle();

		Assert.assertEquals(sponsorsTileTitle, sponsorsExpectedHeader);
	}

	@Test
	public void placeButtonClick() {
		placePage = mainPage.navigateToPlacePage();
		String placeHeader = placePage.getPlacePageTitle();

		Assert.assertEquals(placeHeader, placeExpectedHeader);
	}

	@Test(enabled = true)
	public void placeTileTitleCheck() {
		// wait for main page to load - important!
		mainPage.waitForElement(mainTitle);
		//swipeVertically();
		gesture.scrollDown();
		String placeTileTitle = mainPage.getPlaceTileTitle();

		Assert.assertEquals(placeTileTitle, placeExpectedHeader);
	}

	@Test
	public void aboutTestingCupButtonClick() {
		aboutTestingCupPage = mainPage.navigateToAboutTestingCupPage();
		String aboutTestingCupHeader = aboutTestingCupPage.getAboutTestingCupPageTitle();

		Assert.assertEquals(aboutTestingCupHeader, aboutExpectedHeader);
	}

	@Test(enabled = true)
	public void aboutTestingCupTileTitleCheck() {
		mainPage.waitForElement(mainTitle);
		//swipeVertically();
		gesture.scrollDown();
		String aboutTestingCupTileTitle = mainPage.getAboutTestingCupTileTitle();

		Assert.assertEquals(aboutTestingCupTileTitle, aboutExpectedHeader);
	}

	@Test(enabled = false)
	public void facebookButtonClick() {
		//swipeVertically();
		gesture.scrollDown();
		facebook = mainPage.navigateToFacebook();
		String facebookExpectedUrl = facebook.getExpectedUrl();
		String facebookActualUrl = facebook.getDriver().getCurrentUrl();

		Assert.assertEquals(facebookExpectedUrl, facebookActualUrl);
	}

	@Test
	public void menuNewsClick() {
		menu = new Menu(driver);
		newsPage = menu.navigateToNewsPage();
		String newsHeader = newsPage.getNewsPageTitle();

		Assert.assertEquals(newsHeader, newsExpectedHeader);
	}

	@Test
	public void menuScheduleClick() {
		menu = new Menu(driver);
		schedulePage = menu.navigateToSchedulePage();
		String scheduleHeader = schedulePage.getSchedulePageTitle();

		Assert.assertEquals(scheduleHeader, scheduleExprectedHeader);
	}

	@Test
	public void menuSpeakersClick() {
		menu = new Menu(driver);
		speakersPage = menu.navigateToSpeakersPage();
		String speakersHeader = speakersPage.getSpeakersPageTitle();

		Assert.assertEquals(speakersHeader, speakersExpectedHeader);
	}

	@Test
	public void menuParticipantsClick() {
		menu = new Menu(driver);
		participantsPage = menu.navigateToParticipantsPage();
		String participantsHeader = participantsPage.getParticipantsPageTitle();

		Assert.assertEquals(participantsHeader, participantExpectedHeader);
	}

	@Test
	public void menuSponsorsClick() {
		menu = new Menu(driver);
		sponsorsPage = menu.navigateToSponsorsPage();
		String sponsorsHeader = sponsorsPage.getSponsorsPageTitle();
		
		Assert.assertEquals(sponsorsHeader, sponsorsExpectedHeader);
	}
	
	@Test
	public void menuPlaceClick(){
		menu = new Menu(driver);
		placePage = menu.navigateToPlacePage();
		String placeHeader = placePage.getPlacePageTitle();
		
		Assert.assertEquals(placeHeader, placeExpectedHeader);
	}
	
	@Test
	public void menuAboutTestingCupClick(){
		menu = new Menu(driver);
		aboutTestingCupPage = menu.navigateToAboutTestingCupPage();
		String aboutTestingCupHeader = aboutTestingCupPage.getAboutTestingCupPageTitle();
		
		Assert.assertEquals(aboutTestingCupHeader, aboutExpectedHeader);
	}
	
	@Test
	public void menuAboutApplicationClick(){
		menu = new Menu(driver);
		aboutApplicationPage = menu.navigateToAboutApplicationPage();
		String aboutApplicationHeader = aboutApplicationPage.getAboutApplicationPageTitle();
		
		Assert.assertEquals(aboutApplicationHeader, aboutApplicationExpectedHeader);
	}
	
	@Test
	public void checkApplicationVersion(){
		menu = new Menu(driver);
		aboutApplicationPage = menu.navigateToAboutApplicationPage();
		String applicationVersionFromMobile = aboutApplicationPage.getApplicationVersion();
		
		Assert.assertEquals(applicationVersionFromMobile, applicationVersion);
	}
	
	@Test(enabled = true)
	public void participantsSingleListCheck(){
		participantsPage = mainPage.navigateToParticipantsPage();
		
		participantsPage.singleButtonClick();
		
		String singleParticipantNameOnList = participantsPage.getParticipantName();
		
		singleParticipantPage = participantsPage.checkInformationAboutSingleParticipant();
		
		String singleParticipantName = singleParticipantPage.getName();
		
		Assert.assertEquals(singleParticipantName, singleParticipantNameOnList);
	}

/*	public void swipeVertically() {
		int swipeStartY = (int) (screenSize.height * 0.5);
		int swipeEndY = (int) (screenSize.height * 0.2);
		int swipeStartX = (int) (screenSize.width / 2);
		int duration = 3000;

		driver.swipe(swipeStartX, swipeStartY, swipeStartX, swipeEndY, duration);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}*/

	// Not possible to check if a star was clicked - no information about action
	// in any of attributes
	@Test(enabled = false)
	public void addSpeakerToFavourite() {
		// String mainTitleText = waitAndGetText(mainTitle);

		/*
		 * if(mainTitleText != "MISTRZOSTWA ZAKOÑCZONE"){
		 * driver.navigate().back(); }
		 */
		// waitAndClickElement(favourite.);

		// Assert.assertEquals(favourite., expected);
	}

	@Test(enabled = false)
	public void checkTeamList() {
		// menu.click();

		// waitAndClickElement(classificationMenuElement);

		AndroidElement team = driver.findElement(By.id("com.testingcup:id/container"));
		team.click();

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
