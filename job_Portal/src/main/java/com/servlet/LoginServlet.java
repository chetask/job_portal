package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.UserDao;
import com.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String em=request.getParameter("email");
			String ps=request.getParameter("password");
			User u=new User();
			HttpSession session=request.getSession();
			if("admin@gmail.com".equals(em)&&"admin@123".equals(ps))
			{
				session.setAttribute("userobj", u);
				u.setRole("admin");
				response.sendRedirect("admin.jsp");
			}
			else {
				UserDao dao=new UserDao(DBConnect.getConn());
				User user=dao.login(em, ps);
				if(user!=null)
				{
					session.setAttribute("userobj", user);
					response.sendRedirect("home.jsp");
				}
				else
				{session.setAttribute("succMsg","invalid email & password");
				response.sendRedirect("login.jsp");
					
				}
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
