package scl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
public class MyListener implements ServletContextListener {
	Connection con;

    /**
     * Default constructor. 
     */
    public MyListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	try {
    	
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			
		
        
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","koushikkoushik");
			ServletContext sc=sce.getServletContext();
//			ServletContext sc;
	        sc.setAttribute("oracle", con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    }
	
}
