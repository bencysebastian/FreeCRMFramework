package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class Testutil extends TestBase{

	public static long page_load_Timeout = 20;
	public static long implicit_wait_timeout =20;
	
	public static String TestDataPath="D:\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\Test Data.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	
	public static  Object[][] getTestData(String sheetname)
	{
	FileInputStream file =null;
	
	try {
		file = new FileInputStream(TestDataPath);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
			book=WorkbookFactory.create(file);
	} catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	 sheet=book.getSheet(sheetname);
	Object[][] data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0;i<sheet.getLastRowNum();i++)
	{
		for (int k=0;k<sheet.getRow(0).getLastCellNum();k++)
		{
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
	}
	
	
	public static  void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	
	
	
}
