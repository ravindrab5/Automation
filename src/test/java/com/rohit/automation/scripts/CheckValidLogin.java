package com.rohit.automation.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rohit.automation.TestBase;
import com.rohit.automation.pageobject.LoginPage;

public class CheckValidLogin extends TestBase{

	@BeforeMethod
	public void setupMethod(){
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		loginPage=new LoginPage(driver);
	}
	
	@Test
	public void testLogin() throws InterruptedException{
		loginPage.login(username, password);
		Thread.sleep(10000);
	}
	
}
