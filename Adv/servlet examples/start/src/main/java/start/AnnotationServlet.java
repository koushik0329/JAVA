package start;

import jakarta.servlet.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class AnnotationServlet
 */
@WebServlet("/annotation")
public class AnnotationServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public AnnotationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		pw.print("welsome");
		
		// In XML, we have to remove the tags related to annotation in the xml file
		//tags removed are 
//		<servlet>
//	    <description></description>
//	    <display-name>AnnotationServlet</display-name>
//	    <servlet-name>AnnotationServlet</servlet-name>
//	    <servlet-class>start.AnnotationServlet</servlet-class>
//	  </servlet>
//	  <servlet-mapping>
//	    <servlet-name>AnnotationServlet</servlet-name>
//	    <url-pattern>/annotation</url-pattern>
//	  </servlet-mapping>
		
		
	}

}
