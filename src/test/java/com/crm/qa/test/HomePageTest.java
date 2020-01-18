package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
 
public HomePageTest()
{
	super();
}
	
	@BeforeMethod()	
	
	public void setup()
	{
		initialization();
		loginpage = new LoginPage();
		homepage=new HomePage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	
	  @Test(priority = 1)
	public void  verifyhomepagetitle()
	{
		
		String title =homepage.VerifyHomepagetitile();
		Assert.assertEquals(title, "Cogmento CRM","Home Page Title not matched");
		
	}
	
	@Test(priority = 2)
	
	public void usernamelable()
	{
		Assert.assertTrue(homepage.verifyusername());
	}
	
	
	@Test(priority=3)
	public void verifycontactlink()
	{
		 contactpage=homepage.Clickonconlink();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
