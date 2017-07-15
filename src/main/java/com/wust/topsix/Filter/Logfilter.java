package com.wust.topsix.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logfilter implements Filter {

	public Logfilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		// System.out.println(request.getRequestURI());
	   if(request.getRequestURI().equals("/wust3-travel/login.html")||request.getRequestURI().equals("/wust3-travel/register.html")) {
			arg2.doFilter(arg0, arg1);
		}

		else if (request.getSession().getAttribute("username") == null) {
			response.sendRedirect(request.getContextPath() + "/login.html");
		} else {
			arg2.doFilter(arg0, arg1);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
