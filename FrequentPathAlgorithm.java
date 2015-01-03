package com.datamining.frequentpathalgorithm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import com.datamining.frequentpath.helper.HitNumbers;

import java.util.*;

public class FrequentPathAlgorithm extends HttpServlet {

	int Whole_Website_Hit = 0;

	List<Double> frequency_website_hit = new ArrayList<Double>();

	List<Integer> hit_numbers = new LinkedList<Integer>();

	Double weigth = 0.3;

	String frequentpath = null;

	PrintWriter out;

	HitNumbers hn = null;
	
	

	Exception e = new Exception();

	public static final String path1 = "a.html--->b.html--->c.html---->d.html";

	public static final String path2 = "a.html--->e.html---->f.html";

	public int getWholeWebsiteHit(int a, int b) {

		return (a + b);

	}

	public String getFrequentPath(List frequency_website_hit) {


		Double frequent1=(Double) frequency_website_hit.get(0);
		
		Double frequent2=(Double) frequency_website_hit.get(1);
		
		if(frequent1.isNaN() || frequent2.isNaN())
		{
			frequentpath= "FREQUENT PATH CANNOT BE DETERMINED BECAUSE ONE OR BOTH OF FREQUENT PATH IS NOT A NUMBER";
			return frequentpath;
	
		}
				
		if(((Double) frequency_website_hit.get(1)) > weigth && ((Double) frequency_website_hit.get(0)) > weigth)
		{
			frequentpath= "Both Are Frequent Paths ("+path1+")"+"<br>"+"("+path2+")";
			return frequentpath;
		}
		
		if(((Double) frequency_website_hit.get(1)) < weigth && ((Double) frequency_website_hit.get(0)) < weigth)
		{
			frequentpath= "PATHS DO NOT SATISFY CRITERIA HENCE NO ONE CAN BE FREQUENT PATH";
			return frequentpath;
			
		}
		if (((Double) frequency_website_hit.get(0)) > weigth) {
			frequentpath= "The frequent path is: 1" + path1;

		} 
		if (((Double) frequency_website_hit.get(1)) > weigth)
		{
			frequentpath= "The frequent path is: 2" + path2;
		}

		return frequentpath;
	
	
	}

	public String mostFrequentPath(List frequency_website_hit) {
		
		System.out.println("iam in most frequent path");
		
		Double frequent1=(Double) frequency_website_hit.get(0);
		
		Double frequent2=(Double) frequency_website_hit.get(1);
		
		System.out.println("Freq1"+frequent1);
		System.out.println("Freq1"+frequent2);
		
		if(frequent1.isNaN() || frequent2.isNaN())
		{
			
			frequentpath= "FREQUENT PATH CANNOT BE DETERMINED BECAUSE ONE OR BOTH OF FREQUENT PATH IS NOT A NUMBER";
			return frequentpath;
	
		}

		if (((Double) frequency_website_hit.get(0)) > ((Double) frequency_website_hit
				.get(1))) {
			
			return "The frequent path is: 1" + path1;

		}
		if (frequent1.equals(frequent2))
		{
			
			return "FREQUENT PATH CANNOT BE DETERMINED BECAUSE BOTH ARE EQUAL";
		}

		if (((Double) frequency_website_hit.get(0)) < ((Double) frequency_website_hit
				.get(1))) {
			return "The frequent path is: 2" + path2;

		}
		return frequentpath;
	}

	public List getFrequencyWebSite(int Whole_Website_Hit, List hit_numbers) {

		System.out.println("The whole website hit is" + Whole_Website_Hit
				+ "{{{{{{{{{{{{{{{{{{{");

		Integer hit1 = (Integer) hit_numbers.get(0);

		int hit11 = (int) hit1;

		
		double f1 = (double) ((double) hit11 / (double) Whole_Website_Hit);

				Double f11 = new Double(f1);

		frequency_website_hit.add(f11);

		Integer hit2 = (Integer) hit_numbers.get(1);

		int hit22 = (int) hit2;

		double f2 = (double) ((double) hit22 / (double) Whole_Website_Hit);

		Double f22 = new Double(f2);

		frequency_website_hit.add(f22);

		return frequency_website_hit;

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			/* getting object to call methods */

			FrequentPathAlgorithm fpa = new FrequentPathAlgorithm();

			/* GETTING THE RESPONSE OBJECT */

			System.out
					.println("BEFORE RESPONSE OBJECT:******************************");
			out = response.getWriter();
			System.out
					.println("THE response object is:******************************"
							+ out);

			/* getting the hitnumbers */

			hn = new HitNumbers();
			System.out
					.println("THE hit number object is:******************************"
							+ hn);

			hit_numbers = hn.getHitNumbersLargestpath();

			System.out
					.println("THE LENGTH OF LIST IS:******************************"
							+ hit_numbers.size());

			/* didplaying the hit numbers of the largestpaths */

			out.println("<h2>" + "HIT NUMBER OUTPUT OF ALGORITHM" + "</h2>");
			out.println("<hr>");
			out.println("<br>");
			System.out
					.println("THE HIT NUMBER OF FIRST PATH and SECOND PATH IS OBTAINED");

			out.println("HIT NUMBER OF FIRST PATH IS:" + hit_numbers.get(0));
			out.println("<br>");
			out.println("HIT NUMBER OF SECOND PATH IS:" + hit_numbers.get(1));

			/* calculating the hit count of entire web site */

			int a = hit_numbers.get(0);
			int b = hit_numbers.get(1);

			System.out.println("THE WHOLE WEBSITE HIT NUMBER IS OBTAINED");
			Whole_Website_Hit = fpa.getWholeWebsiteHit(a, b);

			/* displaying the hit count */
			out
					.println("<h2>"
							+ "WEBSITE VISIT TIME OF FREQUENT PATH ALGORITHM"
							+ "</h2>");
			out.println("<hr>");
			out.println("<br>");

			out.println("The Web site has been visited :" + Whole_Website_Hit
					+ "times");

			/* finding the frequency of each path */

			frequency_website_hit = fpa.getFrequencyWebSite(Whole_Website_Hit,
					hit_numbers);
			
	
			

			/* displaying the frequency */
			out.println("<h2>"
					+ "FREQUENCY OF WEBSITE  USING FREQUENT PATH ALGORITHM"
					+ "</h2>");

			out.println("<hr>");
			out.println("<br>");

			System.out.println("THE FREQUENCY OF BOTH PATHS ARE");

			out.println("The frequency of first path is:"
					+ frequency_website_hit.get(0));

			out.println("<br>");
			out.println("The frequency of second path is:"
					+ frequency_website_hit.get(1));

			/* getting the frequent path */
			out
					.println("<h2>"
							+ "FREQUENT PATH ALGO WITH RESPECT TO THRESHOLD"
							+ "</h2>");
			out.println("<br>");
			out.println("<hr>");

			out.println(getFrequentPath(frequency_website_hit));

			/* getting the most frequent amoung largest path */

			String message = fpa.mostFrequentPath(frequency_website_hit);
			out
					.println("<h2>"
							+ "FREQUENT WEBSITE PATH USING FREQUENT PATH ALGO amoung two paths:"
							+ "</h2>");
			
			out.println("<hr>");
			out.println("<br>");

			out.println(message);

		}

		catch (Exception e) {

			out
					.println("THIS IS IO EXCEPTION IAM IN FREQUENT PATH ALGORITHM CLASS"
							+ e);

			e.printStackTrace();
		}

	}

}
