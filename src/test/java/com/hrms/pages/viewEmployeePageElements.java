package com.hrms.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	
	@FindBy(xpath="//table[@id='resultTable']")
	public WebElement employeesTable;
	
	public boolean isTableDisplayed(){
		return employeesTable.isDisplayed();
	}
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[3]")
	public List<WebElement> tableFirstName;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[4]")
	public List<WebElement> tableLastName;
	
	public List<Map<String, String>> getFirstnameFromTable(){
		List<Map<String, String>> uiName= new ArrayList<>();
		for (WebElement row : tableFirstName) {
			Map<String, String> storeUiNames= new LinkedHashMap<>();
			String tableName=row.getText();
			
			storeUiNames.put("emp_firstname", tableName);
			uiName.add(storeUiNames);
		}
		return uiName;
	}
	
	public List<Map<String, String>> getLastnameFromTable(){
		List<Map<String, String>> lastnameList= new ArrayList<>();
		for(WebElement row: tableLastName) {
			Map<String, String> lastnameMap= new LinkedHashMap<>();
			String rowText= row.getText();
			lastnameMap.put("emp_lastname", rowText);
			lastnameList.add(lastnameMap);
		}
		return lastnameList;
	}
	
	
	public viewEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}


}
