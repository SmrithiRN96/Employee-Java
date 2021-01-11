package com.Emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class updateServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		int a=Integer.parseInt(req.getParameter("id"));
		PrintWriter out=res.getWriter();
		try {
			Empdto e= Empdao.selectbyId(a);
			res.setContentType("text/html");
			out.print("<form action='update'>");
			out.print("<table>");
			out.print("<td><input type='hidden' name='id' value='"+e.getId()+"'></td></tr>");
			out.print("<tr><td>NAME :</td>");
			out.print("<td><input type='text' name='name' value='"+e.getName()+"'></td></tr>");
			out.print("<tr><td>PASSWORD :</td>");
			out.print("<td><input type='password' name='pwd' value='"+e.getPwd()+"'></td></tr>");
			out.print("<tr><td>EMAIL :</td>");
			out.print("<td><input type='email' name='email' value='"+e.getEmail()+"'></td></tr>");
			out.print("<tr><td>COUNTRY :</td>");
			out.print("<td><select name=\"country\">\r\n"
					+ "<option value='india' >INDIA</option>\r\n"
					+ "<option value='uae' >UNITED ARAB EMIRATES</option>\r\n"
					+ "<option value='us' >UNITED STATES</option>\r\n"
					+ "</select></td></tr>");
			out.print("<tr><td>GENDER :</td>");
			//out.print("<td><input type='radio' name='gender' value='male'>MALE\r\n"
					//+ "<input type='radio' name='gender' value='female'>FEMALE</td></tr>");
			out.print("<td><input type='radio' name='gender' value='male' >");
			out.print("<input type='radio' name='gender' value='female'>");
			out.print("</table>");
			out.print("<input type='submit' value='UPDATE'>");
			out.print("</form>");
			
			
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}

	}

}
