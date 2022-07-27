package org.testng.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataPrivoder {
	
	@DataProvider
	public String[][] method() throws IOException {
		String filepath="C:\\Users\\admin\\eclipse-workspace\\testng\\Resources\\login.xlsx";
		
		
		return readdata(filepath,"login");
		
	}
	
	

	@Test
	public String[][] readdata(String filepath,String sheeetname) throws IOException {
		String[][] data=null;
		FileInputStream fi=new FileInputStream(filepath);
		XSSFWorkbook ws=new XSSFWorkbook(fi);
		XSSFSheet sheet=ws.getSheet(sheeetname);
		int noofrows=sheet.getPhysicalNumberOfRows();
		XSSFRow column= sheet.getRow(0);
		int noofcolumn=column.getPhysicalNumberOfCells();
		XSSFCell cell=null;
		for (int i = 0; i < noofrows-1; i++) {
			for (int j = 0; j <noofcolumn ; j++) {
				
				column=sheet.getRow(i);
				cell=column.getCell(j);
				String cellvalu=cell.getStringCellValue();
				data[i-1][j]=cellvalu;
				
			}
			
		}
		
		return data;
	}
	
	
	
	
	
	
	
}
