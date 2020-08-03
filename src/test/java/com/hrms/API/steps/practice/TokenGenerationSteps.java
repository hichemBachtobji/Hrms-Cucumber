 package com.hrms.API.steps.practice;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;


public class TokenGenerationSteps {
	
	String BaseURI= RestAssured.baseURI="http://18.232.148.34/syntaxapi/api";
	public static String token;
	
	@Given("a JWT is generated")
	public void a_JWT_is_generated() {
		RequestSpecification generateTokenRequest = given().header("Content-Type", "application/json").body("{\r\n" + 
				"  \"email\": \"hichem@bachtobji.com\",\r\n" + 
				"  \"password\": \"hichem123\"\r\n" + 
				"}");
		
		Response generateTokenResponse = generateTokenRequest.when().post("/generateToken.php");
		
		//generateTokenResponse.prettyPrint();
		
		/*
		 * retrieving token from generate response body and concatenating "Bearer "
		 */
		token="Bearer "+generateTokenResponse.body().jsonPath().getString("token");
		System.out.println(token);
		
	}

}
