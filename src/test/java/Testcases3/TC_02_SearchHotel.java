package Testcases3;

import org.testng.annotations.Test;

import Pageobjects3.SearchHotel;

public class TC_02_SearchHotel extends Base3 {
	//public LoginPage lp;
	public SearchHotel sh;
	
	@Test
	public void SearchHotelTest() {
		
//		//Login
//		lp=new LoginPage(driver);
//		lp.setUsername();
//		lp.setPassword();
//		lp.clickLoginButton();
		
		//Search Hotel
		sh=new SearchHotel(dr);
		sh.setLocation();
		sh.setRoomNo();
		sh.setDatePickIn();
		sh.setDatePickOut();
		sh.clickSearchButton();
}
}