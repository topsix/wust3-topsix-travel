package Servlets;

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

import beans.Order;
import dao.OrderDAO;

public class Allorderservlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=(String) request.getSession().getAttribute("username");
		String status=request.getParameter("status"); 
		OrderDAO orderdao=new OrderDAO();
		ArrayList<Order> list=new ArrayList<Order>();
		ResultSet rs=orderdao.allorder(status, username);
		
		if(rs!=null)
		{
			try {
				while(rs.next())
				{
					Order order=new Order();
					order.setOrderid(Integer.parseInt(rs.getString("orderid")));
					order.setStatus(rs.getString("status"));
					order.setUsername(rs.getString("username"));
					order.setSightname(rs.getString("sightname"));
					order.setPrice(Integer.parseInt(rs.getString("price")));
					//System.out.println("moviename:"+rs.getString("moviename"));
					list.add(order);
					
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		Gson gb = new Gson();
		String result=gb.toJson(list);
		response.getWriter().append(result);
	}

}
