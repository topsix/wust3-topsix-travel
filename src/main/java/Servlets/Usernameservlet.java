package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Jsonservlet;

public class Usernameservlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Jsonservlet<String> json=new Jsonservlet<String>();
    	response.setContentType("text/json");
    	Gson gson=new GsonBuilder().create();
    	String username=(String) request.getSession().getAttribute("username");
    	if(username!=null)
    	{
    		json.setStatus("1");
    		json.setMessage(" get username success");
    		json.setData(username);
    		//request.getSession().setAttribute("username", username);
    		String result=gson.toJson(json);
        	
    		response.getWriter().append(result); 
    	}
    	}
    	
	}


