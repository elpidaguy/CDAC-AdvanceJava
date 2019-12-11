package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Customer;

/**
 * Servlet implementation class DetailsServlet
 */
@WebServlet("/details")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h4>Login Successful</h4>");
			// get existing HS obj from WC
			HttpSession hs123 = request.getSession();
			System.out.println("from 2nd page " + hs123.isNew());
			System.out.println("Session ID " + hs123.getId());
			// get cust dtls from session scope
			Customer c123 = (Customer) hs123.getAttribute("cust_details");
			if (c123 != null) {
				pw.print("Hello , " + c123.getEmail() + "<br>");
				pw.print("Details " + c123);
			} else
				pw.print("No cookies : no session tracking");
			pw.print("<h5><a href='logout'>Log Me Out</a>");

		}
	}

}
