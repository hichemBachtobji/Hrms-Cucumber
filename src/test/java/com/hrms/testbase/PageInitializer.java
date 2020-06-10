package com.hrms.testbase;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.pages.addEmployee;
import com.hrms.pages.viewEmployeePageElements;

public class PageInitializer extends BaseClass {
	
	public static LoginPageElements login;
	public static DashboardPageElements dashboard;
	public static addEmployee addEmp;
	public static PersonalDetailsPageElements pdetails;
	public static viewEmployeePageElements viewEmp;
	
	public static void initialize() {
		
		login= new LoginPageElements();
		dashboard= new DashboardPageElements();
		addEmp= new addEmployee();
		pdetails = new PersonalDetailsPageElements();
		viewEmp= new viewEmployeePageElements();
		
	}

}
