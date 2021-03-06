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
@WebServlet("/delete")
public class DeleteJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			int id=Integer.parseInt(request.getParameter("id"));
			 JobDao dao= new JobDao(DBConnect.getConn());
			 boolean f=dao.deleteJobs(id);
			 HttpSession session=request.getSession();
			 if(f)
			 {
				session.setAttribute("succMsg","job deleted successfully");
				response.sendRedirect("view_job.jsp");
			 }
			 else {
				 session.setAttribute("succMsg","something went wrong");
					response.sendRedirect("view_job.jsp");
			 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}



}
