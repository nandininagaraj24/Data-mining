package com.datamining.home.servlets;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

import com.datamining.bookinformation.Book_Count;
import com.datamining.bookinformation.CostSelection;
import com.datamining.clusteranalysis.Cluster_Analysis;
import com.datamining.connection.oracle.Connection_Database;
import com.datamining.frequentpathalgorithm.FrequentPath;
import com.datamining.visitorinfo.UpdateVisitorInformation;
import com.datamining.webcount.UpdateWebCount;
import com.datamining.webcount.WebCountAcces;

import java.sql.*;

public class HomeServlet extends HttpServlet 
 {

	
@Override
	
	public void init() throws ServletException 
		{
		
		}
 
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{


	RequestDispatcher rd=null;

	response.setContentType("text/html");

	rd=request.getRequestDispatcher("/pages/a.jsp");

	rd.forward(request,response);

}



 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 		{

	
			RequestDispatcher rd=null;

			response.setContentType("text/html");

			rd=request.getRequestDispatcher("/pages/a.jsp");

			rd.forward(request,response);

		}
 
 
	public void destroy( ) 
	{
 
	}

} 
