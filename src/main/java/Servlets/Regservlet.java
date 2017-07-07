package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Jsonservlet;

public class Regservlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		Jsonservlet<String> json=new Jsonservlet<String>();
		
	
    	response.setContentType("text/json");
    	Gson gson=new GsonBuilder().create();
    	if(username.equals("Bill"))
    	{
    		json.setStatus("-1");
    		json.setMessage("username exits");
    		json.setData("error");
    		String result=gson.toJson(json);
        	
    		response.getWriter().append(result); 
    	}
    	
    	else
    	{
    		json.setStatus("0");
    		json.setMessage("username success");
    		json.setData("ok");
            String result=gson.toJson(json);
        	
    		response.getWriter().append(result); 
    	}
    	

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		
	}

}
