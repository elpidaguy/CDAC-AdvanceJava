package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VotersDaoImpl;
import pojos.Voters;

/**
 * Servlet implementation class Status
 */
@WebServlet("/status")
public class Status extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession hs = request.getSession();
		
		VotersDaoImpl vdi = (VotersDaoImpl)hs.getAttribute("voter_dao");
		
		try(PrintWriter pw = response.getWriter()) {
			Voters v = ((Voters)hs.getAttribute("voter_sess"));
			String res = "";
			if(!v.isStatus())
			{
				res = vdi.incVotesUpdateStatus(Integer.parseInt(request.getParameter("c_id")), ((Voters)hs.getAttribute("voter_sess")).getId());
			}
			
			pw.write("<h2>Hello "+v.getEmail()+", <br> "+res+" <br> Thanks for your valuable time. <br> </h2> <h1> JAI HIND!!!! </h1>");
			
			pw.write("<a href='index.html'>Click here to Relogin</a>");
			hs.invalidate();
			
		} catch (Exception e) {
			throw new ServletException("Error in Status", e);
//			e.printStackTrace();
		}
	}

}
