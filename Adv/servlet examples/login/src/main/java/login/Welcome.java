package login;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Servlet implementation class Welcome
 */
public class Welcome extends HttpServlet {
	Connection con;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }
    
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
			}
			catch(Exception e) {
				e.printStackTrace();
			}
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
		String s=request.getParameter("uname");
		PrintWriter pw=response.getWriter();
		pw.println("<html><body bgcolor=yellow text=blue><h1>");
		pw.println("welcome"+s);
		pw.println("</h1></body></html>");
		doGet(request, response);
	}

}
