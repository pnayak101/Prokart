

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/sall")
public class sall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public sall() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prokart","root","root");
			String qr="select * from product";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(qr);
			
				RequestDispatcher rd=request.getRequestDispatcher("display.html");
				rd.include(request, response);
	
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
		
		
	
	}

}
