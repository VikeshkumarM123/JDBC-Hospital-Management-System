package com.kce.util;
import java.sql.*;
public class HospitalManagementConnection{
public static Connection DBconnect()
{
	   Connection con=null;
       try {
       Class c=Class.forName("oracle.jdbc.driver.OracleDriver");
       String url="jdbc:oracle:thin:@localhost:1521:XE";
       String username="Hospital";
       String password="123";
       con=DriverManager.getConnection(url,username,password);
       }catch(Exception e)
	   {
		System.out.println(e);
	   }
       return con;
}
}