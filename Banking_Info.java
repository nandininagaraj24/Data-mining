package com.datamining.bankinformation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.datamining.connection.oracle.Connection_Database;

public class Banking_Info 
	{
	
		
	private PreparedStatement prst=null;
	
	private List banking_info_account_no=null;
	
	private List banking_info_password=null;
	
	


	private List banking_info_customername=null;
	
	private List banking_info_customeramount=null;
	
	private static final String banking_st_database="select * from banking_t" ;
	
	private ResultSet rs=null;
	
	
	public void getBankInfo()
	{
		
		try
		{
			System.out.println("hi iam in class Banking_Info");
		
			banking_info_account_no=new ArrayList();
			
			banking_info_password=new ArrayList();
			
			
			banking_info_customername=new ArrayList();
			
			banking_info_customeramount=new ArrayList();
			
			
			
			
		
		
		
		/*checking the connection */
			
		 Connection_Database cd=new  Connection_Database();
		 
		 /*creating a connection object */
		 
		Connection con= cd.createOracleConnection();
		
		
		System.out.println("hi i got the connection"+con);
					
		prst=con.prepareStatement(banking_st_database);
		
		
		
		rs=prst.executeQuery();
		
		System.out.println("hi iam now getting information from web_count table ");
		
		while(rs.next())
		{
			banking_info_account_no.add(rs.getString("ACCOUNT_NO"));
			
			banking_info_password.add(rs.getString("PASSWORD1"));
			
			banking_info_customername.add(rs.getString("CUSTOMERNAME"));
					
			banking_info_customeramount.add(rs.getInt("AMOUNT"));	
			
		}
		
		System.out.println("hi i got the bank information");
		Banking_Info banking= new Banking_Info();
		
		
		banking.setBanking_info_account_no(banking_info_account_no);
		
		System.out.println("Here Iam Storing the Accountno "+banking_info_account_no);
		
		banking.setBanking_info_password(banking_info_password);
					
		System.out.println(" Password Information updated"+banking_info_password);
	
		banking.setBanking_info_customername(banking_info_customername);
		
	
		System.out.println("Here Iam Storing the Customername"+banking_info_customername); 
		
		banking.setBanking_info_customeramount(banking_info_customeramount);
		
		System.out.println("Here Iam Storing  Amount Information"+banking_info_customeramount);
		
		/*lets remove the connection */
		
		String flag=cd.removeOracleConnection(con);
		
		System.out.println("hi i closed the connection");
		
		System.out.println("Hi iam exiting of BankingInfoClass");
		
		
		
		}
		catch(Exception ex)
		{
			System.out.println("There is an exception to get the Banking information:"+ex);
			ex.printStackTrace();
		}
		
		
	}


	public List getBanking_info_account_no() {
		return banking_info_account_no;
	}


	public void setBanking_info_account_no(List banking_info_account_no) {
		this.banking_info_account_no = banking_info_account_no;
	}


	public List getBanking_info_password() {
		return banking_info_password;
	}


	public void setBanking_info_password(List banking_info_password) {
		this.banking_info_password = banking_info_password;
	}


	public List getBanking_info_customername() {
		return banking_info_customername;
	}


	public void setBanking_info_customername(List banking_info_customername) {
		this.banking_info_customername = banking_info_customername;
	}


	public List getBanking_info_customeramount() {
		return banking_info_customeramount;
	}


	public void setBanking_info_customeramount(List banking_info_customeramount) {
		this.banking_info_customeramount = banking_info_customeramount;
	}
	
	
	
			
	

	}
