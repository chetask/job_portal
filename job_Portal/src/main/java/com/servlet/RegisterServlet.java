package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.JobDao;
import com.dao.UserDao;
import com.entity.User;

@WebServlet("/add_user")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name=request.getParameter("name");
			String qua=request.getParameter("qua");
			String email=request.getParameter("em");
			String ps=request.getParameter("ps");
			UserDao dao=new UserDao(DBConnect.getConn());
			 User u =new User(name,email,ps,qua,"user");
			 boolean f=dao.adduser(u);
			 HttpSession session=request.getSession();
			 if(f)
			 {
				session.setAttribute("succMsg","register successfully");
				response.sendRedirect("signup.jsp");
			 }
			 else {
				 session.setAttribute("succMsg","something went wrong");
					response.sendRedirect("signup.jsp");
			 }
		}
		catch(Exception e)
		{ e.printStackTrace();	}

}
}

