package automation;

import io.appium.java_client.android.AndroidElement;

public class MenuListElement {
	private AndroidElement icon;
	private AndroidElement textElement;
	
	public MenuListElement(AndroidElement listElement){
		
	}
	
	public AndroidElement getIcon(){
		return icon;
	}
	
	public AndroidElement getTextElement(){
		return textElement;
	}
	
}
