package com.datamining.webcount;


import java.sql.*;

import com.datamining.connection.oracle.Connection_Database;


public class UpdateWebCount
{

private Connection con=null;

private static String update_visitor="update web_count set WEB_PAGE_COUNT=? where web_page_name=?";

private PreparedStatement ps=null;







	public void updatingWebCount(int webcount,String web_page_name)
		{
			try
			{
				
				System.out.println("iam in the class update web count:");
			/* creating a connection */
	
				Connection_Database cd=new Connection_Database();
				
				con=cd.createOracleConnection();
				
				System.out.println("the connection is "+con);
				
								
				
	
			
	
			/* updating in the database the customer name and web page*/
				
				System.out.println("sucessful connection creation and now web count is beign updated IAM IN Update Web Count Class");
				

			ps=con.prepareStatement(update_visitor);
			
			ps.setInt(1,webcount);
			ps.setString(2,web_page_name);

    			int i=ps.executeUpdate();
			if(i==1)
			System.out.println("updated sucessfully COUNT*********************************************");
			else
			System.out.println("updated failed of COUNT*********************************************");
			
			/*removing the connection*/
			
			
			String value=cd.removeOracleConnection(con);
			
			System.out.println(value);
			
			
						
			
			
			}

			catch(SQLException se)
			{
				System.out.println("THIS IS AN EXCEPTION IAM IN UpdateWebCount CLASS:"+se);
				
				se.printStackTrace();
				
				
			}

		}
 



}
