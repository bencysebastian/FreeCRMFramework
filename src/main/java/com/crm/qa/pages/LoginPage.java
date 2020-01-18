package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//pagefactory / OR
	
	@FindBy(name="email")
	private WebElement username; 
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//div/div[(.)='Login']")
	private WebElement LogButton;
	
	//initialise
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}

	//Actions
	public String validatetitle()
	{
		return driver.getTitle();
	}
	
	public HomePage Login(String usname,String Password)
	{
		username.sendKeys(usname);
		password.sendKeys(Password);
		LogButton.click();
		return new HomePage();
	}
	
}
