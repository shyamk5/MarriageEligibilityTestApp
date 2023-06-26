package com.sk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MarriageEligibilityTestServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("text/html");
		
		//get PrintWriter Stream
		PrintWriter pw = res.getWriter();
		
		//get request data based on the action url
		String name = req.getParameter("pname");
		int age = Integer.parseInt(req.getParameter("page"));
		String gender = req.getParameter("pgender");
		
		
		//write blogic
		if(gender.equalsIgnoreCase("male")) {
			if(age < 21)
				pw.println("<h2 style= 'color:blue'>Too Early! Mr.  "+name+" I think you're really excited to get married :) But please wait for some time </h2>");
			else if(age >=21 && age <=40)
				pw.println("<h2 style= 'color:green'>Thanks for showing your interest in Marriage Mr.  "+name+" You are now eligible to get married.</h2>");
			else
				pw.println("<h2 style= 'color:red'>Thanks for showing your interest in Marriage Mr.  "+name+" But You can't marriage</h2>");
		}
		else if(gender.equalsIgnoreCase("female")){
			if(age < 18)
				pw.println("<h2 style= 'color:blue'>Too Early!  Miss "+name+" I think you're really excited to get married :) But please wait for some time </h2>");
			else if(age >=18 && age <=40)
				pw.println("<h2 style= 'color:green'>Thanks for showing your interest in Marriage Miss  "+name+" You are now eligible to get married.</h2>");
			else
				pw.println("<h2 style= 'color:red'>Thanks for showing your interest in Marriage Miss  "+name+" But You can't marriage</h2>");
		}
		
		//add home hyperlink
		pw.println("<a href='/MarriageEligibilityTestApp/index.html'><h3>Back to Home</h3></a>");
				
		//close the stream
		pw.close();
	}
}
