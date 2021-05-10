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

@WebServlet("/Addpro")
public class Addpro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Addpro() {
        super();
        	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	String id=request.getParameter("id");
	String name=request.getParameter("name");
	String cat=request.getParameter("cat");
	String cmp=request.getParameter("cmp");
	String price=request.getParameter("price");
	String seller=request.getParameter("seller");
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prokart","root","root");
		String qr="insert into product values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(qr);
		ps.setString(1, id);
		ps.setString(2, name);
		ps.setString(3, cat);
		ps.setString(4, cmp);
		ps.setString(5, price);
		ps.setString(6, seller);
		int i=ps.executeUpdate();
		
			RequestDispatcher rd=request.getRequestDispatcher("addpro.html");
			rd.include(request, response);
	
		if(i>0)
		{
			out.println("added");
		}
		else{
			out.println("not added");
		}
		con.close();
	} catch(Exception e)
	{
		out.println(e);
	}
	}

}
