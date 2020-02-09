package com.rohit.automation.util;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	@DataProvider
	public static Object[][] getData(){
		String[][] data={{"user@phptravel.com","asdfasdf"},{"user@gmail.com","demouser"}};
		return data;
		
	}
}
