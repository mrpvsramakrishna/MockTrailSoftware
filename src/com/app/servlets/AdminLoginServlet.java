package com.app.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.db.DatabaseUtil;


@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String adminid = request.getParameter("adminid");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		try{
			
			int count=1;
			Connection con = DatabaseUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from admindetails where adminid=? order by sysdate desc limit 1");
			ps.setString(count++, adminid);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				String status = rs.getString("status");
				if("D".equals(status)) {
					session.setAttribute("message", "Invalid Login Details. Try Again");
					response.sendRedirect("adminlogin.jsp");
				}else {
				String pwd = rs.getString("password");
				if(pwd.equals(password)){
				session.setAttribute("displayname", rs.getString(1));
				 session.setAttribute("adminid",adminid);
				 session.setAttribute("logintype","admin");

					 response.sendRedirect("adminhome.jsp");
				 
				 
				}else{
					session.setAttribute("message", "Invalid Login Details. Try Again");
					response.sendRedirect("adminlogin.jsp");
				}
				}
				 
			}else{
			session.setAttribute("message", "Invalid Login Details. Try Again");
			response.sendRedirect("adminlogin.jsp");
		}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
