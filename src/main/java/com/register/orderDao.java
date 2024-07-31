package com.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class orderDao  {
	
	private String dburl="jdbc:mysql://localhost:3306/userdb";
	private String dbuname="root";
	private String dbpassword="6701";
	private String dbdriver="com.mysql.jdbc.Driver";
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		
		Connection con=null;
		try {
			con=DriverManager.getConnection(dburl, dbuname, dbpassword);
		}catch(SQLException e) {e.printStackTrace();}
		return con;
	}
	public String insert(memberord member) {
		loadDriver(dbdriver);
		Connection con=getConnection();
		String result="your order is successfully sent! we will deliver to you within 1 hour thank you!";
		String sql ="insert into userdb.orderinfo values(?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, member.getuname());
			ps.setString(2, member.getemail());
			ps.setString(3, member.getquantity());
			ps.setString(4, member.getfoodname());
			ps.setString(5, member.getaddress());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=" not entered successfully";
		}
		return result;
		
	}
}
