package automation;

import java.util.Vector;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//problem: how to find/check icon placed before team member name?
public class TeamParticipantPage extends BasePage{
	@AndroidFindBy(id = "com.testingcup:id/team_logo")
	private AndroidElement logo;
	@AndroidFindBy(id = "com.testingcup:id/name")
	private AndroidElement teamName;
	@AndroidFindBy(id = "com.testingcup:id/place")
	private AndroidElement place;
	@AndroidFindBy(id = "com.testingcup:id/participant1")
	private AndroidElement teamLeader;
	@AndroidFindBy(id = "com.testingcup:id/participant2")
	private AndroidElement firstTeamMember;
	@AndroidFindBy(id = "com.testingcup:id/participant3")
	private AndroidElement secondTeamMember;
	@AndroidFindBy(id = "com.testingcup:id/pointsResultRound1")
	private AndroidElement pointsLabel;
	@AndroidFindBy(id = "com.testingcup:id/pointsResultRound1Value")
	private AndroidElement pointsGained;
	
	public TeamParticipantPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public String getTeamName(){
		return teamName.getText();
	}
	
	public String getTeamLeader(){
		return teamLeader.getText();
	}
	
	public Vector<String> getMembers(){
		Vector<String> members = new Vector<String>();
		members.add(firstTeamMember.getText());
		members.add(secondTeamMember.getText());
		
		return members;
	}
	
	public String getPointsLabel(){
		return pointsLabel.getText();
	}
	
	public String getPointsGained(){
		return pointsGained.getText();
	}
}
