package com.datamining.clusteranalysis;

import java.sql.*;

import com.datamining.connection.oracle.Connection_Database;

public class Cluster_Analysis {

	private Connection con = null;

	private static String update_visitor = "insert into Time_website(TIME1,web_page_name) values(?,?)";

	private static String get_visitor_time_st = "select TIME1 from Time_website where web_page_name=?";

	private PreparedStatement ps = null;

	private Connection_Database cd = null;

	private long time_from_data_base = 0;

	public void storeVisitTime(long totaltime, String web_page_name) {
		try {

			System.out.println("HI IAM IN START OF CLUSTER ANALYSIS CLASS");
			/* creating a connection */

			cd = new Connection_Database();

			con = cd.createOracleConnection();

			System.out.println("the connection is " + con);

			/* getting the data from the database */

			System.out
					.println("Getting the time duration of visit of each web page");

			PreparedStatement pst = con.prepareStatement(get_visitor_time_st);

			pst.setString(1, web_page_name);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				time_from_data_base = rs.getLong("TIME1");

				System.out.println("Getting the Data from  database sucessful"
						+ time_from_data_base);
			} else {
				System.out.println("cant get time data from database");
			}

			/* updating in the database the customername and web page */

			System.out
					.println("updating the time duration of visit of the page");

			ps = con.prepareStatement(update_visitor);

			ps.setLong(1, totaltime + time_from_data_base);
			ps.setString(2, web_page_name);

			int i = ps.executeUpdate();
			if (i == 1)
				System.out
						.println("updated sucessfully time taken*********************************************");
			else
				System.out
						.println("updated failed of time taken *********************************************");

		}

		catch (Exception se) {
			System.out
					.println("THIS IS AN EXCEPTION IAM IN cluster analysis CLASS:"
							+ se);

			se.printStackTrace();
		}

		/* removing the connection */

		String value = cd.removeOracleConnection(con);

		System.out.println(value);

		System.out
				.println("HI THIS IS THE LAST ENDING OF CLUSTER ANALYSIS CLASS");

	}
	
	public static void main(String s[])
	{
		Cluster_Analysis ca=new Cluster_Analysis();
		
		ca.storeVisitTime(100L,"a.hmtl");
		
		
		
	}

}
