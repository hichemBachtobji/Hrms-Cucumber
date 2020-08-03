package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Task {
	
	@Test
	public void nationalityInfo() throws SQLException {
		String UName= "syntax_hrm";
		String pwd= "syntaxhrm123";
		String dbUrl="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
		String query= "select id , name from ohrm_nationality";
		Connection conn= DriverManager.getConnection(dbUrl, UName, pwd);
		Statement st= conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		ResultSetMetaData rsMetaData = rs.getMetaData();
		List<Map<String,String>> listData= new ArrayList<>();
		Map<String,String> mapdata;
		while(rs.next()) {
			mapdata =new LinkedHashMap<>();
			for (int i=1; i <=rsMetaData.getColumnCount();i++ ) {
				mapdata.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());
			}
			listData.add(mapdata);
		}
		System.out.println(listData);
		
	}

}
