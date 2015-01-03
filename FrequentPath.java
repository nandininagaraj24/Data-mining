package com.datamining.frequentpathalgorithm;

import java.sql.*;
import java.io.*;

import com.datamining.connection.oracle.Connection_Database;

public class FrequentPath {

	PreparedStatement ps = null;

	Connection con = null;

	public static final String update_path_st = "insert into frequent_path(path) values(?)";

	Connection_Database cd = null;

	public void updatePath(String current_page, String next_page) {

		try {

			System.out.println("HI IAM IN FREQUENT PATH CLASS");

			/* creating connection */

			cd = new Connection_Database();

			con = cd.createOracleConnection();

			System.out.println("the connection is " + con);

			String path = current_page + next_page;

			System.out.println("HI upadion of path is being performed");

			ps = con.prepareStatement(update_path_st);

			ps.setString(1, path);

			int i = ps.executeUpdate();

			if (i == 1)
				System.out
						.println("updated sucessfully in database the path of web page *****************");
			else
				System.out
						.println("unsucessful updation of webpage *****************");

		}

		catch (Exception e) {

			System.out.println("this is an exception in frequent path class"
					+ e);
			System.out.println("#####################################");

			e.printStackTrace();

		}

		/* removing the connection */

		String value = cd.removeOracleConnection(con);

		System.out.println(value);

		System.out.println("HI IAM ENDING FREQUENT PATH CLASS");

	}

}
