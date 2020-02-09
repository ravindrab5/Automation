package com.rohit.automation;

import java.io.InputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.rohit.automation.pageobject.LoginPage;
import com.rohit.automation.util.PropertyFileReader;

public class DemoTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		PropertyFileReader propFile=new PropertyFileReader("qa.properties");
		String url=propFile.getValue("url");
		String username=propFile.getValue("user_admin");
		String password=propFile.getValue("password");
		
				
				//.getResourceAsStream("/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get(url);
		LoginPage page=new LoginPage(driver);
		page.login(username, password);

		Thread.sleep(10000);
		

		
		
	}

}
