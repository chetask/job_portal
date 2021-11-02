package com.DB;

import java.sql.DriverManager;



public class DBConnect {
 private static java.sql.Connection conn;
 public static java.sql.Connection getConn() {
 try {
	 if(conn==null)
	 {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/job_portal","root","admin");
	 }
 }
 catch(Exception e)
 {
	 e.printStackTrace();
 }
 return conn;
 }
}
