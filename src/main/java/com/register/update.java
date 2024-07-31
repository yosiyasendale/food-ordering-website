package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class update extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	   String oldname = login.name;
	   response.setContentType("text/html");  
	   String nam=request.getParameter("na"); 
       String pas= request.getParameter("pa");
       String ema= request.getParameter("em");
       try {
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection(  
			       "jdbc:mysql://localhost:3306/userdb","root","6701");  
			       PreparedStatement ps=con.prepareStatement(  
			       "update member set uname=?, password=?, email=? where uname=?");  
			       ps.setString(1,nam);
			       ps.setString(2,pas);
			       ps.setString(3,ema);
			       ps.setString(4,oldname);
			       int rs=ps.executeUpdate();
			       RequestDispatcher rd = request.getRequestDispatcher("home.html");
			       rd.forward(request, response);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
}
}