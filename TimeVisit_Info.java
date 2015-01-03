package com.datamining.timeinformation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.datamining.connection.oracle.Connection_Database;

public class TimeVisit_Info 
{


	
	public String web_page_name_st="select WEB_PAGE_NAME from time_website";
	
	public List time=null;
	public List web_page_name=null;
	
	private PreparedStatement prst=null;
	
	
	
	private ResultSet rs2=null;
	
	public List getWeb_page_name() {
		return web_page_name;
	}

	public void setWeb_page_name(List webPageName) {
		web_page_name = webPageName;
	}

	public List getTime() {
		return time;
	}

	public void setTime(List time) {
		this.time = time;
	}


	
	public void getTimeInfo()
	{
	
	try
	{
		System.out.println("hi iam in class Time Visit Info");
	
		web_page_name=new ArrayList();
		
		time=new ArrayList();
		
		TimeVisit_Info time_visit_info=new TimeVisit_Info();
		
	
		/*checking the connection */
		
		Connection_Database cd=new  Connection_Database();
	 
		/*creating a connection object */
	 
		Connection con= cd.createOracleConnection();
 	
	
		System.out.println("hi i got the connection"+con);
				
		Statement st1=con.createStatement();
	
	
	
		
		
		System.out.println("ghassssssssssssssssssssssssssssssssssssssssssssssss"+rs2);
		
		
	
		System.out.println("hi iam now getting information from time_website table ");
	
	
	
	System.out.println("hi i got the time information");
	
	rs2=st1.executeQuery(web_page_name_st);
	
	

	System.out.println("hi i got the page informat"+rs2);
	
	while(rs2.next())
	{
		
		web_page_name.add(rs2.getString("WEB_PAGE_NAME"));
		
		System.out.println("webpage name "+web_page_name);
		
		
	}
	
	
	
	
	
		
	time_visit_info.setWeb_page_name(web_page_name);
	
	System.out.println("Here Iam Storing the Web Page Name ");
	
	/*calling helper */
	
	time1 t1=new time1();
	
	time=t1.getTimeSeconds();
	
	System.out.println("the time i got from helper class"+time);
			
	time_visit_info.setTime(time);
	
	
	System.out.println(" The Time is being stored");

	
	/*lets remove the connection */
	
	String flag=cd.removeOracleConnection(con);
	
	System.out.println("hi i closed the connection");
	
	System.out.println("Hi iam exiting of TimeVisit_Info");
	
	
	
	}
	catch(Exception ex)
	{
		System.out.println("There is an exception to get the Time Visit Information:"+ex);
		ex.printStackTrace();
	}
	
	}
	
	
	public static void main(String s[])
	{
		
	}
}
	
