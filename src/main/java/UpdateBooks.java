

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BooksDao;
import model.Books;

@WebServlet("UpdateBooks")
public class UpdateBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateBooks() {
        super();
      
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
		book.setStatus(status);
		book.setDiscount(discount);
		
		BooksDao dao = new BooksDao();
		
		try {
			dao.updateBook(book);
			
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
