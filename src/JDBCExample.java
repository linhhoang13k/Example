package com.iub.coding.practice.CodeName47;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class JDBCExample {

	public static void main(String[] argv) {

		System.out.println("-------- MySQL JDBC Connection Testing ------------");
		StringBuffer javaOutput = new StringBuffer();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airavata_catalog", "root", "root");

			Statement statement = connection.createStatement();

			// Query
			ResultSet rs = statement.executeQuery("SELECT * FROM workspace_user_profile ");
			ResultSetMetaData rmd = rs.getMetaData();

			// Get number of columns returned
			int numOfCols = rmd.getColumnCount();

			// Print out type for each column
			for (int i = 1; i <= numOfCols; ++i) {
				System.out.println("Column [" + rmd.getColumnName(i) + "] data type: " + rmd.getColumnTypeName(i));
			}

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
}

class DataTypeMapping	{
	
	  private static final Map<String, String> myMap = new HashMap<String, String>();
	    static {
	        myMap.put("VARCHAR", "String");
	        myMap.put("BIGINT", "long");
	        myMap.put("BLOB", "bye[]");	        
	        myMap.put("LONGTEXT", "String");
	        myMap.put("SMALLINT", "int");
	        myMap.put("MEDIUMINT", "int");
	        myMap.put("CHAR", "String");
	        myMap.put("INT", "int");
	        myMap.put("INTEGER", "int");
	        myMap.put("FLOAT", "float");
	        myMap.put("DOUBLE", "double");
	        myMap.put("DECIMAL", "BigDecimal");
	        myMap.put("DATE", "Date");
	        myMap.put("DATETIME", "Timestamp");
	        myMap.put("TIME", "Time");
	        myMap.put("BINARY", "bye[]");
	        myMap.put("VARBINARY", "byte[]");
	        myMap.put("TINYBLOB", "byte[]");
	        myMap.put("MEDIUMBLOB", "byte[]");
	        myMap.put("LONGBLOB", "byte[]");
	        myMap.put("TEXT", "String");
	        myMap.put("BOOLEAN", "boolean");
	        myMap.put("BOOLEAN", "boolean");


	        
	    }
 

	
}

class JavaDataTypePackageMapping	{
	
	private String className;
	private String packageName;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	
}