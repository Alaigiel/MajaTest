package automation;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SpeakersPage extends BasePage{

	@AndroidFindBy(id = "com.testingcup:id/logo")
	private AndroidElement testingCupLogo;
	
	@AndroidFindBy(id = "com.testingcup:id/title")
	private AndroidElement speakersTitle;
	
	@AndroidFindBys({
		@AndroidFindBy(id = "android:id/list"),
		@AndroidFindBy(id = "com.testingcup:id/speaker_text")
	})
	private List<AndroidElement> speakersList;
	
	@AndroidFindBys({
		@AndroidFindBy(id = "android:id/list"),
		@AndroidFindBy(id = "com.testingcup:id/like")
	})
	private List<AndroidElement> likesList;
	
	public SpeakersPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String getSpeakersPageTitle(){
		return speakersTitle.getText();
	}
	
	public void likeClick(int speakerId){
		waitAndClickElement(likesList.get(speakerId));
	}
	
	/**
	 * Compares color of the pixel from the center of a star image before tap with color of the pixel 
	 * from the center of a star image after tap.
	 * Returns true if colors are different
	 * @param speakerId
	 * @return 
	 */
	public boolean checkIfLikeClicked(int speakerId){
		int pixelColor = 0;
		int pixelColorAfterLike =0;
		
		File firstScreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Point centerPoint = likesList.get(speakerId).getCenter();
		
		try {
			pixelColor = ImageIO.read(firstScreen).getRGB(centerPoint.x, centerPoint.y);
			//JOptionPane.showMessageDialog(null, Integer.toString(pixelColor));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		likeClick(speakerId);
		
		File secondScreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			pixelColorAfterLike = ImageIO.read(secondScreen).getRGB(centerPoint.x, centerPoint.y);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return (pixelColor != pixelColorAfterLike);	
	}

}
