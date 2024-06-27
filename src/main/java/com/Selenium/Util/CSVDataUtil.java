// 	This class uses CSVReader from CSV dependency added in POM.xml
package com.Selenium.Util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVDataUtil {
	 //Following method is static , so that it can be accessed in other classes without creating the object of CSVDataUtil class
	public static Object[][] csvdata1(String Path,String SheetName) throws FileNotFoundException, Throwable  {
		    

		  String csvFile = "Book.csv";
	      CSVReader reader = new CSVReader(new FileReader(csvFile));
	      List<String[]> allRows = reader.readAll();
	      reader.close();

	      // Convert List<String[]> to Object[][]
	      Object[][] testData = new Object[allRows.size()][];
	      
	      for (int i = 0; i < allRows.size(); i++) {
	          testData[i] = allRows.get(i);
	      }
	      return testData;
	      
	}

	

}
