<%@ page import="java.sql.*" %>

<%
try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","root");
	String qr="select * from cr where bornb='booked'";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(qr);
	
		//RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		//rd.include(request, response);

		out.println("<center>");
	out.println("<table border=1px>");
	  out.println("<tr>");
	  out.println("<th>");
	  out.println("ID");
	  out.println("</th>");
	  out.println("<th>");
	  out.println("LOCATION");
	  out.println("</th>");
	  out.println("<th>");
	  out.println("ADDRESS");
	  out.println("</th>");
	  out.println("<th>");
	  out.println("CAPACITY");
	  out.println("</th>");
	  out.println("<th>");
	  out.println("RENT");
	  out.println("</th>");
	  out.println("<th>");
	  out.println("TIME IN");
	  out.println("</th>");
	  out.println("<th>");
	  out.println("TIME OUT");
	  out.println("</th>");
	  out.println("<th>");
	  out.println("OWNER'S NAME");
	  out.println("</th>");
	  out.println("<th>");
	  out.println("CONTACT NO.");
	  out.println("</th>");
	  out.println("<th>");
	  out.println("BOOKED/NOT-BOOKED");
	  out.println("</th>");
	  out.println("</tr>");
	  
	    
	while(rs.next())
	{ 
		
		
		
		
	   out.println("<tr>");
		out.println("<td>");
		out.println(rs.getString("id"));
		out.println("</td>");
		out.println("<td>");
		out.println(rs.getString("location"));
		out.println("</td>");
		out.println("<td>");
		out.println(rs.getString("address"));
		out.println("</td>");
		out.println("<td>");
		out.println(rs.getString("capacity"));
		out.println("</td>");
		out.println("<td>");
		out.println(rs.getString("rent"));
		out.println("</td>");
		out.println("<td>");
		out.println(rs.getString("time_in"));
		out.println("</td>");
		out.println("<td>");
		out.println(rs.getString("time_out"));
		out.println("</td>");
		out.println("<td>");
		out.println(rs.getString("oname"));
		out.println("</td>");
		out.println("<td>");
		out.println(rs.getString("cno"));
		out.println("</td>");
		out.println("<td>");
		out.println(rs.getString("bornb"));
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
