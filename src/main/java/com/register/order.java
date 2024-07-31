package com.register;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
public class order extends HttpServlet {
	public order() {
		super();
	}
	
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException { 
	HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("user") != null) {
		request.getRequestDispatcher("home.html").forward(request, response);
	}else {
		response.sendRedirect("registration.html");
	}
	
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("name");  
String e=request.getParameter("email");  
String a=request.getParameter("address");
String j=request.getParameter("foods");
String i = request.getParameter("quantity");

memberord member= new memberord(n,e,a,j,i);
orderDao rdao = new orderDao();
String result = rdao.insert(member);
response.getWriter().print(result);  

          

}  
}
