package com.hrms.utils;

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

public class DBUtils {
	
	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;
	private static List<Map<String,String>> listdata;
	private static List<Map<String, String>> metaDataList;
	
	/**
	 * this method will establish a connection with db
	 */
	
	public static void getConnection() {
		try {
			conn= DriverManager.getConnection(ConfigsReader.getProperty("dbUrl"),
					ConfigsReader.getProperty("dbUsername"),
					ConfigsReader.getProperty("dbPassword"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * this method will execute the query and store the data inside the list of maps
	 * by the given sql query
	 * @param sqlQuery
	 * @return List<Map<String, String>>
	 */
	
	public static List<Map<String,String>> storeDataFromDB(String sqlQuery){
		try {
			getConnection();
			st=conn.createStatement();
			rs=st.executeQuery(sqlQuery);
			ResultSetMetaData rsMetadata = rs.getMetaData();
			listdata= new ArrayList<>();
			Map<String, String> mapdata; 
			
			while(rs.next()) {
				mapdata= new LinkedHashMap<>();
				for(int i=1;i<=rsMetadata.getColumnCount();i++) {
					mapdata.put(rsMetadata.getColumnName(i), rs.getObject(i).toString());
				}
				listdata.add(mapdata);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listdata;	
	}
	/**
	 * this method will close the connection with db
	 */
	public static void closeConnection() {
		try {
			if(rs !=null) {
				rs.close();
			}
			if(st !=null) {
				st.close();
			}
			if(conn !=null) {
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static List<Map<String, String>> getLastnameFromDB(String sqlquery){
	
		try {
			getConnection();
			st=conn.createStatement();
			rs=st.executeQuery(sqlquery);
			ResultSetMetaData metaData = rs.getMetaData();
			metaDataList= new ArrayList<>();
			Map<String, String> metaDataMap;
			while(rs.next()) {
				metaDataMap= new LinkedHashMap<>();
				for(int i=1; i<=metaData.getColumnCount();i++) {
					metaDataMap.put(metaData.getColumnName(i), rs.getObject(i).toString());
				}
				metaDataList.add(metaDataMap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return metaDataList;
		
		
	}

}
