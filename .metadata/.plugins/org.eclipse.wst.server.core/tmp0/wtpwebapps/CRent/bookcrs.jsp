<%@ page import="java.sql.*" %>
<%
String id=request.getParameter("id");



try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","root");
    String qr="update cr set bornb='booked' where id=?";
    PreparedStatement ps=con.prepareStatement(qr);
    ps.setString(1,id);
    
    int i=ps.executeUpdate();
    RequestDispatcher rd=request.getRequestDispatcher("ohome.jsp");
	rd.include(request, response);
    if(i>0)
    {
    	out.println("Classroom Booked");
    }
    else
    {
    	out.println("Classroom Not Booked");
    }
    con.close();
} catch (Exception e) {
	out.println(e);
}

%>