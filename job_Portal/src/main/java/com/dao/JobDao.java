package com.dao;
import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.entity.jobs;

public class JobDao {
	private Connection conn;

	public JobDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addJobs(jobs j) {
		boolean f = false;
		try {
			
			String sql = "insert into jobs(title,discription,category,status,location) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getCategory());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getLocation());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<jobs>getAllJobs()
	{
		List<jobs> list=new ArrayList<jobs>();
		jobs j=null;
		try {
			String sql="select * from jobs order by id desc";
			PreparedStatement statement=conn.prepareStatement(sql);
			ResultSet rs=statement.executeQuery();
			while(rs.next())
			{
				j=new jobs();
				 j.setId(rs.getInt(1));
				 j.setTitle(rs.getString(2));
				 j.setDescription(rs.getString(3));
				 j.setCategory(rs.getString(4));
				 j.setStatus (rs.getString(5));
				 j.setLocation(rs.getString(6));
				 j.setPdate(rs.getTimestamp(7)+"");
				 list.add(j);
			}
		}
		catch(Exception e)
		{
			
		}
		return list;
	}
	
	public jobs getJobById(int id){
	
	jobs j=new jobs();
	try {
		String sql="select * from jobs where id=?";
		PreparedStatement statement=conn.prepareStatement(sql);
		statement.setInt(1,id);
		ResultSet rs=statement.executeQuery();
		while(rs.next())
		{
			
			 j.setId(rs.getInt(1));
			 j.setTitle(rs.getString(2));
			 j.setDescription(rs.getString(3));
			 j.setCategory(rs.getString(4));
			 j.setStatus (rs.getString(5));
			 j.setLocation(rs.getString(6));
			 j.setPdate(rs.getTimestamp(7)+"");
			 
		}
	}
	catch(Exception e)
	{
		
	}
	return j;
}
	public boolean updateJobs(jobs j) {
		boolean f = false;
		try {
			
			String quary="update jobs set title=?,discription=?,category=?,status=?,location=? where id=?";
			PreparedStatement ps = conn.prepareStatement(quary);
			ps.setString(1,j.getTitle());
			ps.setString(2,j.getDescription());
			ps.setString(3,j.getCategory());
			ps.setString(4,j.getStatus());
			ps.setString(5,j.getLocation());
			ps.setInt(6,j.getId());
			System.out.println(ps);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public boolean deleteJobs( int id) {
		boolean f=false;
		String quary="delete from jobs where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(quary);
			ps.setInt(1,id);
			int i=ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return f;
		
	}
	public List<jobs> getAllJobsForUser()
	{List<jobs> list=new ArrayList<jobs>();
	jobs j=null;
	try {
		String sql="select * from jobs where status=? order by id desc";
		PreparedStatement statement=conn.prepareStatement(sql);
		statement.setString(1,"Active");
		ResultSet rs=statement.executeQuery();
		while(rs.next())
		{
			j=new jobs();
			 j.setId(rs.getInt(1));
			 j.setTitle(rs.getString(2));
			 j.setDescription(rs.getString(3));
			 j.setCategory(rs.getString(4));
			 j.setStatus (rs.getString(5));
			 j.setLocation(rs.getString(6));
			 j.setPdate(rs.getTimestamp(7)+"");
			 list.add(j);
		}
	}
	catch(Exception e)
	{
		
	}
	return list;
		
	}
	public List<jobs>getJobsOrLocationAndCate(String category,String location)
	{
		List<jobs> list=new ArrayList<jobs>();
		jobs j=null;
		try {
			String sql="select * from jobs  where category=? or location=? order by id desc";
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(1,category);
			statement.setString(2,location);
			ResultSet rs=statement.executeQuery();
			while(rs.next())
			{
				j=new jobs();
				 j.setId(rs.getInt(1));
				 j.setTitle(rs.getString(2));
				 j.setDescription(rs.getString(3));
				 j.setCategory(rs.getString(4));
				 j.setStatus (rs.getString(5));
				 j.setLocation(rs.getString(6));
				 j.setPdate(rs.getTimestamp(7)+"");
				 list.add(j);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public List<jobs>getJobsAndLocationAndCate(String category,String location)
	{
		List<jobs> list=new ArrayList<jobs>();
		jobs j=null;
		try {
			String sql="select * from jobs  where category=? and location=? order by id desc";
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(1,category);
			statement.setString(2,location);
			ResultSet rs=statement.executeQuery();
			while(rs.next())
			{
				j=new jobs();
				 j.setId(rs.getInt(1));
				 j.setTitle(rs.getString(2));
				 j.setDescription(rs.getString(3));
				 j.setCategory(rs.getString(4));
				 j.setStatus (rs.getString(5));
				 j.setLocation(rs.getString(6));
				 j.setPdate(rs.getTimestamp(7)+"");
				 list.add(j);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
}

