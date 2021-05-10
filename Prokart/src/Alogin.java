

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Alogin")
public class Alogin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public Alogin()
    {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	PrintWriter out=response.getWriter();
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	
	RequestDispatcher rd=request.getRequestDispatcher("admin.html");
	rd.include(request, response);
	
	if(id.equals("admin")&&pwd.equals("12345"))
	{ response.sendRedirect("adminhome.html");
	}
	else
	{ out.println("Invalid Id or Password");
	}
	
	}

}
