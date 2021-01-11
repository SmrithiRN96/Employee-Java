package com.Emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewServlet
 */
public class viewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
	
		try {
			List<Empdto> l=Empdao.showDetails();
			out.print("<table border='1px solid black' width='100%'>");
			out.print("<tr><th>ID</th><th>NAME</th><th>PASSWORD</th><th>EMAIL</th><th>COUNTRY</th><th>GENDER</th></tr>");
			for(Empdto e:l) {
				out.print("<tr>");
				out.print("<td>"+e.getId()+"</td>");
				out.print("<td>"+e.getName()+"</td>");
				out.print("<td>"+e.getPwd()+"</td>");
				out.print("<td>"+e.getEmail()+"</td>");
				out.print("<td>"+e.getCountry()+"</td>");
				out.print("<td>"+e.getGender()+"</td>");
				out.print("<td><a href='updateServlet?id="+e.getId()+"'>Edit</a></td>");
				out.print("<td><a href='deleteServlet?id="+e.getId()+"'>Delete</a></td>");
				out.print("</tr>");
			}
			out.print("</table>");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


}
