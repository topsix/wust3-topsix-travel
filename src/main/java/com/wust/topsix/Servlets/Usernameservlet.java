package com.wust.topsix.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wust.topsix.model.Jsonservlet;

public class Usernameservlet extends HttpServlet {

	
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


