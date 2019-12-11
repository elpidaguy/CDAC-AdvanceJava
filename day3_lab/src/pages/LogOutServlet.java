package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDaoImpl;
import dao.CustomerDaoImpl;
import pojos.Book;
import pojos.Customer;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/log_out")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// get existing HS obj from WC
			HttpSession hs = request.getSession();
			// get cust dtls from session scope
			Customer c123 = (Customer) hs.getAttribute("cust_details");
			if (c123 != null) {
				// get DAOs from HS
				BookDaoImpl bookDao = (BookDaoImpl) hs.getAttribute("book_dao");
				CustomerDaoImpl custDao = (CustomerDaoImpl) hs.getAttribute("cust_dao");
				// get cart from HS
				List<Integer> shoppingCart = (List<Integer>) hs.getAttribute("cart");
				pw.print("<h3 align=center> Cart Contents </h3>");
				double sum = 0;
				for (int id : shoppingCart) {
					Book b=bookDao.getBookDetails(id);
					sum += b.getPrice();
					pw.print(b+"<br>");
				}
				pw.print("Cart Price "+sum+"<br>");
				pw.print("Logged out successfully...");
				//clean up of daos
				bookDao.cleanUp();
				custDao.cleanUp();
				// discard session
				hs.invalidate();
			} else
				pw.print("No cookies....: no session tracking!!!");
			pw.print("<h5><a href='login.html'>Visit Again</a>");
		} catch (Exception e) {
			throw new ServletException("err in do-get : " + getClass().getName(), e);

		}
	}

}
