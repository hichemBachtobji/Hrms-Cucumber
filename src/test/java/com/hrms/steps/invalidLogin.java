package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.When;

public class invalidLogin extends CommonMethods {

	@When("I enter invalid {string} and {string} and see {string}")
	public void i_enter_invalid_and_and_see(String uName, String password, String errMsg, DataTable dataTable) {
	   List<Map<String,String>> listOfMaps=dataTable.asMaps();
	   
	   for(Map<String, String> map:listOfMaps) {
		   
		  String username= map.get("UserName");
		   String pwd=map.get("Password");
		   String errorMsg=map.get("ErrorMessage");
		   
		   sendText(login.username, username);
		   sendText(login.password, pwd);
		   click(login.loginBtn);
		   System.out.println(errorMsg);
		   
		   String expectedMsg= errorMsg;
		   String actualMsg=login.errorMsg.getText();
		   
		  Assert.assertEquals("error message is not found",actualMsg, expectedMsg);
		  
		  TakesScreenshot("invalid credentials");
	   
	   }
	}
//	@When("I enter invalid {string} and {string} and see {string}")
//	public void i_enter_invalid_and_and_see(String uName, String password, String errMsg) {
//		sendText(login.username, uName);
//		sendText(login.password, password);
//		click(login.loginBtn);
//
//		String expectedMsg = errMsg;
//		String actualMsg = login.errorMsg.getText();
//
//		Assert.assertEquals("error message is not found", actualMsg, expectedMsg);
//
//		TakesScreenshot("invalid credentials");
//
//	}
}
