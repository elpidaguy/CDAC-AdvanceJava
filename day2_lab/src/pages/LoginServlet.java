package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VotersDaoImpl;
import pojos.Voters;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private VotersDaoImpl vdi;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
				vdi = new VotersDaoImpl();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try(PrintWriter pr = response.getWriter())
		{
			Voters v = vdi.authenticateVoter(request.getParameter("em"), request.getParameter("pass"));
			
			if(v != null)
			{
				
				HttpSession hs = request.getSession();
				hs.setAttribute("voter_sess", v);
				hs.setAttribute("voter_dao", vdi);
				
				if(v.isStatus())
				{
					response.sendRedirect("status");
				}
				else
				{
					response.sendRedirect("list");
				}
			}
			
		} catch (Exception e) {
			throw new ServletException("Exception in doGet of LoginServelet",e);
		}
		
	}
	
	
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {	
		try {
			vdi.cleanUp();
		} catch (SQLException e) {
			throw new RuntimeException("err in destroy ", e);
		}
		
	}

}
