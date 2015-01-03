package com.datamining.connection.oracle;

import java.sql.Connection;
import java.sql.DriverManager;

import com.datamining.constants.DataminingIF;

public class Connection_Database {
	
	//public static final String Driver_name_oracle="oracle.jdbc.OracleDriver";
	
	/**
	 *  This is Driver Name 
	 */
	public static final String Driver_name_oracle="com.mysql.jdbc.Driver";
	
	
	public static Connection con=null;
	public Connection createOracleConnection()
	{
		try
		{
			System.out.println("this is start of Connection");
			//Class.forName(Driver_name_oracle);
			
			Class.forName(DataminingIF.DATABASE_DRIVER);

			System.out.println("Registering the driver is sucessful");
		
			//con=DriverManager.getConnection("jdbc:oracle:thin:system/allah@//localhost:1521/XE");
			//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/datamining","root","master");
			
			con=DriverManager.getConnection(DataminingIF.DATABASE_URL,DataminingIF.USERNAME,DataminingIF.PASSWORD);
			
			System.out.println("getting the connection object is sucessful");	
			
		}
		catch(Exception e)
		{
			System.out.println("This is an exception: iam in class connection_database"+e);
			
			e.printStackTrace();
		
		}
		return con;

	}
	
	public String removeOracleConnection(Connection con)
	{
		
		String str="sucess intial";
		
		try
		{
		
		
		
		if(con!=null)
		{
			con.close();
			str= "SUCESS";
		}
		}
		catch(Exception e)
		{
			System.out.print("cannot close the connection");
			
			str = "failure";
		}
		
		return str;
			
	}
	
	
	public static void main(String s[])
	{
		Connection_Database cd=new Connection_Database();
		
		con=cd.createOracleConnection();
		
		System.out.println("the connection is "+con);
		
		/*removing the connection*/
		
		
		String value=cd.removeOracleConnection(con);
		
		System.out.println(value);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
