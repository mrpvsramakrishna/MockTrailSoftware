package com.app.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.db.DatabaseUtil;


@WebServlet("/AdminRegistration")
public class AdminRegistrationServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String emailid = request.getParameter("emailid");
		String adminid = request.getParameter("adminid");
		String password = request.getParameter("password");
		String securityqstn = request.getParameter("securityqstn");
		String securityans = request.getParameter("securityans");
		
		HttpSession session = request.getSession();
		try{
			boolean flag = false;
			ResultSet rs = DatabaseUtil.getSQLRows("select * from admindetails where emailid='"+emailid+"' or adminid='"+adminid+"' and status!='D'");
			if(rs.next()){
				String dbemail = rs.getString("emailid");
				String dbadminid = rs.getString("adminid");
				if(emailid.equals(dbemail)){
					session.setAttribute("message", "Email Id already exist. Try Another");
				}if(adminid.equals(dbadminid)){
					session.setAttribute("message", "Admin Id already exist. Try Another");
				}else{
					flag = true;
				}
			}
			else{
				flag = true;
			}
			if(flag){
				
			int count=1;
			Connection con = DatabaseUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into admindetails values(now(),?,?,?,?,?,?,?,?,?,?)");
			ps.setString(count++, firstname);
			ps.setString(count++, lastname);
			ps.setString(count++, dob);
			ps.setString(count++, gender);
			ps.setString(count++, emailid);
			ps.setString(count++, adminid);
			ps.setString(count++, password);
			ps.setString(count++, securityqstn);
			ps.setString(count++, securityans);
			ps.setString(count++, "N");
			
			int dbstatus = ps.executeUpdate();
			if(dbstatus>0){
				 session.setAttribute("message", "Admin Registration Success");
			}else{
				session.setAttribute("message", "Admin Registration Failure. Try Again");	
			}
			
		}else{
			response.sendRedirect("adminregistration.jsp");
		}
		
			response.sendRedirect("adminregistration.jsp");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
