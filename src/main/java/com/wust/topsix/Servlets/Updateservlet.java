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

public class Updateservlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Jsonservlet<String> json = new Jsonservlet<String>();
		response.setContentType("text/json");
		Gson gson = new GsonBuilder().create();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password1 = request.getParameter("password1");
		UserDAO userdao = new UserDAO();
		boolean flag1 = userdao.findUser(username, password);
		if (flag1) {
			boolean flag = userdao.updateUser(username, password1);
			if (flag) {

				json.setStatus("1");
				json.setMessage("success");
				json.setData("ok");
				String result = gson.toJson(json);

				response.getWriter().append(result);
			} else {
				json.setStatus("0");
				json.setMessage("update failed");
				json.setData("error1");
				String result = gson.toJson(json);

				response.getWriter().append(result);
			}

		} else {
			json.setStatus("-1");
			json.setMessage("input error password");
			json.setData("error");
			String result = gson.toJson(json);

			response.getWriter().append(result);
		}

	}

}
