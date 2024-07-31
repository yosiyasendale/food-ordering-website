package com.register;
import java.io.IOException;  
	import java.io.PrintWriter;  
	import javax.servlet.RequestDispatcher;  
	import javax.servlet.ServletException;  
	import javax.servlet.http.HttpServlet;  
	import javax.servlet.http.HttpServletRequest;  
	import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class login extends HttpServlet {  
	static String name;
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String username = request.getParameter("username");  
	    String password = request.getParameter("Password");  
	    
	    name = username;   
	    if(LoginDao.validate(username, password)){ 
	        RequestDispatcher rd=request.getRequestDispatcher("home.html");  
	        HttpSession session = request.getSession();
	        session.setAttribute("user",username);
	        session.setMaxInactiveInterval(1800);
	        rd.forward(request,response);  
	    }  
	    else{  
	    	

	    	String errorMessage = "Invalid username or password";
	         out.println( errorMessage);
	    RequestDispatcher rd = request.getRequestDispatcher("registration.html");
 
	       rd.include(request,response);  
	    }  
	          
	    out.close();  
	    }  
	}  
