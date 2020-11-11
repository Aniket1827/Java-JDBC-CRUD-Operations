package com.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.dataaccess.Vehicle;
import com.database.DbConfig;

public class MainApp {
	static Connection con;
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		con = DbConfig.connectMySQL();
		Vehicle v = null;
		while(true)
		{
			System.out.println("1. Insert");
			System.out.println("2. Show");
			System.out.println("3. Update");
			System.out.println("4. Delete");
			System.out.println("5. Exit");
			
			System.out.println("Enter Choice : ");
			int choice = s.nextInt();
			int user_vehid;
			switch(choice)
			{
				case 1:
					v = new Vehicle();
					createRecord(v);
					if(saveRecord(v))
					{
						System.out.println("Record Inserted Successfully!");
					}
					else
					{
						System.out.println("Record Insertion UnSuccessful!");
					}
					break;
				
				case 2:
					showRecord();
					break;
					
				case 3:
					v = new Vehicle();
					System.out.println("Enter Vehicle Id To Update Record : ");
					user_vehid = s.nextInt();
					
					if(searchRecord(user_vehid)==true)
					{
						createRecord(v);
						if(updateRecord(v,user_vehid))
						{
							System.out.println("Record Updated Successfully!");
						}
						else
						{
							System.out.println("Record Updation UnSuccessful!");
						}
					}
					else
					{
						System.out.println("Vehicle Id Not Found!");
					}
					break;
					
				case 4:
					System.out.println("Enter Id To Delete Record : ");
					int delete_id = s.nextInt();
					
					if(searchRecord(delete_id)==true)
					{
						if(deleteRecord(v,delete_id))
						{
							System.out.println("Record Deleted Successfully!");
						}
						else
						{
							System.out.println("Record Deletion UnSuccessful!");
						}
					}
					else
					{
						System.out.println("Vehicle Id Not Found!");
					}
					break;
					
				case 5:
					System.exit(0);
			}
		}
	}
	static void createRecord(Vehicle v) {
		System.out.println("Enter Vehicle Id : ");
		v.setVehid(s.nextInt());
		
		System.out.println("Enter Vehicle Name : ");
		v.setVehname(s.nextLine());
		
		System.out.println("Enter Vehicle Color : ");
		v.setColor(s.nextLine());
		
		System.out.println("Enter Vehicle Fuel Capacity : ");
		v.setFuelcap(s.nextFloat());
		
		System.out.println("Enter Vehicle Average Speed : ");
		v.setAvgspeed(s.nextFloat());
		}
	
	 static boolean saveRecord(Vehicle v) throws SQLException {
		String query =  "INSERT INTO Vehicle(vehid,vehname,color,fuelcap,avgspeed) VALUE ("+v.getVehid()+",'"+v.getVehname()+"','"+v.getColor()+"',"+v.getFuelcap()+","+v.getAvgspeed()+")";
		Statement stmt = con.createStatement();
		System.out.print(stmt.execute(query));
		return stmt.execute(query);
	}
	 
	 static boolean searchRecord(int user_vehid) throws SQLException
	 {
		 String query = "SELECT vehid FROM  Vehicle WHERE vehid = "+user_vehid;
		 Statement stmt = con.createStatement();
		 /*The SQL statements that read data from a database query, return the data in a result set. The SELECT statement is the standard way to select rows 
		    from a database and view them in a result set. The java.sql.ResultSet interface represents the result set of a database query.
			A ResultSet object maintains a cursor that points to the current row in the result set. The term "result set" refers to the row and column data contained
			 in a ResultSet object.*/
		 ResultSet  r =   stmt.executeQuery(query);
		 if(r.next()==true)
			 return true;
		 else
			 return false;
	 }
	 
	 static boolean updateRecord(Vehicle v,int user_vehid) throws SQLException
	 {
		 String query = "UPDATE Vehicle SET vehname = '"+v.getVehname()+"', color='"+v.getColor()+"', fuelcap="+v.getFuelcap()+", avgspeed="+v.getAvgspeed()+" WHERE vehid="+user_vehid+"";
		 Statement stmt = con.createStatement();
		return   stmt.execute(query);
	 }
	 
	 static boolean deleteRecord(Vehicle v,int delete_id) throws SQLException 
	 {
		 String query = "DELETE FROM Vehicle WHERE vehid = "+delete_id;
		 Statement stmt = con.createStatement();
		 return stmt.execute(query);
	 }
	 
	 
	 static void showRecord() throws SQLException
	 {
		 String query = "SELECT * FROM Vehicle";
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		 /*The SQL statements that read data from a database query, return the data in a result set.A ResultSet object maintains a cursor that points to the current
		 row in the result set. The term "result set" refers to the row and column data contained in a ResultSet object.*/
		while(rs.next())
		{
			System.out.println("**********************************************************");
			 System.out.println("Vehicle Id : " + rs.getString(1));
			 System.out.println("Vehicle Name : " + rs.getString(2));
			 System.out.println("Vehicle Colour : " + rs.getString(3));
			 System.out.println("Vehicle's Fuel Capacity : " + rs.getString(4));
			 System.out.println("Vehicle's Avrage Speed : " + rs.getString(5));

		}
	 }
}

