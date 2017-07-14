package com.wust.topsix.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wust.topsix.beans.Order;
import com.wust.topsix.dao.OrderDAO;
import com.wust.topsix.model.Json_order;
import com.wust.topsix.model.Jsonservlet;

public class Allorderservlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username=(String) request.getSession().getAttribute("username");
		String status=request.getParameter("status"); 
		System.out.print(status);
		int count=0;
		OrderDAO orderdao=new OrderDAO();	
		ArrayList<Order>list=orderdao.allorder(status, username);
		Json_order<String> json=new Json_order<String>();
    	response.setContentType("text/json");
    	Gson gson=new GsonBuilder().create();
         for(Order ll : list)

          { 
          	count++;

          }

          int draw;
          if (request.getParameter("draw") == null)

  			draw = 1;

  		else{

  			draw = Integer.parseInt(request.getParameter("draw"));

  		}

          json.setDraw(draw);

          json.setRecordsTotal(count);

          json.setRecordFiltered(2);

          json.setData(list);

  	    String info=gson.toJson(json);

  	    response.getWriter().append(info);		

  		System.out.print(info);

          
			
		}
		
	
	}


