package com.datamining.frequentpathalgorithm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.datamining.connection.oracle.Connection_Database;

public class Frequent_Path_Info {

	private PreparedStatement prst = null;

	private List count_no = null;

	public List getCount_no() {
		return count_no;
	}

	public void setCount_no(List count_no) {
		this.count_no = count_no;
	}

	public List getPath() {
		return path;
	}

	public void setPath(List path) {
		this.path = path;
	}

	private List path = null;

	private static final String freq_path_st_database = "select DISTINCT count(*), path from frequent_path group by path ";

	private ResultSet rs = null;

	public void getFrequentPathsInfo() {

		try {

			System.out.println("hi iam in class Frequent_Path_Info");

			count_no = new ArrayList();

			path = new ArrayList();

			Frequent_Path_Info fpi = new Frequent_Path_Info();

			/* checking the connection */

			Connection_Database cd = new Connection_Database();

			/* creating a connection object */

			Connection con = cd.createOracleConnection();

			System.out.println("hi i got the connection" + con);

			prst = con.prepareStatement(freq_path_st_database);

			rs = prst.executeQuery();

			System.out
					.println("hi iam now getting information from frequent_path table ");

			while (rs.next()) {

				count_no.add(rs.getInt(1));

				path.add(rs.getString("path"));

			}

			System.out.println("hi i got the frequent_path info");

			fpi.setCount_no(count_no);

			fpi.setPath(path);

			/* lets remove the connection */

			String flag = cd.removeOracleConnection(con);

			System.out.println("hi i closed the connection");

			System.out.println("Hi iam existing of class Frequent_Path_Info");

		} catch (Exception ex) {
			System.out
					.println("There is an exception to get the  Frequent_Path_Info:"
							+ ex);
			ex.printStackTrace();
		}

	}
}
