package com.hrms.API.utils;

import org.json.JSONObject;

public class PayloadConstants {
	public static String createEmployeeBody() {

		String createEmployeebody = "{\r\n" + "            \"employee_id\": \"20439A\",\r\n"
				+ "            \"emp_firstname\": \"Ronaldo\",\r\n"
				+ "            \"emp_middle_name\": \"phenomeno\",\r\n"
				+ "            \"emp_lastname\": \"Dalima\",\r\n" + "            \"emp_birthday\": \"1975-07-11\",\r\n"
				+ "            \"emp_gender\": \"Male\",\r\n" + "            \"emp_job_title\": \"Controller\",\r\n"
				+ "            \"emp_status\": \"Super Contractor\"\r\n" + "        }";
		return createEmployeebody;
	}

	public static String createEmployeePayload() {
		JSONObject obj = new JSONObject();
		obj.put("emp_firstname", "Ronaldo");
		obj.put("emp_middle_name", "phenomeno");
		obj.put("emp_lastname", "Dalima");
		obj.put("emp_birthday", "1975-07-11");
		obj.put("emp_gender", "M");
		obj.put("emp_job_title", "Controller");
		obj.put("emp_status", "Super Contractor");
		
		return obj.toString();
		
	}

	public void updateCreatedEmpBody() {

		String updateBody = "\"{\\r\\n\" + \r\n"
				+ "						\"  \\\"employee_id\\\": \\\"\"+employeeID+\"\\\",\\r\\n\" + \r\n"
				+ "						\"  \\\"emp_firstname\\\": \\\"Alfonse\\\",\\r\\n\" + \r\n"
				+ "						\"  \\\"emp_lastname\\\": \\\"PACINO\\\",\\r\\n\" + \r\n"
				+ "						\"  \\\"emp_middle_name\\\": \\\"SCARFACE\\\",\\r\\n\" + \r\n"
				+ "						\"  \\\"emp_gender\\\": \\\"M\\\",\\r\\n\" + \r\n"
				+ "						\"  \\\"emp_birthday\\\": \\\"1940-07-11\\\",\\r\\n\" + \r\n"
				+ "						\"  \\\"emp_status\\\": \\\"{{WORKER}}\\\",\\r\\n\" + \r\n"
				+ "						\"  \\\"emp_job_title\\\": \\\"Developer\\\"\\r\\n\" + \r\n"
				+ "						\"}\"";
	}
}
