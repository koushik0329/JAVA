package hsl;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
public class MyListener implements HttpSessionListener {
	int count=0;

    /**
     * Default constructor. 
     */
    public MyListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent hse)  { 
         // TODO Auto-generated method stub
    	count++;
    	HttpSession hs=hse.getSession();
    	hs.setAttribute("users", count);
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent hse)  { 
         // TODO Auto-generated method stub
    	count--;
    	HttpSession hs=hse.getSession();
    	hs.setAttribute("users", count);
    }
	
}
