package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Jsonservlet;
import beans.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.UserDAO;

public class Updateservlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		UserDAO userdao=new UserDAO();
		boolean flag=userdao.updateUser(username, password, phone);
		
		
		
		Jsonservlet<String> json=new Jsonservlet<String>();
		
	
    	response.setContentType("text/json");
    	Gson gson=new GsonBuilder().create();
    	
    	if(flag)
    	{
    		json.setStatus("1");
    		json.setMessage("success");
    		json.setData("ok");
    		
    		//System.out.print(user.getUsername()+"你是"+user.getPassword());
    		
    		String result=gson.toJson(json);
        	
    		response.getWriter().append(result); 
    	}
    	
    	 
	}

}
