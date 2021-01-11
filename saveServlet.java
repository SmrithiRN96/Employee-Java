package com.Emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class saveServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		String name=req.getParameter("name").trim();
		String pwd=req.getParameter("pwd").trim();
		String email=req.getParameter("email").trim();
		String gender=req.getParameter("gender").trim();
		String country=req.getParameter("country").trim();
		PrintWriter out=res.getWriter();
		Empdto e=new Empdto();
		if(gender.equals("male"))
		{
			gender="MALE";
		}
		else {
			gender="FEMALE";
		}
		e.setName(name);
		e.setPwd(pwd);
		e.setEmail(email);
		e.setGender(gender);
		e.setCountry(country);
		try {
			Empdao.saveDetails(e);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		res.sendRedirect("viewServlet");
		
	}
}
