package url;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SetUrl
 */
public class SetUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetUrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String s2
		String s1=request.getParameter("book1");
		String s2=request.getParameter("book2");
		String s3=request.getParameter("book3");
		PrintWriter pw=response.getWriter();
		pw.println(" <html><body bgcolor=cyan text=blue><center>");
		pw.println("<h1>boks are added to cart</h1>");
		pw.println("<a href=get?book1="+s1+"&book2"+s2+"&book3"+s3+">Next</a>");
		pw.println("</center></html></body>");}

}
