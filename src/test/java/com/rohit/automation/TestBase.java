package com.rohit.automation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.rohit.automation.pageobject.LoginPage;
import com.rohit.automation.util.PropertyFileReader;

public class TestBase {

	protected PropertyFileReader propFile;
	protected String url;
	protected String username;
	protected String password;
	
	protected WebDriver driver;
	protected LoginPage loginPage;
	
	@BeforeTest
	public void setupTest(){
		propFile=new PropertyFileReader("qa.properties");
		url=propFile.getValue("url");
		username=propFile.getValue("user_admin");
		password=propFile.getValue("password");
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	}
}
