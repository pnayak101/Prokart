

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

@WebServlet("/updatepro")
public class updatepro extends HttpServlet {
	private static final long serialVersionUID = 1L;
           public updatepro() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String addr=request.getParameter("addr");
		String loc=request.getParameter("loc");
		String cap=request.getParameter("cap");
		String rent=request.getParameter("rent");
		String tin=request.getParameter("tin");
		String tout=request.getParameter("tout");
		String oname=request.getParameter("oname");
		String cno=request.getParameter("cno");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prokart","root","root");
		    String qr="update product set location=?,capacity=?,rent=?,time_in=?,time_out=?,oname=?,cno=? where address=?";
		    PreparedStatement ps=con.prepareStatement(qr);
		    ps.setString(8,addr);
		    ps.setString(1,loc);
		    ps.setString(2,cap);
		    ps.setString(3,rent);
		    ps.setString(4,tin);
		    ps.setString(5,tout);
		    ps.setString(6,oname);
		    ps.setString(7,cno);
		    int i=ps.executeUpdate();
		    RequestDispatcher rd=request.getRequestDispatcher("editcr.jsp");
			rd.include(request, response);
		    if(i>0)
		    {
		    	out.println("Details Updated");
		    }
		    else
		    {
		    	out.println("Details Not Updated");
		    }
		    con.close();
		} catch (Exception e) {
			out.println(e);
	}
	}
}

