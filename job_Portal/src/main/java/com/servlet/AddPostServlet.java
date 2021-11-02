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
import com.entity.jobs;
@WebServlet("/add_job")
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AddPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String title=request.getParameter("title");
			String location=request.getParameter("location");
			String category=request.getParameter("category");
			String status=request.getParameter("status"); 
			String description=request.getParameter("desc");
			 
			
			 
			 jobs j=new jobs();
			 j.setTitle(title);
			 j.setDescription(description);
			 j.setStatus(status);
			 j.setLocation(location);
			 j.setCategory(category);
			 
			 HttpSession session=request.getSession();
			 JobDao dao= new JobDao(DBConnect.getConn());
			 boolean f=dao.addJobs(j);
			 if(f)
			 {
				session.setAttribute("succMsg","job posted successfully");
				response.sendRedirect("add_job.jsp");
			 }
			 else {
				 session.setAttribute("succMsg","something went wrong");
					response.sendRedirect("add_job.jsp");
			 }
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
