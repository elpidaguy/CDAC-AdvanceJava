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

import dao.BookDaoImpl;
import pojos.Customer;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// HS
			HttpSession hs = request.getSession();
			// get dao inst from HS
			BookDaoImpl dao = (BookDaoImpl) hs.getAttribute("book_dao");
			// get cust dtls from HS
			Customer c = (Customer) hs.getAttribute("cust_details");
			// get all categories from DAO
			List<String> names = dao.getAllCategories();
			//generate the form dynamically
			pw.print("<h4>Hello , "+c.getEmail()+"</h4>");
			pw.print("<h3 align=center>Category List </h3>");
			pw.print("<form action='category_books'>");
			pw.print("Choose a Category ");
			pw.print("<select name='cat'>");
			for(String s : names)
				pw.print("<option value="+s+">"+s+"</option>");
			pw.print("</select>");
			pw.print("<input type='submit' value='Choose'>");
			pw.print("<input type='submit' value='Show Cart' formaction='show_cart'><br>");
			pw.print("</form>");
			pw.print("<a href='log_out'>Check Out</a>");
		} catch (Exception e) {
			throw new ServletException("err in do-get : " + getClass().getName(), e);
		}
	}

}
