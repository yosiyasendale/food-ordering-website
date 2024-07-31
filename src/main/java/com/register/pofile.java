package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pofile extends HttpServlet {
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
	    response.setContentType("text/html");  
	   String aa=request.getParameter("t"); 
       String un= login.name;
       try {
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection(  
			       "jdbc:mysql://localhost:3306/userdb","root","6701");  
			       PreparedStatement ps=con.prepareStatement(  
			       "select *from member where uname=?");  
			       ps.setString(1,un);   
			       ResultSet rs=ps.executeQuery();
			       rs.next();
			       //htmlTable += "<tr><th>Name</th><th>Age</th></tr>"; 
			       
			       String nme = rs.getString("uname");
			       String pass = rs.getString("password");
			       String email = rs.getString("email");
			       PrintWriter out = response.getWriter();
			       
			       out.println("<html>");
			       out.println("<head>");
			       out.println("<link rel=\"stylesheet\" href=\"NewFile.css\">");
			       out.println("<link rel=\"stylesheet\" href=\"startstyle.css\">");
			       out.println("<link rel=\"stylesheet\" href=\"homestyle.css\">");
			       out.println("</head>");
			       out.println("<form action=\"update\" method=\"post\" class=\"form-box\">");
			       out.println("name: <input type=\"text\" name=\"na\"  value=\""+nme+"\" class=\"input-field\" ><br>");
			       out.println("password: <input type=\"text\" name=\"pa\" value=\""+pass+"\" class=\"input-field\"><br>");
			       out.println("email: <input type=\"text\" name=\"em\" value=\""+email+"\" class=\"input-field\" ><br>");
			       out.println("<input type=\"submit\" value=\"Update\" class=\"submit-btn\" ><br>");
			       out.println("<a href=\"start.html\">Logout</a>");
			       //out.println("<style>");
			       //out.println("profile {");
			       //out.println("background");
			      
			       out.println("</form");
			       out.println("</html");
			       
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		response.getWriter().println(un);
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
      
	 
}
}



