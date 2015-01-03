package com.datamining.submitservlets;
 
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
import com.datamining.visitorinfo.UpdateVisitorInformation;
import com.datamining.webcount.UpdateWebCount;
import com.datamining.webcount.WebCountAcces;

import java.sql.*;

public class FirstServlet extends HttpServlet 
 {

private String user_name=null;
private PrintWriter out=null;
private String book_selected=null;
private Connection con=null;
private int cost=0;
private final String cost_find_st="select cost1 from Book_T where bookname=?";
private PreparedStatement prst=null;
private ResultSet rs=null;
private HttpSession hs=null;
private RequestDispatcher rd=null;
private String web_page=null;
private UpdateWebCount uwc=null;
private WebCountAcces wca=null;
private int webcount=0;
private long starttime=0;
private long endtime=0;
private long totaltime=0;
private String web_page_name="a.html";

private String ServletContext =null;

public static final String Driver_name_oracle="oracle.jdbc.driver.OracleDriver";




	public void init(ServletConfig config) throws ServletException 
		{
			
			System.out.println("hi iam inm init method of first servlet **************************");
			starttime=System.nanoTime();
			this.starttime=starttime;

			

		}
 
	
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 		{
			try
			{

				hs=request.getSession(true);
				
				
				
		 		FirstServlet fs=new  FirstServlet();

		
				/* getting the parameters of first web page*/

	 			user_name = request.getParameter("name");

	 			book_selected= request.getParameter("java_list");
	 			
	 			Book_Count bc=new Book_Count();
	 			
	 			bc.updateBookCount(book_selected);
 	 
	 			response.setContentType("text/html");
 
	 			out = response.getWriter();

	 			out.println("Welcome Customer"+"\t"+user_name);
				
				hs.setAttribute("CUSTOMER_NAME",user_name);
			
	
	 			out.println("Selected Book"+"\t"+book_selected);
				
				
				
				
				
				/*getting the cost of the book from database*/
				
				CostSelection cs=new CostSelection();
					
						
				cost=cs.getCost(book_selected,response);
				
				out.println("the cost of the book is:"+cost);
				
				
				
				
				/* obtain the url of visited web page */
		
				web_page=request.getRequestURI();


				/*updating in database customer_name and webpage visited*/
				
				System.out.println("hi iam in update vistior information");
				
				UpdateVisitorInformation uvi=new  UpdateVisitorInformation();	 

				uvi.updatingVisitorInfo(user_name,web_page);

				

				hs.setAttribute("BOOK_AMOUNT",cost);
				
				System.out.println("ddddddddddddddddddddddddah"+hs.getAttribute("BOOK_AMOUNT"));

				/*getting access of count in database*/
				System.out.println("before webcount access****************************************"+webcount);
				wca=new WebCountAcces();
				webcount=wca.getCount("java_page",response);
				webcount=webcount+1;
				
				System.out.println("this is first servlet webcount is sucessful****************************************"+webcount);
				
				/*updating count of the page visited */
				
				uwc=new UpdateWebCount();
				
				uwc.updatingWebCount(webcount,"java_page");
				
				/*sending to account page to complete transactions*/
				
				rd=request.getRequestDispatcher("/pages/account.jsp");
				rd.forward(request,response);

				
			}
	
			catch(Exception e)
			{
				out.println("THIS IS FIRST SERVLET AND THERE IS AN EXCEPTION:"+"\t"+e);
			}
	

			captureTimeVisit();
			
 
		}
	
	private void captureTimeVisit()
	{
		endtime=System.nanoTime();


		 Cluster_Analysis ca=new  Cluster_Analysis();

		totaltime=endtime-starttime;

		ca.storeVisitTime(totaltime,web_page_name);
		
		this.starttime=0;

		this.endtime=0;

		this.totaltime=0;

	}
 
 
	public void destroy( ) 
		{
 
			endtime=System.nanoTime();


			 Cluster_Analysis ca=new  Cluster_Analysis();

			totaltime=endtime-starttime;

			ca.storeVisitTime(totaltime,web_page_name);
			
			this.starttime=0;

			this.endtime=0;

			this.totaltime=0;
			System.out.println("hi iam in destroy method of first servlet **************************");


		}
} 
