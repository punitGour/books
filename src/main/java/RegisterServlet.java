

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginDAO;
import model.*;

@WebServlet("RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
     
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in register ");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String age = request.getParameter("age");
		String password = request.getParameter("psw");
		
		
		login login = new login();
		login.setUsername(name);
		login.setEmail(email);
		login.setCity(city);
		login.setAge(age);
		login.setPassword(password);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("formdata", login);
		
LoginDAO dao = new LoginDAO();
		
		
			try {
				dao.insert(login);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("index.html");
		
	}

}
