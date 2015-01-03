package com.datamining.timeinformation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.datamining.constants.DataminingIF;


public class time1 {
	
	
	static String sql="select time1 from time_website";
	double time=0.0;
	
	List<Double> time_visit_info=null;
	
	public List<Double> getTimeSeconds()
	{
		try
		{
		Class.forName(DataminingIF.DATABASE_DRIVER);
	
		Connection con=DriverManager.getConnection(DataminingIF.DATABASE_URL,DataminingIF.USERNAME,DataminingIF.PASSWORD);
		
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery(sql);
		
		time_visit_info=new ArrayList<Double>();
		
		
		while(rs.next())
		{
			long time1=rs.getLong("time1");
			
			double time=(double)time1/1000000000;
			
			time_visit_info.add(time);
			
		
			System.out.println(time);
		}
		
		
		}
		catch(Exception nxe)
		{
			System.out.println("exception "+nxe);
			nxe.printStackTrace();
		}
		return time_visit_info;
	}
	
	
}
