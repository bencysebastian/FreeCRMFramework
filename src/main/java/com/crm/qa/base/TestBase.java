package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.crm.qa.util.Testutil;
import com.crm.qa.util.WebEventListener;


public class TestBase {
	
	public  static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	
	public TestBase()
	{
    try {
			prop = new Properties();
			FileInputStream ip;
			ip = new FileInputStream("D:\\FreeCRMTest\\src\\main\\java\\com\\"
						      +"crm\\qa\\config\\Config.properties");
			prop.load(ip);
		} 
	catch (FileNotFoundException e1) {
			e1.printStackTrace();}
			catch (IOException e) {
				e.printStackTrace();
			}
	}
	public  static void initialization() {
	String browsername = prop.getProperty("browser");
	if (browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Practice\\Driver\\chromedriver.exe");
		 driver = new ChromeDriver();
	}
	
	e_driver = new EventFiringWebDriver(driver);
	eventlistener = new WebEventListener();
	e_driver.register(eventlistener);
	driver =e_driver;
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Testutil.page_load_Timeout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Testutil.page_load_Timeout, TimeUnit.SECONDS); 
	driver.get(prop.getProperty("url"));
	}

}
