package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Testutil;

public class ContactPageTest extends TestBase
{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	String sheetname = "Contact";
	
	
	public ContactPageTest()
	{
		super();
	}
	
	
	@BeforeMethod()	
	
	public void setup()
	{
		initialization();
		contactspage = new ContactsPage();
		loginpage = new LoginPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage=homepage.Clickonconlink();
		
	}
	
@Test(priority = 1)
	
	public void verifycontactspagetest()
	{
		Assert.assertTrue(contactspage.veriftcontactpage(),"Contact label is missing");
	}
	
	
	@DataProvider
	
	public Object[][]  getCRMTestData()
	{
		
		Object data[][]=Testutil.getTestData(sheetname);
		return data;
	}
	
	
	@Test(priority = 1,dataProvider="getCRMTestData")
	public void validatecreatenewcontact(String fname,String lname)
	{
		homepage.clickonNewContact();
		contactspage.createnewcontact(fname,lname);
		
	}
	
	@AfterMethod
	public void teardown()
	{
	driver.quit();
}
	
	
}
