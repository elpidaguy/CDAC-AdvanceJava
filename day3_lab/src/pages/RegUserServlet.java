package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDaoImpl;
import dao.CustomerDaoImpl;
import pojos.Customer;

/**
 * Servlet implementation class RegUserServlet
 */
@WebServlet("/register")
public class RegUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDaoImpl custDao;
	private BookDaoImpl bookDao;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
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
			throw new RuntimeException("err in destroy ", e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
			
		try(PrintWriter pw = response.getWriter()) {
			boolean stat = custDao.signUp(new Customer(request.getParameter("em"),request.getParameter("pass"),Double.parseDouble(request.getParameter("amount")),Date.valueOf(LocalDate.now())));
			System.out.println(stat);
			if(!stat)
			{
				pw.print("<h4> Something went wrong , Pls  <a href='index.html'>Retry</a></h4>");
			}
			else
			{
				pw.print("<h4> Registered Successfully , Pls  <a href='index.html'>Login</a></h4>");
			}
		} catch (Exception e) {
			throw new ServletException();
		}
		
	}

}
