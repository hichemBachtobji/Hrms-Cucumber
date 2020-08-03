package com.hrms.steps;

import java.util.List;
import java.util.Map;

import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class personalDetailsSteps extends CommonMethods {
	
	@Given("user select employee by {string}")
	public void user_select_employee_by_id(String empId) {
	   sendText(viewEmp.empID, empId);
	   click(viewEmp.searchBtn);
	   click(viewEmp.table);
	}

	@When("user should be able to modify employee personal details")
	public void user_should_be_able_to_modify_employee_personal_details(DataTable personalDetails) {
		pdetails.editBtn.click();
		
	 List<Map<String, String>> pDeatils = personalDetails.asMaps();
	 for (Map<String, String> map : pDeatils) {
		sendText(pdetails.DLNum, map.get("DLNNumber"));
		sendText(pdetails.LicenseExpiryDate, map.get("LicenseExpiryDate"));
	    sendText(pdetails.SSN, map.get("SSN"));
	    sendText(pdetails.SINNum, map.get("SIN"));
	    clickRadioOrCheckbox(pdetails.genderRadioGroup, map.get("Gender"));
	    selectDdValue(pdetails.MaritalStatus, map.get("MaritalStatus"));
	    selectDdValue(pdetails.nationalityDD, map.get("Nationality"));
	    sendText(pdetails.DOB, map.get("DateofBirth"));
	    sendText(pdetails.NickName, map.get("NickName"));
	    
	    sendText(pdetails.MilitaryService, map.get("MilitaryS"));
	    click(pdetails.saveBtn);
	    
	    
	    
	}
	}

	@Then("user saves the modifications and takes {string}")
	public void user_saves_the_modifications_and_takes(String screenshot) {
	   TakesScreenshot(screenshot);
	}


}
