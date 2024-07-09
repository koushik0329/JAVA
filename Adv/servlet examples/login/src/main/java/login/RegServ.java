package login;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

/**
 * Servlet implementation class RegServ
 */
public class RegServ extends HttpServlet {
	Connection con;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			//using servletcontext and context parameter
			ServletContext sc=config.getServletContext();
			String s1=sc.getInitParameter("driver");
			String s2=sc.getInitParameter("url");
			String s3=sc.getInitParameter("username");
			String s4=sc.getInitParameter("password");
			Class.forName(s1);
	        con = DriverManager.getConnection(s2,s3,s4);
	        //without using context parameter
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//	        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "koushikkoushik");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String s1=request.getParameter("fname");
			String s2=request.getParameter("lname");
			String s3=request.getParameter("uname");
			String s4=request.getParameter("pword");
			PreparedStatement pt=con.prepareStatement("insert into uinfo values(?,?,?,?)");
			pt.setString(1, s1);
			pt.setString(2, s2);
			pt.setString(3, s3);
			pt.setString(4, s4);
			pt.executeUpdate();
			PrintWriter pw=response.getWriter();
			pw.println("<html><body bgcolor=cyan text=blue><center>");
			pw.println("<h1>you have registered successfully</h1>"); 
			pw.println("<a href=login.html>Login</a>");
			pw.println("</center></body></html>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
