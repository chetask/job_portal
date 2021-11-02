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
@WebServlet("/Update_profile")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String qua=request.getParameter("qua");
			String email=request.getParameter("em");
			String ps=request.getParameter("ps");
			
			UserDao dao=new UserDao(DBConnect.getConn());
			 User u =new User();
			 u.setId(id);
			 u.setName(name);
			 u.setQualification(qua);
			 u.setPassword(ps);
			 u.setEmail(email);
			 boolean f=dao.updateUser(u);
			 HttpSession session=request.getSession();
			 if(f)
			 {
				session.setAttribute("succMsg","profile update successfully");
				response.sendRedirect("home.jsp");
			 }
			 else {
				 session.setAttribute("succMsg","something went wrong");
					response.sendRedirect("home.jsp");
			 }
		}
		catch(Exception e)
		{ e.printStackTrace();	}
	}

}
