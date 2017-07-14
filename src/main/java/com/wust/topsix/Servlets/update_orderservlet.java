package com.wust.topsix.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wust.topsix.dao.OrderDAO;

public class update_orderservlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int orderid=Integer.parseInt(request.getParameter("orderid"));
		String status="finish";
		OrderDAO orderdao=new OrderDAO();
		boolean flag=orderdao.updateOrder(orderid, status);
		if(flag)
		{  
				response.sendRedirect(request.getContextPath() + "/order/unfinish.html");
				
		}
		else
		{
			System.out.print("错误");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
