package com.datamining.webcount;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.datamining.connection.oracle.Connection_Database;

import java.sql.*;

public class WebCountAcces
 {

private String user_name=null;
private PrintWriter out=null;
private String web_page_visited=null;
private Connection con=null;
private int webcount=0;
private final String web_find_st="select web_page_count from web_count where web_page_name=?";
private PreparedStatement prst=null;
private ResultSet rs=null;
private static final String Driver_name_oracle="oracle.jdbc.driver.OracleDriver";


public  int getCount(String web_page_visited,HttpServletResponse response)
		{
			PrintWriter pw=null;
	
			try
			{
				System.out.println("WebCountAcces entry ****************************************");
				
				Connection_Database cd=new Connection_Database();
				
				con=cd.createOracleConnection();
				
				System.out.println("the connection is "+con);
				
				
				System.out.println("ACESSING THE WEB COUNT");
				
				
				
				
				
				
				
		
				prst=con.prepareStatement(web_find_st);
			
				prst.setString(1,web_page_visited);

			
				rs=prst.executeQuery();

					while(rs.next())
						{
							webcount=rs.getInt("web_page_count");
							this.webcount=webcount;
						}
				pw=response.getWriter();
				
				/*removing the connection*/
				
				
				String value=cd.removeOracleConnection(con);
				
				System.out.println(value);
				
				
						
				
			}


			catch(Exception e)
			{
				
			
			pw.println("THIS IS METHOD GET Count AND CLASS WEB COUNT ACCESS:"+e);
			
			System.out.println("THIS IS METHOD GET Count AND CLASS WEB COUNT ACCESS****************************************"+e);
			
			e.printStackTrace();
			
			}
			System.out.println("sucessful web count return****************************************");
				return webcount;
			
	
		}	
}
