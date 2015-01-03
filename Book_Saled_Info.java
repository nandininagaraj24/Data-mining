package com.datamining.bookinformation;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.datamining.connection.oracle.Connection_Database;

public class Book_Saled_Info {
	
	
	
	
	private PreparedStatement prst=null;
	
	private List book_name=null;
	
	public List getBook_name() {
		return book_name;
	}

	public void setBook_name(List book_name) {
		this.book_name = book_name;
	}

	public List getCount() {
		return count;
	}

	public void setCount(List count) {
		this.count = count;
	}

	private List count=null;
	
	private static final String book_saled_st_database="select * from book_t " ;
	
	private ResultSet rs=null;
	
	public void getSaledCount()
	{
		
		try
		{
		
			System.out.println("hi iam in class Book_Saled_Info");
			
			 book_name=new ArrayList();
			 
			 count=new ArrayList();
			
			 Book_Saled_Info bsi=new Book_Saled_Info();
			
		
		/*checking the connection */
			
		 Connection_Database cd=new  Connection_Database();
		 
		 /*creating a connection object */
		 
		Connection con= cd.createOracleConnection();
		
		
		System.out.println("hi i got the connection"+con);
					
		prst=con.prepareStatement(book_saled_st_database);
		
	
		
		rs=prst.executeQuery();
		
		System.out.println("hi iam now getting information from book_t table ");
		
		while(rs.next())
		{
			
			book_name.add(rs.getString("bookname"));
			
			 count.add(rs.getInt("count"));
			
				
					
			
		}
		
		System.out.println("hi i got the number of books saled and book name");
	
		 bsi.setBook_name(book_name);
		 
		 bsi.setCount(count);
		
		
		
		
		/*lets remove the connection */
		
		String flag=cd.removeOracleConnection(con);
		
		System.out.println("hi i closed the connection");
		
		System.out.println("Hi iam existing of Book_saled_Info_class");
		
		
		
		}
		catch(Exception ex)
		{
			System.out.println("There is an exception to get the book saled information:"+ex);
			ex.printStackTrace();
		}
		
	
	}
	
	
	
	
	

}
