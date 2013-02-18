
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import java.util.concurrent.atomic.AtomicInteger;

public class MyServerlet extends HttpServlet{
	
	AtomicInteger Id = new AtomicInteger();
	
	private int setSessionID(HttpSession ses){
		    int id = Id.getAndIncrement();
			ses.setAttribute("ID", id);
			return id;
	}
	
	private int getSessionID(HttpSession ses){
		Object id = ses.getAttribute("ID");
		if(id instanceof Integer){
			return (int)id;
		}else{
			return -1;
		}
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)		
			throws IOException,ServletException{
		
		int id;
		String str = "";
		
		try{
			HttpSession ses = req.getSession();
	
			if( ses.isNew()){
				id = setSessionID(ses);
				str = "Welcome new user you id is "+id;
			}else{
				id = getSessionID(ses);
				str = "HI remember you id is " +id;
			}
		}
		catch(IllegalStateException ex){
			System.out.println("Excep"+ex);
		}
		
		resp.setContentType("text/html; charset = utf-8");
		resp.setStatus(HttpServletResponse.SC_OK);
		PrintWriter out = resp.getWriter();
		out.println(PageGEn.getHtml());
		out.println("<h1>"+str+"</h1>");
		out.close();
		
	}

}
