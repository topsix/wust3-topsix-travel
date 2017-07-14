package com.wust.topsix.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wust.topsix.beans.User;
import com.wust.topsix.dao.UserDAO;
import com.wust.topsix.model.Jsonservlet;

public class UserServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=(String) request.getSession().getAttribute("username");
		UserDAO userdao=new UserDAO();
		User user=userdao.find_User(username);
		//System.out.print(user.getUsername()+"你是");
		
		
		Jsonservlet<String> json=new Jsonservlet<String>();
		
	
    	response.setContentType("text/json");
    	Gson gson=new GsonBuilder().create();
    	
    	if(user!=null)
    	{
    		json.setStatus("1");
    		json.setMessage("success");
    		json.setData("ok");
    		json.setUser(user);
    		//System.out.print(user.getUsername()+"你是"+user.getPassword());
    		
    		String result=gson.toJson(json);
        	
    		response.getWriter().append(result); 
    	}
    	
	}

}
