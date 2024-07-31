package com.register;

import java.sql.*;  

public class LoginDao {  
public static boolean validate(String uname,String password){  
boolean status=false;  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/userdb","root","6701");  
      
PreparedStatement ps=con.prepareStatement(  
"select *from member where uname=? and password=?");  
ps.setString(1,uname);  
ps.setString(2,password);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}  
