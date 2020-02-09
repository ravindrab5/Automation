package com.rohit.automation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;
	
	public AccountPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
				
	}
	
	@FindBy(xpath="//h3[@class='text-align-left']")
	private WebElement userWelcomeTxt;
	
	public String getUserWelComeText(){
		return userWelcomeTxt.getText();
	}
	
	public void clickOnInvoice(String bookingId){
		String xpath="//div[div[span[text()=' "+bookingId+"']]]/div/a";
		driver.findElement(By.xpath(xpath)).click();
	}
}
