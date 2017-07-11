package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Jsonservlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.UserDAO;

public class Logservlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String username=request.getParameter("username");
//		String password=request.getParameter("password");
//		
//        StringBuilder sb = new StringBuilder();
//    	response.setContentType("text/json");
//    	if(username.equals("Bill")&&password.equals("Gates"))
//    	{
//    		sb.append("success");    	
//        	
//    		response.getWriter().append(sb.toString()); 
//    	}
//    	
//    	else
//    	{
//           sb.append("error");    	
//        	
//    		response.getWriter().append(sb.toString()); 
//    	}
		

		

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserDAO userdao=new UserDAO();
		boolean flag=userdao.findUser(username, password);
		
		System.out.print(flag+username+ password);
		Jsonservlet<String> json=new Jsonservlet<String>();
		
	
    	response.setContentType("text/json");
    	Gson gson=new GsonBuilder().create();
    	if(flag)
    	{
    		
    		json.setStatus("1");
    		json.setMessage("username password right");
    		json.setData("success");
    		String result=gson.toJson(json);
        	
    		response.getWriter().append(result); 
    	}
    	
    	else
    	{
    		json.setStatus("-1");
    		json.setMessage("username or password error");
    		json.setData("error");
            String result=gson.toJson(json);
        	
    		response.getWriter().append(result); 
    	}
    	
	}

}
