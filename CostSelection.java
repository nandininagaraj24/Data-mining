package com.datamining.bookinformation;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.datamining.connection.oracle.Connection_Database;

import java.sql.*;

public class CostSelection 
 {


private Connection con=null;
private int cost=0;
private final String cost_find_st="select cost1 from Book_T where bookname=?";
private PreparedStatement prst=null;
private ResultSet rs=null;



public  int getCost(String book_selected,HttpServletResponse response)
		{
			PrintWriter pw=null;
	
			try
			{
				System.out.println("hi iam in cost selection class");
				
				/*creating the connection database object */		
				
							
				Connection_Database cd=new Connection_Database();
				
				con=cd.createOracleConnection();
				
				System.out.println("the connection is "+con);
				
								
					/* obtaining the cost of book */	
				
		
				prst=con.prepareStatement(cost_find_st);
			
				prst.setString(1,book_selected);

			
				rs=prst.executeQuery();

					while(rs.next())
						{
							cost=rs.getInt("cost1");
							this.cost=cost;
						}
				pw=response.getWriter();
				
				System.out.println("hi i got the cost of book");
				
				/*removing the connection*/
				
				
				String value=cd.removeOracleConnection(con);
				
				System.out.println(value);
			}


			catch(Exception e)
			{
				
			
			pw.println("THIS IS METHOD GET COST AND CLASS COST SELECTION:"+e);
			
			e.printStackTrace();
			

			}
			
			System.out.println(cost);
				return cost;
	
	
		}	
}
