package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class viewEmployeePageElements {
	
	@FindBy (xpath="//input[@id='empsearch_id']")
	public WebElement empID;
	
	@FindBy (xpath="//input[@id='searchBtn']")
	public WebElement searchBtn;
	
	@FindBy (id="empsearch_employee_name_empName")
	public WebElement empName;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td/a")
	public WebElement table; 
	
	public viewEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}


}
