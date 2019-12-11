package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDaoImpl;
import dao.CustomerDaoImpl;
import pojos.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/validate")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDaoImpl custDao;
	private BookDaoImpl bookDao;

	public void init() throws ServletException {
		try {
			custDao = new CustomerDaoImpl();
			bookDao = new BookDaoImpl();
		} catch (Exception e) {
			throw new ServletException("err in init :" + getClass().getName(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			bookDao.cleanUp();
			custDao.cleanUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("err in destroy ", e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set cont type
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// invoke dao's method for authentication
			Customer c = custDao.signIn(request.getParameter("em"), request.getParameter("pass"));
			// invalid login -- null
			if (c == null)
				pw.print("<h4> Invalid Login , Pls  <a href='login.html'>Retry</a></h4>");
			else {
				// get NEW HS obj from WC
				HttpSession hs = request.getSession();
				System.out.println("from 1st page " + hs.isNew());
				System.out.println("Session ID " + hs.getId());
				// save validated cust dtls under session scope
				hs.setAttribute("cust_details", c);
				// add daos under session scope
				hs.setAttribute("cust_dao", custDao);
				hs.setAttribute("book_dao", bookDao);
				// create an empty cart & add it to the session scope
				hs.setAttribute("cart", new ArrayList<Integer>());
				// redirect the clnt to NEXT page , in the NEXT request
				response.sendRedirect("categories");
			}
		} catch (Exception e) {
			throw new ServletException("err in do-get : " + getClass().getName(), e);
		}
	}

}
