package servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import beans.User;

public class RegServlet extends HttpServlet {

	
	 
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String path = request.getContextPath(); //��ȡ����·��
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		UserDAO userdao=new UserDAO();
		if( userdao.isUsernameExists(username) ){
			request.getSession().setAttribute("err", "�û����Ѵ���");
			response.sendRedirect(path+"/index.jsp");
			}
			else{
			boolean flag=userdao.addUser(user);
			if(flag){
			request.getSession().setAttribute("username", username);
			response.sendRedirect(path+"/welcome.jsp");
			}
			else{
			request.getSession().setAttribute("err", "ע��ʧ��");
			response.sendRedirect(path+"/register.jsp");
			}
			}
			} // end service
		
		
	}


