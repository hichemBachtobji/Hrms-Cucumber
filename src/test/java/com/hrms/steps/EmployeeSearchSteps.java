package com.hrms.steps;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSearchSteps extends CommonMethods{
	
	@Given("user is navigated to HRMS")
	public void user_is_navigated_to_HRMS() {
	    setUp();
	}

	@Given("user is logged in with valid admin credentials")
	public void user_is_logged_in_with_valid_admin_credentials() {
	    sendText(login.username, ConfigsReader.getProperty("userName"));
	    sendText(login.password, ConfigsReader.getProperty("password"));
	    click(login.loginBtn);
	}

	@Given("user navigate to empoyee list page")
	public void user_navigate_to_empoyee_list_page() {
	    jsClick(dashboard.PIM);
	    jsClick(dashboard.empListPage);
	}

	@When("user enters valid employee id")
	public void user_enters_valid_employee_id() {
	   sendText(viewEmp.empID, "10079");
	}

	@When("click on search button")
	public void click_on_search_button() {
	   click(viewEmp.searchBtn);
	}

	@Then("user see employee information is displayed")
	public void user_see_employee_information_is_displayed() {
//	  boolean IdIsDisplayed= viewEmp.table.isDisplayed();
		
	  tearDown();
	}

	@When("user enters valid employee name and last name")
	public void user_enters_valid_employee_name_and_last_name() {
	   
	}


}
