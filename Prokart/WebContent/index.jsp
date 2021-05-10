
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="theme.css"/>
<meta charset="ISO-8859-1">
<title>PROKART-HOME</title>
</head>
<body>
<marquee><h1>PROKART</h1></marquee>
<marquee><center><h3>Prokart is an e-commerce website connects seller to its customers</h3></center></marquee>
<hr>

<a href="admin.html">Admin SignIn</a><br>
<a href="Ulogin.html">User SignIn</a><br>
<a href="Usup.html">User SignUp</a>
<br>
<br>
<br>
<p>Products Available</p>
</body>
</html>




<%@ page import="java.sql.*" %>
<%

try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prokart","root","root");
			String qr="select * from product";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(qr);
			
			
		      out.println("<center>");
			  out.println("<table border=1px>");
			  out.println("<tr>");
			  out.println("<th>");
			  out.println("ID");
			  out.println("</th>");
			  out.println("<th>");
			  out.println("NAME");
			  out.println("</th>");
			  out.println("<th>");
			  out.println("CATEGORY");
			  out.println("</th>");
			  out.println("<th>");
			  out.println("COMPANY");
			  out.println("</th>");
			  out.println("<th>");
			  out.println("PRICE");
			  out.println("</th>");
			  out.println("<th>");
			  out.println("SELLER");
			  out.println("</th>");
			  out.println("<th>");
			  out.println("UPDATE/DELETE");
			  out.println("</th>");
			  out.println("</tr>");
			  
			    
			while(rs.next())
			{ 
				
				
				
				
			   out.println("<tr>");
				out.println("<td>");
				out.println(rs.getString("id"));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString("name"));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString("cat"));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString("cmp"));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString("price"));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString("seller"));
				out.println("</td>");
				out.println("<td>");
				out.println("<a href=removepro.html>");
				out.println("Remove/");
				out.println("</a>");
				out.println("<a href=updatepro.html>");
				out.println("Update");
				out.println("</a>");
				
				out.println("</td>");
				out.println("</tr>");
				
			}
			
			out.println("</table>");
			out.println("</center>");
			con.close();
		} catch (Exception e) {
			
			out.println(e);
		}
		
		
	
 %>