package in.sp.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

import in.sr.dbcon.DbConnection;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String myname=request.getParameter("name1");
		String myemail=request.getParameter("email1");
		String mypass=request.getParameter("pass1");
		String mycity=request.getParameter("city1");
		
		try {
			Connection con=DbConnection.getConnection();
			
			PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?)");
			ps.setString(1, myname);
			ps.setString(2, myemail);
			ps.setString(3, mypass);
			ps.setString(4, mycity);
			
			int count=ps.executeUpdate();
			if(count>0) {
				out.println("<h3 style='color:green'>registered successfully</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("/login.html");
				rd.include(request, response);
			}
			else{
				out.println("<h3 style='color:red'>registration failed</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("/register.html");
				rd.include(request, response);
			}
			}
		catch(Exception e) {	
			e.printStackTrace();
		}
		
//		doGet(request, response);
	}

}
