

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BooksDao;
import model.Books;

/**
 * Servlet implementation class AddBooks
 */

@WebServlet("AddBooks")
public class AddBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String author = request.getParameter("author");
		String publishedYear = request.getParameter("publishedyear");
		String discount = request.getParameter("discount");
		String status = request.getParameter("status");
		
		
		Books book = new Books();
		book.setID(id);
		book.setName(name);
		book.setPrice(price);
		book.setAuthor(author);
		book.setPublishedYear(publishedYear);
		book.setDiscount(discount);
		book.setStatus(status);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("addBook", book);
		
		BooksDao dao = new BooksDao();
		
		try {
			dao.insert(book);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("welcome.jsp");
		
	}

}
