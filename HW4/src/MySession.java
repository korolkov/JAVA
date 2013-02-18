
 
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class MySession{
	
	public static void main(String[] args) throws Exception
	{
		Server server = new Server(8080);
		ServletContextHandler hand = new ServletContextHandler(ServletContextHandler.SESSIONS);
		hand.addServlet("MyServerlet", "/*");
		server.setHandler(hand);
		
		server.start();
		server.join();
		
	}

}
