package com.Pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class Form {
	WebDriver driver;
	
	@FindBy(how=How.XPATH, using="//span[text()='Practice Form']")
	 private WebElement form_tab;
	
	@FindBy(how=How.XPATH, using="//input[contains(@placeholder,'First Name')]")
	WebElement First_Name;
	
	@FindBy(how=How.XPATH, using="//input[contains(@placeholder,'Last Name')]")
	WebElement Last_Name;
	
	@FindBy(how=How.XPATH, using="//label[@for=\"gender-radio-2\"]")
	WebElement female;
	
	@FindBy(how=How.XPATH, using="//label[@for=\"gender-radio-1\"]")////label[contains(@for,'gender-radio-1')]
	WebElement male;
	
	@FindBy(how=How.XPATH, using="//label[@for=\"gender-radio-3\"]")
	WebElement other;
	
	@FindBy(xpath="//input[contains(@minlength,'10')]")
	WebElement ph_no;
	
    @FindBy(xpath="//*[@id=\"subjectsContainer\"]/div[1]/div[1]")
    WebElement searchSubjectTxtField;
	
	
	@FindAll({
	    @FindBy(xpath="//div[contains(@tabindex,'-1')]\"")         
	})
	List<WebElement> submitButtons;
	
	   //constructor to initialize driver 
		public Form(WebDriver dr) {
			this.driver=dr;
			PageFactory.initElements(dr, this);//When you use PageFactory.initElements(driver, this),
			                                      //it implicitly creates the necessary findElement calls behind the scenes.
		}
	
		public void selectAndClickSubject(String s) {
		searchSubjectTxtField.sendKeys(s);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));/////explicit wait
			
		
		for(int i=0;i<this.submitButtons.size();i++) {
			wait.until(ExpectedConditions.visibilityOfElementLocated((By) submitButtons.get(i)));
			if(this.submitButtons.get(i).getText()=="Hindi") {
				System.out.println("Success");
				submitButtons.get(i).click();
			}
		}
		//return ;
		///return this.subjectelem;
		
	}
	
	
	
	public void scrollInto() throws Throwable{
		//WebElement element = driver.findElement(By.id("id_of_element"));
	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", First_Name);// scrollIntoView is js method 
		Thread.sleep(500); 

	}
	public void clickFormTab() {
		form_tab.click();
	}
	
	public void gender(String gender) {
		if(gender=="Female") {
			female.click();
			System.out.println("female");
			
	}
//		else if(gender=="Male")
//		{
//			male.click();
		//}
		//female.click();
		
		
	}
	
//	
	
	public void fillform(String FN,String LN,String gender, String no) 
	{
		First_Name.sendKeys(FN);
		Last_Name.sendKeys(LN);
		//gender.click();
		this.gender(gender);
		ph_no.sendKeys(no);
		
	}

	
	


}
