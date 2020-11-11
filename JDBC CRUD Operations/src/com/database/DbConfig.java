package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
	public static Connection  connectMySQL() throws  SQLException, ClassNotFoundException
	{
		/*The Class class is located in the java.lang package, so it is distributed with java, and imported automatically into every class.
			What the forName() method does, is just return the Class object for the paramater that was loaded by the class loader. 
			So then what happens is you call Class.forName(...) it returns com.mysql.jdbc.Driver.class*/
		Class.forName("com.mysql.jdbc.Driver");
		
		/*The getConnection(String url, Properties info) method of Java DriverManager class attempts to establish a connection to the database by using the given 
		    database url. The appropriate driver from the set of registered JDBC drivers is selected. Properties are implementation-defined as to which value will take 
		     precedence. For maximum portability, an application should only specify a property once.*/
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		if(con==null)
			System.out.println("\n Database Connection Failed");
		else
			System.out.println("\n Succeed.");
		return con;
	}
}
