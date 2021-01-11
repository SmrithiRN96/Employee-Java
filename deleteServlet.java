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
 * Servlet implementation class deleteServlet
 */
public class deleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String sid=request.getParameter("id");
		response.setContentType("text/html");
		int id=Integer.parseInt(sid);
		try {
			int status=Empdao.deleteDetails(id);
			if(status!=0)	
			{
				out.print("SUCCESSFULLY DELETED");
				//response.sendRedirect("viewServlet");
				RequestDispatcher rd=request.getRequestDispatcher("viewServlet");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	
	}
}
