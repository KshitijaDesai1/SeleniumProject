package Tests;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.Pages.Form;
import com.opencsv.CSVReader;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTestClass {
	WebDriver dr;
	public static Properties envConfig;
	public static final String ENV = System.getProperty("env", "config");
	
	@BeforeSuite
	public void EnvironmentSetup() throws Exception 
	{
		InputStream configFile = new FileInputStream(System.getProperty("user.dir") + 
				"\\src\\main\\java\\com\\Selenium\\Config\\" + ENV +  ".properties");		 
		envConfig = new Properties();
		envConfig.load(configFile);
		System.out.print(configFile.toString());
	
	}

   @BeforeMethod
	 public void Setup( ITestContext XmlTest ) { // Before it was public void Setup(Method m)
		  WebDriverManager.chromedriver().setup();
		  
			 // driver= new ChromeDriver();
			  dr= new ChromeDriver();
			  dr.manage().window().maximize();
			  String s="automation-practice-form";
			  //System.out.print(s);
			  ///dr.get(envConfig.getProperty("baseURL"));
			  dr.get(envConfig.getProperty("URL")+s);
			 
			  //dr.get("https://demoqa.com/automation-practice-form");
			
		
	 }
   

@AfterClass
  public void close() {
	  dr.close();
	  //System.out.println("close");
	  }

}







