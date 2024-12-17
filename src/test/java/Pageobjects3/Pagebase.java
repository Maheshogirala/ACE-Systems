package Pageobjects3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Pagebase {

	public static WebDriver dr;
	
	public Pagebase(WebDriver dr) {
		
		this.dr=dr;
		PageFactory.initElements(dr, this);
	}
	
	
}
