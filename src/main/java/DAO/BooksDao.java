package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;

import model.Books;
import model.login;

public class BooksDao {
	

	public Books getAll(String id) throws ClassNotFoundException, SQLException {
		Books book = null;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection( "jdbc:mysql://localhost:3306/dashboard", "root", "root");
		
		java.sql.PreparedStatement stmt = con.prepareStatement("select * from Books where id=?");
	    stmt.setString(1, id);
		ResultSet rs = stmt.executeQuery();

       if(rs.next()) {
    	   String name = rs.getString("name");
    	   String price = rs.getString("price");
    	   String author = rs.getString("author");
    	   String publishedYear = rs.getString("publishedYear");
    	   String discount = rs.getString("discount");
    	   String status = rs.getString("status");
    	   
    	   book = new Books(id, name, price, author, publishedYear, discount, status) ;
     
       }
		
		stmt.close();
		con.close();
		return book;
		
	}


public void insert(Books book) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection( "jdbc:mysql://localhost:3306/dashboard", "root", "root");
		
		java.sql.PreparedStatement stmt = con.prepareStatement("insert into books values(?,?,?,?,?,?,?)");
		stmt.setString(1, book.getID());
		stmt.setString(2, book.getName());
		stmt.setString(3, book.getPrice());
		stmt.setString(4, book.getAuthor());
		stmt.setString(5, book.getPublishedYear());
		stmt.setString(6, book.getDiscount());
		stmt.setString(7, book.getStatus());
		stmt.executeUpdate();
		
		stmt.close();
		con.close();
	}

public void delete(Books book) throws ClassNotFoundException, SQLException {
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection( "jdbc:mysql://localhost:3306/dashboard", "root", "root");
	
	java.sql.PreparedStatement stmt = con.prepareStatement("delete from books where id=?");
	stmt.setString(1, book.getID());
	
	stmt.executeUpdate();
	
	stmt.close();
	con.close();
}

public void updateBook(Books book) throws SQLException, ClassNotFoundException {
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection( "jdbc:mysql://localhost:3306/dashboard", "root", "root");
    String sql = "UPDATE books SET name = ?, price = ?,author=? , publishedyear=?, discount = ?, status=? where id = ?";
     System.out.println("in update dao");
    PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
    statement.setString(1, book.getName());
    statement.setString(2, book.getPrice());
    statement.setString(3, book.getAuthor());
    statement.setString(4, book.getPublishedYear());
    statement.setString(5, book.getDiscount());
    statement.setString(6, book.getStatus());
    statement.setString(7, book.getID());
    statement.executeUpdate(); 
   
    statement.close();
	
     
}
 
     
}
