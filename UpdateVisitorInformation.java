package com.datamining.visitorinfo;

import java.sql.*;

import com.datamining.connection.oracle.Connection_Database;

public class UpdateVisitorInformation {

	private int page_count = 0;

	private String customer_name = null;

	private String web_page = null;

	private Connection con = null;

	private static String update_visitor = "insert into visitor_info(customer_name,web_page,DATE_VISIT) values(?,?,CURDATE())";

	private PreparedStatement ps = null;

	public void updatingVisitorInfo(String customer_name, String web_page) {
		try {
			/* creating a connection */

			Connection_Database cd = new Connection_Database();

			con = cd.createOracleConnection();

			System.out.println("the connection is " + con);

			/* updating in the database the customername and web page */

			System.out
					.println("hi iam in Update Visitor Information connection is sucessful");

			ps = con.prepareStatement(update_visitor);
			ps.setString(1, customer_name);
			ps.setString(2, web_page);
			int i = ps.executeUpdate();
			if (i == 1)
				System.out
						.println("updated sucessfully *********************************************");
			else
				System.out
						.println("updated failed *********************************************");

			/* removing the connection */

			String value = cd.removeOracleConnection(con);

			System.out.println(value);

			System.out.println("hi iam going out of Update Visitor Info Class");

		}

		catch (SQLException se) {
			System.out
					.println("THIS IS AN EXCEPTION IAM IN UpdateVisitorInformation CLASS:"
							+ se);

			se.printStackTrace();

		}

	}

	public static void main(String s[]) {
		UpdateVisitorInformation updateVisitorInformation = new UpdateVisitorInformation();

		updateVisitorInformation.updatingVisitorInfo("AAQ", "a.html");

	}

}
