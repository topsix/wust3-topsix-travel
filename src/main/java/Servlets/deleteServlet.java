package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;

public class deleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
   
		int orderid=Integer.parseInt(request.getParameter("orderid"));
		String status=request.getParameter("status");
		OrderDAO orderdao=new OrderDAO();
		boolean flag=orderdao.deleteOrder(orderid);
		if(flag)
		{  
			if(status.equals("finish"))
			response.sendRedirect(request.getContextPath() + "/order/finish.html");
			else
				response.sendRedirect(request.getContextPath() + "/order/unfinish.html");
				
		}
		else
		{
			System.out.print("错误");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
