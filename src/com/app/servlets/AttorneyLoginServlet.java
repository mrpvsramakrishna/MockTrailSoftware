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


@WebServlet("/AttorneyLogin")
public class AttorneyLoginServlet extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String attorneyid = request.getParameter("attorneyid");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		try{
			
			int count=1;
			Connection con = DatabaseUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from attorneydetails where attorneyid=? order by sysdate desc");
			ps.setString(count++, attorneyid);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				String pwd = rs.getString("password");
				if(pwd.equals(password)){
					session.setAttribute("displayname", rs.getString("firstname")+" "+rs.getString("lastname"));
					 session.setAttribute("attorneyid",attorneyid);
					 response.sendRedirect("attorneyhome.jsp");
				}else{
					session.setAttribute("message", "Invalid Login Details. Try Again");
					response.sendRedirect("login.jsp");
				} 
			}else{
				session.setAttribute("message", "Invalid Login Details. Try Again");
				response.sendRedirect("login.jsp");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
