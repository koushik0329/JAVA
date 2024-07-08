package start;

import jakarta.servlet.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.FileInputStream;
import java.io.*;

/**
 * Servlet implementation class Picture
 */
public class Picture extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Picture() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletOutputStream s=response.getOutputStream();
		//byte stream is created from server to  browser
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Downloads\\sample.jpeg");
		//opens a file for reading
		int n=fis.available();//returns file size
		byte[] b=new byte[n];//allocates memory in RAM, as the file size
		fis.read(b);//read image from file
		s.write(b);//pass image to browser
		
		//from harddisk to RAM we use fileInputstream
		//from RAM to browser we use Servletoutputstream
		//using servletoutputstream we can pass bytes(pictures, gif, text etc). If we pass text, it will read as ASCII
		//using printwriter we pass characters. so better to prefer this to pass characters t browser
	}

}
