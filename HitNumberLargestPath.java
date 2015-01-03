package com.datamining.frequentpath.helper;

import java.sql.*;
import java.io.*;

import com.datamining.connection.oracle.Connection_Database;

public class HitNumberLargestPath {

	Statement st = null;

	Connection con;

	ResultSet rs = null;

	Connection_Database cd = null;

	int count = 0;

	public static final String count_path1_st = "select count(*) from frequent_path where path='a.htmlb.htmlc.htmld.html' or path='d.htmlc.html.b.htmla.html'";

	public static final String count_path2_st = "select count(*) from frequent_path where path='a.htmle.htmlf.html' or path='e.htmla.html'";

	public int getLargestPathHitNumber(String path) {
		System.out.println(" iam in HitNumberLargestPath ");

		try

		{

			/* creating connection */
			cd = new Connection_Database();

			con = cd.createOracleConnection();

			System.out.println("the connection is " + con);

			st = con.createStatement();

			if (path.equalsIgnoreCase("one")) {

				System.out.println("Getting the count of first largest path");
				rs = st.executeQuery(count_path1_st);

				while (rs.next()) {
					count = rs.getInt(1);
				}

				System.out.println("The count of first largest path is:"
						+ count);

			}

			else if (path.equalsIgnoreCase("two")) {

				System.out.println("Getting the count of second largest path");

				rs = st.executeQuery(count_path2_st);

				while (rs.next()) {
					count = rs.getInt(1);
				}

				System.out.println("The count of second largest path is:"
						+ count);

			}

			else {
				System.out.println("invalid path entered");

				count = 0;
			}

		} catch (Exception e) {

			System.out
					.println("Exception caugth: iam in HitNumberLargestPathClass"
							+ e);

			e.printStackTrace();
		}

		/* removing the connection */

		String value = cd.removeOracleConnection(con);

		System.out.println(value);

		System.out.println("IAM AT THE END OF HIT NUMBERS LARGEST PATH CLASS");
		return count;

	}

}
