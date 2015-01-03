package com.datamining.bookinformation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.datamining.connection.oracle.Connection_Database;

public class Book_Count {
	
	Connection con=null;
	
	public int database_count=0;
	
	PreparedStatement prst1=null;
	
	PreparedStatement prst=null;
	
	ResultSet rs=null;
	
	public static String book_count_query="select count from book_t where BOOKNAME=?";
	
	public static String update_count_query="update  book_t set count=? where bookname=?";
	
	public void updateBookCount(String bookname)
	{
		
		try
		{
			Connection_Database cd=new Connection_Database();
	
			con=cd.createOracleConnection();
	
			System.out.println("the connection is "+con);
	
	
			prst =con.prepareStatement(book_count_query); 
	
			prst.setString(1,bookname);
	
			rs=prst.executeQuery();
	
			while(rs.next())
			{
					database_count=rs.getInt("count");
			}
		
	
			System.out.println("the count"+database_count);
	
			int total_count=database_count+1;
	
			prst1 =con.prepareStatement(update_count_query); 
	
			prst1.setInt(1,total_count);
	
			prst1.setString(2,bookname);
	
			prst1.execute();
			
	
			/*removing the connection*/
	
	
			cd.removeOracleConnection(con);
	
			
	
	
	
	
	
		}
		catch(Exception ex)
		{
			System.out.println("the exception is:"+ex);
			
			ex.printStackTrace();
		}

		finally
		{
			try
			{
				if(rs!=null)
				{
					rs.close();
				}
				if(prst!=null)
				{
					prst.close();
				}
				if(prst1!=null)
				{
					prst1.close();
				}
				
				
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
}
