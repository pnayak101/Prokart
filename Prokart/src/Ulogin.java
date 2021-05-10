

import java.io.IOException;
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

@WebServlet("/Ulogin")
public class Ulogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Ulogin() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prokart","root","root");
			String qr="select * from user where email=? and password=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{ 
				
				request.setAttribute("uemail",email);
				RequestDispatcher rd=request.getRequestDispatcher("user.html");
				rd.include(request, response);
				out.println("Welcome :"+email);
				
				
			}
			else
			{
				out.println("Invalid Email or Password");
			}
			
			
			} catch (Exception e) {
			out.println(e);
		}
		
	}

}
