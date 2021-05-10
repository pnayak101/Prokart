

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usup")
public class usup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public usup() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pwd=request.getParameter("password");
		String contact=request.getParameter("contact");
		String addr=request.getParameter("address");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prokart","root","root");
			String qr="insert into user values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, pwd);
			ps.setString(4, contact);
			ps.setString(5, addr);
			int i=ps.executeUpdate();
				RequestDispatcher rd=request.getRequestDispatcher("Usup.html");
				rd.include(request,response);
			if(i>0)
			{
				out.println("User SignUp Sucessfull");
				
			}
			else
			{
				out.println("SignUp Not Sucessfull");
			}
			
		} catch (Exception e) {
			
			out.println(e);
		}
		
		
	
	}
	

}
