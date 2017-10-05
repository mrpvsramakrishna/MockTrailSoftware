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


@WebServlet("/registationServlet")
public class RegistrationServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String emailid = request.getParameter("emailid");
		String attorneyid = request.getParameter("attorneyid");
		String password = request.getParameter("password");
		String securityqstn = request.getParameter("securityqstn");
		String securityans = request.getParameter("securityans");
		
		HttpSession session = request.getSession();
		try{
			boolean flag = false;
			ResultSet rs = DatabaseUtil.getSQLRows("select * from attorneydetails where emailid='"+emailid+"' or attorneyid='"+attorneyid+"' and status!='D'");
			if(rs.next()){
				String dbemail = rs.getString("emailid");
				String dbattorneyid = rs.getString("attorneyid");
				if(emailid.equals(dbemail)){
					session.setAttribute("message", "Email Id already exist. Try Another");
				}if(attorneyid.equals(dbattorneyid)){
					session.setAttribute("message", "Attorney Id already exist. Try Another");
				}else{
					flag = true;
				}
			}else{
				flag = true;
			}
			if(flag){
			
			int count=1;
			Connection con = DatabaseUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into attorneydetails values(now(),?,?,?,?,?,?,?,?,?,?)");
			ps.setString(count++, firstname);
			ps.setString(count++, lastname);
			ps.setString(count++, dob);
			ps.setString(count++, gender);
			ps.setString(count++, emailid);
			ps.setString(count++, attorneyid);
			ps.setString(count++, password);
			ps.setString(count++, securityqstn);
			ps.setString(count++, securityans);
			ps.setString(count++, "N");
			
			int dbstatus = ps.executeUpdate();
			if(dbstatus>0){
				 session.setAttribute("message", "Attorney Registration Success");
			}else{
				session.setAttribute("message", "Attorney Registration Failure. Try Again");	
			}
			response.sendRedirect("registration.jsp");
			}else{
				response.sendRedirect("registration.jsp");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
