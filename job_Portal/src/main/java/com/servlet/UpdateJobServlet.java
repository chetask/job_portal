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
@WebServlet("/update")
public class UpdateJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateJobServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("title");
		String location=request.getParameter("location");
		String category=request.getParameter("category");
		String status=request.getParameter("status"); 
		String description=request.getParameter("desc");
		
		 jobs j=new jobs();
		 j.setId(id);
		 j.setTitle(title);
		 j.setDescription(description);
		 j.setStatus(status);
		 j.setLocation(location);
		 j.setCategory(category);
		 
		 HttpSession session=request.getSession();
		 JobDao dao= new JobDao(DBConnect.getConn());
		 boolean f=dao.updateJobs(j);
		 if(f)
		 {
			session.setAttribute("succMsg","job updated successfully");
			response.sendRedirect("view_job.jsp");
		 }
		 else {
			 session.setAttribute("succMsg","something went wrong");
				response.sendRedirect("view_job.jsp");
		 }
		
	}
	}


