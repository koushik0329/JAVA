package in.sp.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.sr.dbcon.DbConnection;
import in.sr.model.User;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
//		doGet(request, response);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String myemail=request.getParameter("email1");
		String mypass=request.getParameter("pass1");
		try {
			Connection con=DbConnection.getConnection();
			
			PreparedStatement ps=con.prepareStatement("select * from register where email=? and password=?");
			
			ps.setString(1, myemail);
			ps.setString(2, mypass);
			
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				User user=new User();
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setCity(rs.getString("city"));
				
				HttpSession session=request.getSession();
				session.setAttribute("session_user",user);
				
				RequestDispatcher rd=request.getRequestDispatcher("/profile.jsp");
				rd.include(request, response);
			}
			else{
				out.println("<h3 style='color:red'>login failed</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("/login.html");
				rd.include(request, response);
			}
			}
		catch(Exception e) {	
			e.printStackTrace();
		}
	}

}
