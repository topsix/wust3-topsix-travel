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

public class Regservlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("passwd");
		String phone = request.getParameter("phone");

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		UserDAO userdao = new UserDAO();

		Jsonservlet<String> json = new Jsonservlet<String>();

		response.setContentType("text/json");
		Gson gson = new GsonBuilder().create();
		if (userdao.isUsernameExists(username)) {
			json.setStatus("-1");
			json.setMessage("username exits");
			json.setData("error");
			String result = gson.toJson(json);

			response.getWriter().append(result);
		}

		else {
			boolean flag = userdao.addUser(user);
			System.out.print(flag + username + password);
			if (flag) {
				json.setStatus("0");
				json.setMessage("username success");
				json.setData("ok");
				String result = gson.toJson(json);

				response.getWriter().append(result);

			}

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
