package pages;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/add_to_cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get selected book ids from rq params
		String[] selectedBookIds = request.getParameterValues("cat_id");
		// get HS
		HttpSession hs=request.getSession();
		//get cart from HS
		List<Integer> shoppingCart=(List<Integer>)hs.getAttribute("cart");
	    //populate cart n redirect clnt to categories page
		for(String s : selectedBookIds)
			shoppingCart.add(Integer.parseInt(s));
		//redirect
		response.sendRedirect("categories");
	}

}
