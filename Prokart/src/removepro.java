

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

@WebServlet("/removepro")
public class removepro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public removepro() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	String id=request.getParameter("id");
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prokart","root","root");
		String qr="delete from product where id=?";
		PreparedStatement ps=con.prepareStatement(qr);
		ps.setString(1,id);
		int i=ps.executeUpdate();
		RequestDispatcher rd=request.getRequestDispatcher("removepro.html");
		rd.include(request, response);
		if(i>0)
		{
			out.println("REMOVED");
		}
		else
		{
			out.println("NOT REMOVED");
		}
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	
	
	
	}

}
