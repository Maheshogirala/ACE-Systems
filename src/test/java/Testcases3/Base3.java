package Testcases3;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Base3 {

	public static WebDriver dr;
	public ResourceBundle RB;
	@BeforeSuite
	public void url() {
		RB=ResourceBundle.getBundle("inputdata");
		dr=new ChromeDriver();
		dr.get("https://www.acesystems.com/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
//	@AfterSuite
//	public void closebrowser() {
//		dr.close();
//	}
	
	
	public String screenshot(String tname) throws IOException {
		// time stamp
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		// takescreenshot
		TakesScreenshot ts= (TakesScreenshot)dr;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest= System.getProperty("user.dir")+"\\Screenshots\\"+tname+timestamp+"img01.png";
		try {
		FileUtils.copyFile(source,new File(dest));
		}catch(Exception e) {
			e.getMessage();
		}
		return dest;
		
	}
	
	
}
