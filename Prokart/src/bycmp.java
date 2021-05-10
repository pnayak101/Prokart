

import 
java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bycmp")
public class bycmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public bycmp() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String cmp=request.getParameter("cmp");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prokart","root","root");
			String qr="select * from product where cmp=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, cmp);
			ResultSet rs=ps.executeQuery();
			
			RequestDispatcher rd=request.getRequestDispatcher("bycmp.html");
			rd.include(request, response);			
		
			if(rs.next())
			{
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
			  out.println("</tr>");

			
			do
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
				out.println("</tr>");		
				} while(rs.next());
			
			
			out.println("</table>");
			out.println("</center>");
		}
			con.close();
		} catch (Exception e) {
			
			out.println(e);
		}
		
		
	
	}

}

