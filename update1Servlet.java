package com.Emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update1Servlet
 */
public class update1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest  req,HttpServletResponse res) throws ServletException, IOException {
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);
		System.out.println(id);
//		PrintWriter out=res.getWriter();
//		out.print(id);
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		String country=req.getParameter("country");
		Empdto e=new Empdto();
		if(gender.equals("male"))
		{
			gender="MALE";
		}
		else {
			gender="FEMALE";
		}
			e.setId(id);
			e.setName(name);
			e.setPwd(pwd);
			e.setEmail(email);
			e.setGender(gender);
			e.setCountry(country);
			try {
				Empdao.updateDetails(e);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			RequestDispatcher rd=req.getRequestDispatcher("viewServlet");
			rd.include(req, res);
}

}
