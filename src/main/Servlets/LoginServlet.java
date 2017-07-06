package servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

public class LoginServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String path = request.getContextPath();
		UserDAO userdao=new UserDAO();
		boolean flag=userdao.findUser(username, password);
		if( flag ) {
			boolean flag1=userdao.usernameisadminstrator(username);
		request.getSession().setAttribute("username", username);
		request.getSession().setAttribute("password", password);
		
		if(flag1)
		{
			
			response.sendRedirect(path+"/table.jsp");
		}
		else
		   response.sendRedirect(path+"/welcome.jsp");
		}
		else{
		request.getSession().setAttribute("err", "用户名或密码不正确！");
		response.sendRedirect(path+"/login.jsp");
		}
		
	}

}
