package automation;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ParticipantsListElement {
	@AndroidFindBy(id = "com.testingcup:id/logo")
	private AndroidElement logo;
	@AndroidFindBy(id = "com.testingcup:id/name")
	private AndroidElement name;
	@AndroidFindBy(id = "com.testingcup:id/place")
	private AndroidElement place;
}
