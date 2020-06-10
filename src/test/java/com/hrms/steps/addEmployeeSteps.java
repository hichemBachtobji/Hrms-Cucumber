package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class addEmployeeSteps extends CommonMethods{
	
	
	@Given("user logged in into HRMS")
	public void user_logged_in_into_HRMS() {
	   sendText(login.username, ConfigsReader.getProperty("userName"));
	   sendText(login.password, ConfigsReader.getProperty("password"));
	   click(login.loginBtn);
	}

	@Given("user is navigated to Add Employee Page")
	public void user_is_navigated_to_Add_Employee_Page() {
	   dashboard.navigateToAddEmployee();
	}
	
	@When("user enters employees first name and last name")
	public void user_enters_employees_first_name_and_last_name() {
		sendText(addEmp.empName, "John");
		sendText(addEmp.lastName,"Smith");
	}
	
	// this method is enhanced method and parameter values are supplied from FF
	@When("user enters employees {string} and {string}")
	public void user_enters_employees_first_name_and_last_name(String firstname, String lastname) {
		sendText(addEmp.empName, firstname);
		sendText(addEmp.lastName,lastname);
	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
	    click(addEmp.saveBtn);
	}
	
	@Then("employee is added successfully")
	public void employee_is_added_successfully() {
	   String actual= pdetails.textProfilePic.getText();
	   String expected="John Smith";
	   Assert.assertEquals(actual, expected);
	   
	}
	
	// this method has is enhanced method and parameter values are supplied from FF
	@Then("{string} is added successfully")
	public void employee_is_added_successfully(String expectedName) {
	   String actual= pdetails.textProfilePic.getText();
	   //String expected="John Smith";
	   Assert.assertEquals(actual, expectedName);
	   
	}
	

	@When("user deletes employee id")
	public void user_deletes_employee_id() {
	    addEmp.empId.sendKeys(Keys.DELETE);
	}

	@When("user clicks on create login checkbox")
	public void user_clicks_on_create_login_checkbox() {
	   addEmp.createLoginBtn.click();
	}

	@When("user enters {string} and {string}")
	public void user_enters_login_credentials(String userName,String password) {
	   addEmp.createLoginCr(userName, password );
	}
	
	@When("user enters employees {string} {string} and {string}")
	public void user_enters_employees_and(String fname, String mname, String lname) {
	    sendText(addEmp.empName, fname);
	    sendText(addEmp.middlename, mname);
	    sendText(addEmp.lastName, lname);
	}

	
	@Then("{string} {string} and {string} added successfully")
	public void and_added_successfully(String fname, String mname, String lname) {
	   String actual= pdetails.textProfilePic.getText();
	   String expected= fname+" "+mname+" "+lname;
	   Assert.assertEquals(actual, expected);
	}
	
	@When("user enters different credentials")
	public void user_enters_different_credentials(DataTable dataTable) {
	  List<Map<String, String>> listOfMaps = dataTable.asMaps();
	  for(Map<String, String> map:listOfMaps) {
		  
		  String uname=map.get("username");
		  String pwd=map.get("password");
		  
		  sendText(addEmp.username, uname);
		  sendText(addEmp.userPwd, pwd);
		  sendText(addEmp.rePwd, pwd);
		  
		  click(addEmp.saveBtn);
		  
	  }
	}
}
	
	
