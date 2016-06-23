package automation;

import java.util.List;
import java.util.Vector;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ParticipantsPage extends BasePage{
	
	@AndroidFindBy(id = "com.testingcup:id/logo")
	private AndroidElement testingCupLogo;
	
	@AndroidFindBy(id = "com.testingcup:id/title")
	private AndroidElement participantsTitle;
	
	@AndroidFindBy(id = "com.testingcup:id/teamButton")
	private AndroidElement teamsButton;
	
	@AndroidFindBy(id = "com.testingcup:id/singleButton")
	private AndroidElement singleButton;
	
/*	@AndroidFindBy(id = "com.testingcup:id/container")
	private Vector<AndroidElement> teamsList;
	*/
	@AndroidFindBys({
		@AndroidFindBy(id = "android:id/list"), 
		@AndroidFindBy(id = "com.testingcup:id/name")})
	private List<AndroidElement> singleList;
	
	private SingleParticipantPage singleParticipantPage;
	private TeamParticipantPage teamParticipantPage;

	public ParticipantsPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String getParticipantsPageTitle(){
		return participantsTitle.getText();
	}
	
	public String getTeamsButtonText(){
		return teamsButton.getText();
	}
	
	public void teamsButtonClick(){
		waitAndClickElement(teamsButton);
	}
	
	public String getSingleButtonText(){
		return singleButton.getText();
	}
	
	public void singleButtonClick(){
		waitAndClickElement(singleButton);
	}
	
	public void participantListClick(List<AndroidElement> element){
		waitAndClickElement(element.get(1));
	}
	
	public String getParticipantName(){
		return singleList.get(1).getText();
	}

	public SingleParticipantPage checkInformationAboutSingleParticipant(){
		singleButtonClick();
		participantListClick(singleList);
		
		return new SingleParticipantPage(driver);
	}
}
