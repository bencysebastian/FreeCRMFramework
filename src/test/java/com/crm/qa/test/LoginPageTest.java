package com.crm.qa.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;



public class LoginPageTest extends TestBase
{

	LoginPage loginPage;
	HomePage homepage;
	//Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	
	public void SetUp()
	{
		initialization();
		 loginPage = new LoginPage();
		
	}
	
	@Test()
	
	public void LoginpageTitletest()
	{
		String  title =loginPage.validatetitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test
	
	public void LoginTest()
	{
		
	homepage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	
	public void TearDown()
	{
		driver.quit();
	}
	
	
	
}
