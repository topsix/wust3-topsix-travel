import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servelt extends HttpServlet {

	
	public servelt() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	   StringBuilder sb = new StringBuilder();
    	
    	response.setContentType("text/json");
    	String username=request.getParameter("username")
    	
    	sb.append("tumm &ccf");    	
    	
		response.getWriter().append(sb.toString());
		//response.flushBuffer();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void init() throws ServletException {
		
	}

}
