package Tests;

import org.testng.annotations.Test;


import com.Pages.Form;
import com.Selenium.Util.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormsUsingPageFactoryTest extends BaseTestClass {
	Form formobj; //new Form(dr);
	@Test(dataProvider = "dpitis")
	public void test1(String FN, String LN, String G, String no) throws Throwable {
		//Form formobj = PageFactory.initElements(dr, Form.class);
		
		//initialize driver to Form
	    formobj= new Form(dr);// Here dr is inherited from base class(BaseTestClass)
		formobj.scrollInto();
		formobj.clickFormTab();
		formobj.fillform(FN, LN, G, no);
		// this.clickFormTab();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		formobj.selectAndClickSubject("hi");
		// dr.quit();

	}
	
	
	 @Ignore@Test
	public void Waits() {
		//formobj.SubjectField("h");
	//	WebElement subject=formobj.getSubjectelem();
		//WebDriverWait wait= new WebDriverWait(dr,Duration.ofSeconds(10));/////explicit wait
		//wait.until(ExpectedConditions.visibilityOfElementLocated((By) subject));
		
		
	}

	@DataProvider(name = "dpitis")
	public Object[][] dp() throws FileNotFoundException, Throwable {
    /// CSVDataUtil obj= new CSVDataUtil();
        
		Object testdata[][] = CSVDataUtil.csvdata1("\\Project\\Book.csv", "Book");
		
		return testdata;

	}
	//@DataProvider(name = "tempTestData")
	public Object[][] tempTestData() throws Exception {

		Object[][] testData = ExcelDataUtil.getExcelDataIn2DArray("C:\\\\Users\\\\Kshitija\\\\eclipse-workspace\\Project\\working.xlsx", "working");
		//File file= new File(System.getProperty("user.dir"+"\\Project\\working.xlsx"));
		//System.out.println(file);
		//Object[][] testData= ExcelDataUtil.getExcelDataIn2DArray("file","working");
		return testData;
	}

	

}
