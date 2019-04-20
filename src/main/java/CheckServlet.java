

import java.awt.print.Book;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BooksDao;
import DAO.LoginDAO;
import model.Books;
import model.login;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
    	
    
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in servlet");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		login login = new login();
		
		login.setEmail(username);
		login.setPassword(password);
		
//		System.out.println(login.getEmail());
//		System.out.println(login.getPassword());
		
		LoginDAO dao = new LoginDAO();
		
		
			String validate = null;
			try {
				validate = dao.checkUser(login);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	

	
		if(validate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
		 {
			//response.sendRedirect("welcome.jsp");
			RequestDispatcher req = request.getRequestDispatcher("welcome.jsp");
			req.forward(request, response);
		 }
		 else
			 if(validate.equals("Invalid user credentials"))
		 {
				 response.sendRedirect("index.jsp");
				 
		 }
	}
	

}
