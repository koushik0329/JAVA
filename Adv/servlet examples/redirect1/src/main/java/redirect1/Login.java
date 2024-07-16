package redirect1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String email=request.getParameter("email1");
		String pass=request.getParameter("pass1");
		PrintWriter out=response.getWriter();
		if(email.equals("abc") && pass.equals("abc")) {
			request.setAttribute("key", "koushik");
			RequestDispatcher rd=request.getRequestDispatcher("/profile.jsp");
			rd.forward(request, response);
		}
		else {
			response.setContentType("text/html");
//			without setcontenttype(), the output will print index.html page. using the abive line, it makes sure index.html is printed as proper html page
			out.println("email and password didnt matched");
			RequestDispatcher rd=request.getRequestDispatcher("/index.html");
//			rd.forward(request, response);
			rd.include(request, response);
			
		}
			
	}

}
