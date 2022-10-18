package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

 

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import base.TestBase;

public class utilities extends TestBase {
	public static String TESTDATA_SHEET_PATH="C:\\Users\\BMT\\Desktop\\login testData.xlsx";

	public utilities() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public static void takeScreeshot(String name) throws IOException
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,  new File("E:\\automationNewProject\\autoamtionproject\\Test_Report\\"+name+".png"));
 
		
		
		
		
	}
	
 
	
	
	
	
	 public static  Object[][] ReadFromExcel(String SheetName) throws IOException
	 {
		 
		 FileInputStream file = new  FileInputStream("C:\\Users\\BMT\\Desktop\\loginTestData.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 Sheet sheet =workbook.getSheet("Sheet1");
		int RowNum= sheet.getLastRowNum();
		 int ColNum=sheet.getRow(0).getLastCellNum();
		 
		 Object data[][] = new Object[RowNum][ColNum];
		 
		 
		 for(int i =0;i <RowNum;i++) {
		 for(int k=0;k<ColNum;k++) {
			 
			 
			 data[i][k]=sheet.getRow(i).getCell(k).toString();
		 }
		 
 		 }
		 return data;
			 
	 }
 
}
