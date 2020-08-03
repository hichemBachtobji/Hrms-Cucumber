package com.hrms.steps;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.GlobalVariables;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSearchSteps extends CommonMethods{
	
	

	@Given("user is logged in with valid admin credentials")
	public void user_is_logged_in_with_valid_admin_credentials() {
	    sendText(login.username, ConfigsReader.getProperty("userName"));
	    sendText(login.password, ConfigsReader.getProperty("password"));
	    click(login.loginBtn);
	}

	@Given("user navigate to empoyee list page")
	public void user_navigate_to_empoyee_list_page() {
		wait(5);
		//dashboard.empListPage.click();
	    jsClick(dashboard.PIM);
	    jsClick(dashboard.empListPage);
	}

	@When("user enters valid employee id {string}")
	public void user_enters_valid_employee_id(String empID) {
	   sendText(viewEmp.empID, empID);
	   GlobalVariables.empID= empID;
	}

	@When("click on search button")
	public void click_on_search_button() {
	   jsClick(viewEmp.searchBtn);
	}

	@Then("user see employee information is displayed")
	public void user_see_employee_information_is_displayed() {
//	  boolean IdIsDisplayed= viewEmp.table.isDisplayed();
		
	  
	}

	@When("user enters valid employee {string}")
	public void user_enters_valid_employee_name_and_last_name(String name) {
		 sendText(viewEmp.empName, name);
		 
	}
	
	@Then("verify table is displayed")
	public void verify_table_is_displayed() {
	    Assert.assertEquals(true, viewEmp.isTableDisplayed());
	}

	@Then("get first name from table")
	public void get_first_name_from_table() {
	    System.out.println(viewEmp.getFirstnameFromTable());
	}

	@Then("validate first name from ui against db")
	public void validate_first_name_from_ui_against_db() {
	    Assert.assertEquals(DBSteps.dbData, viewEmp.getFirstnameFromTable());
	}
	
	@When("verify tavle is displayed")
	public void verify_tavle_is_displayed() {
	    Assert.assertEquals(true, viewEmp.isTableDisplayed());
	}

	@Then("get last name from table")
	public void get_last_name_from_table() {
	    System.out.println(viewEmp.getLastnameFromTable());
	}
	
	@Then("validate last name in UI against DB")
	public void validate_last_name_in_UI_against_DB() {
	    Assert.assertEquals(viewEmp.getLastnameFromTable(), DBSteps.dbData1);
	}

}
