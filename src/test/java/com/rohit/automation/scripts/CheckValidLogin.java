package com.rohit.automation.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rohit.automation.TestBase;
import com.rohit.automation.pageobject.LoginPage;
import com.rohit.automation.util.TestDataProvider;

public class CheckValidLogin extends TestBase{

	@BeforeMethod
	public void setupMethod(){
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); 
		loginPage=new LoginPage(driver);
	}
	
	@AfterMethod
	public void tearDownDriver(){
		System.out.println("Inside after method");
		driver.quit();
	}
	
	@Test
	public void testLogin() throws InterruptedException{
		driver.get(url);
		logger.info("Naviating to "+url);
		
		accountPage=loginPage.login(username, password);
		logger.info("Logging in as user "+username);
		
		Assert.assertEquals("Hi, Demo User", accountPage.getUserWelComeText());
		accountPage.clickOnInvoice("138");
		logger.info("Clicked on invoice ");
		
		Thread.sleep(10000);
	}
	
	@Test(dataProviderClass=TestDataProvider.class,dataProvider="getData")
	public void checkInvalidLogin(String username,String password){
		driver.get(url);
		logger.info("Naviating to "+url);
		
		loginPage.login(username, password);
		logger.info("Logging in as user "+username);
		
		Assert.assertEquals("Invalid Email or Password", loginPage.getErrorText());
		
	}
		
}
