package com.Selenium.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataUtil {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;

	public static Object[][] getExcelDataIn2DArray(String excelPath,String SheetName) throws Exception {
		
		
		FileInputStream file=new FileInputStream(excelPath);
		ExcelWBook= new XSSFWorkbook(file);
		ExcelWSheet=ExcelWBook.getSheet(SheetName);
		int rowCount= ExcelWSheet.getLastRowNum();
		int columnCount= ExcelWSheet.getRow(0).getLastCellNum();
		
		Object data[][]= new Object[rowCount][columnCount];
		
		for(int r=1;r<=rowCount;r++) {
		XSSFRow	row=ExcelWSheet.getRow(r);
		  for(int c=0;c<columnCount;c++) {
			  XSSFCell cell = row.getCell(c);
			  data[r][c]=cell.getStringCellValue();
              
			 //CellType cellType = cell.getCellType();
			  //data[r][c]=cell;
			 
//			 switch(cellType) {
//			 
//			 case STRING:data[r][c]=cell.getStringCellValue();
//					 break;
//			 }
		  }
		}
		
		return data;
	}
}

