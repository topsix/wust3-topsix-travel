package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Jsonservlet;
import beans.Sight;
import beans.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.SightDAO;
import dao.UserDAO;

public class Sightservlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      // String sightname=request.getParameter("sightname");
      
		String sightname=(String) request.getSession().getAttribute("sightname");
		 System.out.print(sightname);
		SightDAO sightdao=new SightDAO();
		Sight sight=sightdao.find_Sight(sightname);
	
		System.out.print(sight.getPlace());
		
		Jsonservlet<String> json=new Jsonservlet<String>();
		
	
    	response.setContentType("text/json");
    	Gson gson=new GsonBuilder().create();
    	
    	if(sight!=null)
    	{
    		json.setStatus("1");
    		json.setMessage("success");
    		json.setData("ok");
    		json.setSight(sight);
    		
    		
	}
    	else
    	{
    		json.setStatus("-1");
    	}

		String result=gson.toJson(json);
    	System.out.print(result);
		response.getWriter().append(result); 
    	
	}
}


