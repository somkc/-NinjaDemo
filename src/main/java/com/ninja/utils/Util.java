package com.ninja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.ninja.base.Base;

public class Util {
	
	public static String getTimeStamp() {
		
		Date  date= new Date();
		
		System.out.println(date);
		return date.toString().replace(" ", "");
	}
	public static String getRandomEmail() {
		
		String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

				 // creating a StringBuffer size of AlphaNumericStr

				 StringBuilder s = new StringBuilder();

				 int i;

				 for ( i=0; i<6; i++) {

				   //generating a random number using math.random()

				   int ch = (int)(AlphaNumericStr.length() * Math.random());

				   //adding Random character one by one at the end of s

				   s.append(AlphaNumericStr.charAt(ch));

				  }

				    return s.toString();
	}
	
	public static Object[][] getTestDataFromExcel(String sheetName) throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ninja\\testData\\NinjaLoginData.xls");
		HSSFWorkbook workbook=new HSSFWorkbook(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[rows][cols];
		
		for(int i=0;i<rows;i++) {
			
			Row row=sheet.getRow(i+1);
		     for(int j=0;j<cols;j++) {
		    	 Cell cell=row.getCell(j);
		    	 
		    	 switch(cell.getCellType()) {
		    	 case STRING:
		    	 data[i][j]=cell.getStringCellValue();
		    	 break;
		    	 case NUMERIC:
		    		 data[i][j]=Integer.toString((int) cell.getNumericCellValue());
		    		 break;
		    	 case BOOLEAN:
		    		 data[i][j]=cell.getBooleanCellValue();
		    		 break;
		    	 }
		    	
		    	 
		     }
		              
		}
		System.out.println(data[0][1]);
		return data;
		
	}
	
	public static String getScreenshot(String testName) {
		 File srcScreenshot=((TakesScreenshot)Base.driver).getScreenshotAs(OutputType.FILE); 
		   String destinationScreenshotPath=System.getProperty("user.dir")+"\\Screenshot\\"+testName+".jpeg";
		 
		   try {
			FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return destinationScreenshotPath;
	}

	public static void main(String[] args) throws Exception {
	//	System.out.println(getTimeStamp());
	//	System.out.println(getRandomEmail());
		getTestDataFromExcel("Login");

	}

}
