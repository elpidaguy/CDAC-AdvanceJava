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
import pojos.Book;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/category_books")
public class CategoryDetailsServlet extends HttpServlet {
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
			// get cat name from req param
			String catName = request.getParameter("cat");
			// get all bks by a specific category
			List<Book> bks = dao.getBooksByCategory(catName);
			pw.print("<h3 align=center>Books By " + catName + " category " + "</h3>");
			// generate the form dynamically
			pw.print("<form action='add_to_cart'>");
			for(Book b : bks)
				pw.print("<input type='checkbox' name='cat_id' value="+b.getId()+">"+b+"<br>");
			pw.print("<input type='submit' value='Add To Cart'>");
			pw.print("</form>");
		} catch (Exception e) {
			throw new ServletException("err in do-get : " + getClass().getName(), e);
		}
	}

}
