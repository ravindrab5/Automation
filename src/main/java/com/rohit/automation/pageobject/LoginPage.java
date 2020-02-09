package com.rohit.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement loginBtn;
	
	@FindBy(css=".alert.alert-danger")
	private WebElement errorMsg;
	
	public AccountPage login(String uname,String pass){
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginBtn.click();
		return new AccountPage(driver);
	}
	
	public String getErrorText(){
		return errorMsg.getText();
	}
	
}
