package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	
	//*[@id="dashboard-toolbar"]/div[1]/text()
	
	@FindBy(xpath ="[//div[@id='dashboard-toolbar']/div[1][.='Contacts']")
	public WebElement contactlabel;
	

	@FindBy(name="first_name")
	public WebElement Firstname;

	@FindBy(name="last_name")
	public WebElement Lastname;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	public WebElement savebtn;


	
public	ContactsPage()
{
	PageFactory.initElements(driver, this);
}

public boolean veriftcontactpage()
{
	return contactlabel.isDisplayed();
}

public void createnewcontact(String fname,String Lname)
{
	Firstname.sendKeys(fname);
	Lastname.sendKeys(Lname);
	savebtn.click();
}
}
