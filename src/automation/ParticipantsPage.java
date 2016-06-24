package automation;

import java.awt.Window;
import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ParticipantsPage extends BasePage {

	@AndroidFindBy(id = "com.testingcup:id/logo")
	private AndroidElement testingCupLogo;

	@AndroidFindBy(id = "com.testingcup:id/title")
	private AndroidElement participantsTitle;

	@AndroidFindBy(id = "com.testingcup:id/teamButton")
	private AndroidElement teamsButton;

	@AndroidFindBy(id = "com.testingcup:id/singleButton")
	private AndroidElement singleButton;

	@AndroidFindBys({ @AndroidFindBy(id = "android:id/list"), @AndroidFindBy(id = "com.testingcup:id/name") })
	private List<AndroidElement> teamsList;

	@AndroidFindBys({ @AndroidFindBy(id = "android:id/list"), @AndroidFindBy(id = "com.testingcup:id/name") })
	private List<AndroidElement> singleList;

	@AndroidFindBys({ @AndroidFindBy(id = "android:id/list"), @AndroidFindBy(id = "com.testingcup:id/logo") })
	private List<AndroidElement> logoList;

	@AndroidFindBys({ @AndroidFindBy(id = "android:id/list"), @AndroidFindBy(id = "com.testingcup:id/container") })
	private List<AndroidElement> line;

	private SingleParticipantPage singleParticipantPage;
	private TeamParticipantPage teamParticipantPage;

	private int numberOfScrollsDone;

	public ParticipantsPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public ParticipantsPage getParticipantsPageForGivenId(int id, List<AndroidElement> list) {
		
		if (id < list.size()) {
			return this;
		} else {
			Gesture scrollGesture = new Gesture(driver);

			// <--- how to get max elements
			// int maxElements = 21;

			int maxScrolls = id - list.size();

			for (numberOfScrollsDone = 0; numberOfScrollsDone <= maxScrolls; numberOfScrollsDone++) {
				int lastId = list.size() - 1;
				Point leftUpperCorner = logoList.get(lastId).getLocation();
				int elementWidth = logoList.get(lastId).getSize().width;
				int elementHeight = logoList.get(lastId).getSize().height;
				Point rightUpperCorner = logoList.get(lastId).getLocation().moveBy(elementWidth, 0);
				Point leftLowerCorner = logoList.get(lastId).getLocation().moveBy(0, elementHeight);

				int scrollStartX = (int) (rightUpperCorner.x - leftUpperCorner.x) / 2;

				int adjustBy = (int)(line.get(3).getSize().height /2);
				scrollGesture.scrollToNextListElement(leftLowerCorner.y, leftUpperCorner.y, scrollStartX, adjustBy);
			}

			return new ParticipantsPage(driver);
		}
	}

	public ParticipantsPage getParticipantsPageForGivenIdSingleList(int id) {
		return (getParticipantsPageForGivenId(id, singleList));
	}

	public int getActualListId(int id, List<AndroidElement> list) {
		if (id < list.size()) {
			return id;
		} else {
			return (list.size() - 1);
		}
	}

	public int getActualSingleListId(int id) {
		return (getActualListId(id, singleList));
	}

	public int getActualTeamListId(int id) {
		return (getActualListId(id, teamsList));
	}

	public String getParticipantsPageTitle() {
		return participantsTitle.getText();
	}

	public String getTeamsButtonText() {
		return teamsButton.getText();
	}

	public void teamsButtonClick() {
		waitAndClickElement(teamsButton);
	}

	public String getSingleButtonText() {
		return singleButton.getText();
	}

	public void singleButtonClick() {
		waitAndClickElement(singleButton);
	}

	public void participantListClick(List<AndroidElement> element, int id) {
		waitAndClickElement(element.get(id));
	}

	public String getParticipantName(int id) {
		return singleList.get(id).getText();
	}

	public SingleParticipantPage checkInformationAboutSingleParticipant(int id) {
		int actualId = getActualSingleListId(id);
		participantListClick(singleList, actualId);

		return new SingleParticipantPage(driver);
	}

	public String getTeamParticipantName(int id) {
		return teamsList.get(id).getText();
	}

	// change required for scroll
	public TeamParticipantPage checkInformationAboutTeamParticipant(int id) {
		teamsButtonClick();
		participantListClick(teamsList, id);

		return new TeamParticipantPage(driver);
	}
}
