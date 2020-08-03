package com.hrms.API.steps.practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.testng.Assert;
//import org.apache.hc.core5.http.ContentType;

/**
 * This @FixMethodOrder(MethodSorters.NAME_ASCENDING) will execute @Test
 * annotation in ascending alphabetical order
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardcodedExamples {

	/**
	 * Rest Assured
	 * 
	 * given - prepare your request when - you are making the call to the endpoint
	 * then - validating
	 * 
	 * @param args
	 */

	static String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

	static String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUxNjg3NTcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTIxMTk1NywidXNlcklkIjoiODkyIn0.cb6KuQUSk6kt8uX_SvYH8glFhnqyihkor02ULqTxy6Y";

	static String employeeID;

	public void SampleTestNotes() {

		RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

		// JWT required for all calls - expires every 12 hours
		String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUxNjg3NTcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTIxMTk1NywidXNlcklkIjoiODkyIn0.cb6KuQUSk6kt8uX_SvYH8glFhnqyihkor02ULqTxy6Y";

		// preparing /getOneEmployee.php request
		RequestSpecification getOneEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", "15885A").log().all();

		// storing response
		Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");

		// 2 ways to print response
		getOneEmployeeResponse.prettyPrint();
		// String response= getOneEmployeeResponse.body().asString();
		// System.out.println(response);

		// verifying response status code is 200
		getOneEmployeeResponse.then().assertThat().statusCode(200);

	}

	@Test
	public void aPostCreateEmployee() {

		RequestSpecification createEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token)
				.body(" {\r\n" + "            \"employee_id\": \"15885A\",\r\n"
						+ "            \"emp_firstname\": \"Al\",\r\n"
						+ "            \"emp_middle_name\": \"scarface\",\r\n"
						+ "            \"emp_lastname\": \"Pacino\",\r\n"
						+ "            \"emp_birthday\": \"1940-04-25\",\r\n" + "            \"emp_gender\": \"M\",\r\n"
						+ "            \"emp_job_title\": \"Instructor\",\r\n"
						+ "            \"emp_status\": \"Internee\"\r\n" + "        }");

		Response createEmployeeResponse = createEmployeeRequest.when().log().all().post("/createEmployee.php");

		createEmployeeResponse.prettyPrint();

		/*
		 * jsonPath() to view response body which let's us get the employee ID we store
		 * employee ID as a global variable so that we may use it with our other calls
		 */

		employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
		System.out.println(employeeID);

		createEmployeeResponse.then().assertThat().statusCode(201);

		/*
		 * verifying message using equalTo() method - manually import static package
		 * import static org.hamcrest.Matchers.*;
		 */

		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));

		// verifying created first name
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Al"));

		// verifying server using then().header()
		createEmployeeResponse.then().header("server", "Apache/2.4.39 (Win64) PHP/7.2.18");

		// verifying Content Type using assertThat().header()
		createEmployeeResponse.then().assertThat().header("Content-Type", "application/json");
	}

	@Test
	public void bGETcreatedEmployee() {
		/*
		 * preparing request for get created employee /getOneEmployee.php
		 */
		RequestSpecification getCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID).log().all();

		/*
		 * making call to retrieve created employee
		 */
		Response getCreatedEmployeeResponse = getCreatedEmployeeRequest.when().get("/getOneEmployee.php");

		String response = getCreatedEmployeeResponse.prettyPrint();

		String empID = getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");

		boolean verifyingEmpIDsMatch = empID.equalsIgnoreCase(employeeID);

		Assert.assertTrue(verifyingEmpIDsMatch);

		getCreatedEmployeeResponse.then().assertThat().statusCode(200);

		/*
		 * using jsonPath to retrieve values from response as a string
		 */
		JsonPath js = new JsonPath(response);

		String emplID = js.getString("employee[0].employee_id");
		String firstName = js.getString("employee[0].emp_firstname");
		String middleName = js.getString("employee[0].emp_middle_name");
		String lastName = js.getString("employee[0].emp_lastname");
		String birthday = js.getString("employee[0].emp_birthday");
		String gender = js.getString("employee[0].emp_gender");
		String jobTitle = js.getString("employee[0].emp_job_title");
		String empStatus = js.getString("employee[0].emp_status");

		System.out.println(emplID);
		System.out.println(firstName);
		System.out.println(middleName);
		System.out.println(lastName);
		System.out.println(birthday);
		System.out.println(gender);
		System.out.println(jobTitle);
		System.out.println(empStatus);

		// verifying employee id's matched
		Assert.assertTrue(emplID.contentEquals(employeeID));
		// 2nd way of asserting
		Assert.assertEquals(emplID, employeeID);
		// verifying expected first name matches actual first name
		Assert.assertTrue(firstName.contentEquals("Al"));
		// verifying expected last name matches actual last name
		Assert.assertTrue(lastName.contentEquals("Pacino"));

	}

	@Test
	public void cGETallEmployees() {

		/**
		 * preparing /getAllEmployees.php request
		 */
		RequestSpecification getAllEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token);

		Response getAllEmployeeResponse = getAllEmployeeRequest.when().get("/getAllEmployees.php");

		// getAllEmployeeResponse.prettyPrint();

		String allEmployees = getAllEmployeeResponse.body().asString();

		// this will pass but incorrect
		// allEmployees.contains(employeeID);

		// -----do research-------
		// allEmployees.matches(employeeID);

		JsonPath js = new JsonPath(allEmployees);

		/**
		 * retrieving size of employees list
		 */
		int sizeOfList = js.getInt("Employees.size()");
		System.out.println(sizeOfList);

		/**
		 * printing all employee IDs
		 */

//		for(int i=0;i<sizeOfList;i++) {
//			/**
//			 * printing out all employee IDs
//			 */
//			String allEmployeeIDs=js.getString("Employees["+i+"].employee_id");
//			//System.out.println(allEmployeeIDs);
//			/**
//			 * if statement inside for loop to find stored employee ID and break the loop 
//			 */
//			
//			if(allEmployeeIDs.contentEquals(employeeID)) {
//				System.out.println("Employee Id:  "+ employeeID+"  is present in body");
//				String employeeFirstname = js.getString("Employees ["+i+"].emp_firstname");
//				System.out.println(employeeFirstname);
//				break;
//			}
//			
//		}

	}

	public void dPUTupdateCreatedEmployee() {
		RequestSpecification updateCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).body("{\r\n" + 
						"  \"employee_id\": \""+employeeID+"\",\r\n" + 
						"  \"emp_firstname\": \"Alfonse\",\r\n" + 
						"  \"emp_lastname\": \"PACINO\",\r\n" + 
						"  \"emp_middle_name\": \"SCARFACE\",\r\n" + 
						"  \"emp_gender\": \"M\",\r\n" + 
						"  \"emp_birthday\": \"1940-07-11\",\r\n" + 
						"  \"emp_status\": \"{{WORKER}}\",\r\n" + 
						"  \"emp_job_title\": \"Developer\"\r\n" + 
						"}");
		
		Response updateCreatedEmployeeResponse = updateCreatedEmployeeRequest.when().put("/updateEmployee.php");
		
		String response = updateCreatedEmployeeResponse.prettyPrint();
		
		

	}
}
