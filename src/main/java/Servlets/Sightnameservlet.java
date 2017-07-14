package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sightnameservlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         String sightname=request.getParameter("sightname");
         if(sightname!=null)
         {
        	 request.getSession().setAttribute("sightname", sightname);
        	 response.sendRedirect(request.getContextPath() + "/pages/ticket1.html");
         }
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    this.doGet(request, response);
		
	}

}
