

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BooksDao;
import model.Books;

@WebServlet("ShowEditForm")
public class ShowEditForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowEditForm() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in update");
		       
				try {
					 String id = request.getParameter("id");
				        BooksDao dao = new BooksDao();
				        Books Book;
					Book = dao.getAll(id);
					
					String name = Book.getName();
					String author = Book.getAuthor();
					String price= Book.getPrice();
					String publishedyear = Book.getPublishedYear();
					String status = Book.getStatus();
					String discount = Book.getDiscount();
					
				//	System.out.println(ID);
//					System.out.println(author);
//					System.out.println(price);
					
					response.sendRedirect("update.jsp?&id="+id+"&name="+name+"&author="+author+"&price="+price+"&publishedyear="+publishedyear+"&status="+status+"&discount="+discount);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       
		 
		    }
	}


