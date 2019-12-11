package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VotersDaoImpl;
import pojos.Candidate;

/**
 * Servlet implementation class ListCandidates
 */
@WebServlet("/list")
public class ListCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession hs = request.getSession();
		
		VotersDaoImpl vdi = (VotersDaoImpl)hs.getAttribute("voter_dao");
		
		try(PrintWriter pw = response.getWriter()) {
			List<Candidate> candidateList = vdi.getCandidateList();
			
			pw.print("<form action='status' method='get'>");
			
			for(Candidate c  : candidateList)
				pw.print("<input type='radio' name='c_id' value="+c.getId()+">"+c.getName()+" "+c.getPol_party());
			
			pw.print("<input type='submit' value='Vote'>");
			pw.print("</form>");
			
		} catch (Exception e) {
			throw new ServletException();
			//e.printStackTrace();
		}
	}

}
