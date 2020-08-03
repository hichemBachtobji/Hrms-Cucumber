package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PracticeMetaData {

	//@Test
	public void metaData() throws SQLException {
		String UName= "syntax_hrm";
		String pwd= "syntaxhrm123";
		String dbUrl="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
		Connection conn= DriverManager.getConnection(dbUrl, UName, pwd);
		Statement st= conn.createStatement();
		ResultSet rs=st.executeQuery("select * from hs_hr_employees");
		ResultSetMetaData rsMetaData = rs.getMetaData();
		List<String> mdlist= new ArrayList<>();
		while(rs.next()) {
			mdlist.add(rs.getObject("emp_firstname").toString());
		}
		
		for (String list : mdlist) {
			System.out.println(list);
			
		}
	}
	
	@Test
	public void resultMetaData() throws SQLException {
		String UName= "syntax_hrm";
		String pwd= "syntaxhrm123";
		String dbUrl="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
		String Query="select job_title from ohrm_job_title";
		Connection conn= DriverManager.getConnection(dbUrl, UName, pwd);
		System.out.println("********DATABASE METADATA**********");
		DatabaseMetaData metaData = conn.getMetaData();
		String PName = metaData.getDatabaseProductName();
		String PVersion = metaData.getDatabaseProductVersion();
		String DName = metaData.getDriverName();
		String DVersion = metaData.getDriverVersion();
		int Max = metaData.getMaxColumnNameLength();
		System.out.println(PName);
		System.out.println(PVersion);
		System.out.println(DName);
		System.out.println(DVersion);
		System.out.println(Max);
		
		System.out.println("********RESULT SET METADATA**********");
		
		Statement Statement = conn.createStatement();
		ResultSet RSet = Statement.executeQuery(Query);
		ResultSetMetaData rsMEtaData = RSet.getMetaData();
		String maxName = rsMEtaData.getColumnTypeName(1);
		System.out.println("col type name    "+maxName);
		String COlClassName = rsMEtaData.getColumnClassName(1);
		System.out.println("col class name   "+COlClassName);
		String ColName = rsMEtaData.getColumnName(1);
		System.out.println("col name    "+ColName);
		String TName = rsMEtaData.getTableName(1);
		System.out.println("table name " +TName);
		
		System.out.println("********LIST OF JOB TITLES**********");
		
		List<String> dbList= new ArrayList<>();
		while(RSet.next()) {
			dbList.add(RSet.getObject("job_title").toString());
		}
		
		for (String list : dbList) {
			System.out.println(list);
		}
		
	}
}
