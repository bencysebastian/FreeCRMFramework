package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase 
{
	
@FindBy	(xpath="//span[.='Bency Sebastian']")
public WebElement uslabel;

@FindBy(xpath="//span[.='Contacts']")
public WebElement conlink;

@FindBy(xpath="//span[.='Deals']")
public WebElement deals;

@FindBy(xpath="//div[@id='dashboard-toolbar']/div[2]/div[1]//a")
public WebElement newcontact;

 //initializing

public HomePage()
{
	PageFactory.initElements(driver, this);
}


public String VerifyHomepagetitile()
{
	return driver.getTitle();
}
public boolean verifyusername()
{
	return uslabel.isDisplayed();
}

public ContactsPage Clickonconlink()
{
	conlink.click();
	return new ContactsPage();

}

public DealsPage ClickonDeallink()
{
	deals.click();
	return new DealsPage();

}

public ContactsPage clickonNewContact()
{
newcontact.click();
return new ContactsPage();
	
}

	

}
