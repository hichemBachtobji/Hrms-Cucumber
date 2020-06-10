package com.hrms.steps;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class validLogin extends CommonMethods {
	
	@Given("user should navigate to URL")
	public void user_should_navigate_to_URL() {
	   setUp();
	}

	@When("user enters valid username")
	public void user_enters_valid_username() {
	   login.sendText(login.username, ConfigsReader.getProperty("userName"));
	}

	@When("user enters valid password")
	public void user_enters_valid_password() {
	    login.sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("user should click on login button")
	public void user_should_click_on_login_button() {
	    click(login.loginBtn);
	}

	@Then("user sees welcome admin")
	public void user_sees_welcome_admin() {
	   boolean welcomeAdmin = dashboard.welcome.isDisplayed();
	   String Actual = dashboard.welcome.getText();
	   String Expected="Welcome Admin";
	   Assert.assertEquals( "invalid login credentials",Expected, Actual);
	   //Assert.assertTrue("invalid login",welcomeAdmin);
	   tearDown();
	}

	@When("user enters valid ESS username")
	public void user_enters_valid_ESS_username() {
	    sendText(login.username,ConfigsReader.getProperty("essusername"));
	}

	@When("user enters valid ESS password")
	public void user_enters_valid_ESS_password() {
	    sendText(login.password, ConfigsReader.getProperty("esspassword"));
	}

	@Then("user sees welcome ESS")
	public void user_sees_welcome_ESS() {
	   String actual=dashboard.welcome.getText();
	   String expected="Welcome Kamala";
	   Assert.assertEquals(expected, actual);
	   tearDown();
	}
}
