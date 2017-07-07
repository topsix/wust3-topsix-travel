package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logservlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
        StringBuilder sb = new StringBuilder();
    	response.setContentType("text/json");
    	if(username.equals("Bill")&&password.equals("Gates"))
    	{
    		sb.append("success");    	
        	
    		response.getWriter().append(sb.toString()); 
    	}
    	
    	else
    	{
           sb.append("error");    	
        	
    		response.getWriter().append(sb.toString()); 
    	}

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
