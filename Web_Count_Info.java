package com.datamining.webcount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.datamining.connection.oracle.Connection_Database;

public class Web_Count_Info {
	
	private PreparedStatement prst=null;
	
	private List WEB_PAGE_NAME=null;
	
	public List getWEB_PAGE_NAME() {
		return WEB_PAGE_NAME;
	}


	public void setWEB_PAGE_NAME(List wEB_PAGE_NAME) {
		WEB_PAGE_NAME = wEB_PAGE_NAME;
	}


	public List getWEB_PAGE_COUNT() {
		return WEB_PAGE_COUNT;
	}


	public void setWEB_PAGE_COUNT(List wEB_PAGE_COUNT) {
		WEB_PAGE_COUNT = wEB_PAGE_COUNT;
	}


	private List WEB_PAGE_COUNT=null;
	
	private static final String webcount_st_database="select * from web_count" ;
	
	private ResultSet rs=null;
	
	
	public void getWebCountInfo()
	{
		
		try
		{
		
			System.out.println("hi iam in class Web_Count_Info");
			
			
			WEB_PAGE_NAME=new ArrayList();
			
			WEB_PAGE_COUNT=new ArrayList();
			
			Web_Count_Info wci=new Web_Count_Info();
		
		
		/*checking the connection */
			
		 Connection_Database cd=new  Connection_Database();
		 
		 /*creating a connection object */
		 
		Connection con= cd.createOracleConnection();
		
		
		System.out.println("hi i got the connection"+con);
					
		prst=con.prepareStatement(webcount_st_database);
		
		
		
		rs=prst.executeQuery();
		
		System.out.println("hi iam now getting information from web_count table ");
		
		while(rs.next())
		{
			
			WEB_PAGE_NAME.add(rs.getString("WEB_PAGE_NAME"));
			WEB_PAGE_COUNT.add(rs.getInt("WEB_PAGE_COUNT"));
			
					
			
		}
		
		wci.setWEB_PAGE_COUNT(WEB_PAGE_COUNT);
		
		wci.setWEB_PAGE_NAME(WEB_PAGE_NAME);
		
		
		System.out.println("hi i got the web_count information");
	
		
		
		
		
		
		/*lets remove the connection */
		
		String flag=cd.removeOracleConnection(con);
		
		System.out.println("hi i closed the connection");
		
		System.out.println("Hi iam exiting of Web_Count_Info");
		
		
		
		}
		catch(Exception ex)
		{
			System.out.println("There is an exception to get the Web_Count information:"+ex);
			ex.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
