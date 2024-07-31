package com.register;
import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Register extends HttpServlet {  
	
	public Register() {
		super();
	}
	
	
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("userName");  
String p=request.getParameter("userPass");  
String e=request.getParameter("userEmail");

Member member= new Member(n,p,e);
RegisterDao rdao = new RegisterDao();
String result = rdao.insert(member);
response.getWriter().print(result);  
          

}  
  
}  