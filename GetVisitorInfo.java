package com.datamining.visitorinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.datamining.connection.oracle.Connection_Database;



public class GetVisitorInfo 
{
	
	List<String> customerName=null;
	List<String> customerDate=null;
	List<String>  webPageName=null;
	private Connection con=null;
	private PreparedStatement psmt=null;
	private ResultSet rs=null;
	
	
	
	public List<String> getCustomerName()
	{
		customerName=new ArrayList<String>();
		
		/*Connection Database */
		
		Connection_Database cd=new Connection_Database();
		
		con=cd.createOracleConnection();
		
		try 
		{
			psmt=con.prepareStatement(QueryClass.CUSTOMERNAME_QUERY);
			rs=psmt.executeQuery();
			
			while(rs.next())
			{
				if(rs.getString("customer_name")!=null)
				{
					customerName.add(rs.getString("customer_name"));
				}
				
			}
			
			cd.removeOracleConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(rs!=null)
				{
					rs.close();
				}
				
				if(psmt!=null)
				{
					psmt.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		
		
		return customerName;
	}
	
	
	public List<String> getWebPageName()
	{
		try
		{
			Connection_Database cd=new Connection_Database();
			con=cd.createOracleConnection();
			
			webPageName=new ArrayList<String>();
			psmt=con.prepareStatement(QueryClass.WEBPAGE_QUERY);
			rs=psmt.executeQuery();
		
		while(rs.next())
		{
			if(rs.getString("web_page")!=null)
			{
				webPageName.add(rs.getString("web_page"));
			}
			
		}
		cd.removeOracleConnection(con);
		
	} 
	catch (SQLException e)
	{
		
		e.printStackTrace();
	}
	
	finally
	{
		try
		{
			if(rs!=null)
			{
				rs.close();
			}
			
			if(psmt!=null)
			{
				psmt.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	return webPageName;
	}
	
	
	public List<String> getDateInfo()
	{
		customerDate=new ArrayList<String>();
		try
		{
		
			Connection_Database cd=new Connection_Database();
			con=cd.createOracleConnection();
			
			psmt=con.prepareStatement(QueryClass.DATE_QUERY);
			rs=psmt.executeQuery();
		
		while(rs.next())
		{
			if(rs.getString("date_visit")!=null)
			{
				customerDate.add(rs.getString("date_visit"));
			}
			
		}
		
		cd.removeOracleConnection(con);
		
	} 
	catch (SQLException e)
	{
		
		e.printStackTrace();
	}
		
	finally
	{
		try
		{
			if(rs!=null)
			{
				rs.close();
			}
			
			if(psmt!=null)
			{
				psmt.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
						
		return customerDate;
	}
	
	
	
	
}
