package com.wust.topsix.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wust.topsix.beans.Order;
import com.wust.topsix.dao.OrderDAO;
import com.wust.topsix.model.Jsonservlet;

public class Addorderservlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String) request.getSession()
				.getAttribute("username");
		String sightname = request.getParameter("sightname");
		int price = Integer.parseInt(request.getParameter("price"));

		String status = request.getParameter("status");
		OrderDAO orderdao = new OrderDAO();
		Order order = new Order();
		order.setSightname(sightname);
		order.setStatus(status);
		order.setUsername(username);
		order.setPrice(price);
		boolean flag = orderdao.addOrder(order);
		Jsonservlet<String> json = new Jsonservlet<String>();
		response.setContentType("text/json");
		Gson gson = new GsonBuilder().create();
		if (flag) {
			json.setStatus("1");
			System.out.print("订单生成成功");
		} else {
			json.setStatus("-1");
			System.out.print("订单生成失败");
		}
		String result = gson.toJson(json);

		response.getWriter().append(result);

	}

}
