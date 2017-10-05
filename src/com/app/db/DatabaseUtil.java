package com.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUtil {
	
	public static Connection getConnection() {
		Connection con = null;
		try {

		 		
			 Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mocktrail", "root", ""); 

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	 
	public static int insertOrUpdateRow(String sql) throws Exception {
	 	Connection con = getConnection();
		Statement statement = con.createStatement();
		int i = statement.executeUpdate(sql);
		return (i == 0) ? 0 : i;
	}
	public static PreparedStatement getSelectedRows(String sql) throws Exception
	{
		Connection con = getConnection();
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		return preparedstatement;
	}
	
	public static ResultSet getSQLRows(String sql) throws Exception {
		Connection con = getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return (rs == null) ? null : rs;
	}
}
