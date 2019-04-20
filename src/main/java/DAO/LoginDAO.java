package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.login;




public class LoginDAO {
	
	  
	public String checkUser(login login) throws ClassNotFoundException, SQLException
	{
		System.out.println("in DAO");
		String email=login.getEmail();
		String password=login.getPassword();
		
		String usernameDB="";
		String passwordDB="";
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection( "jdbc:mysql://localhost:3306/dashboard", "root", "root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select email, password from login");
			
			
			
			
			while(rs.next())
			{
				usernameDB= rs.getString(1);
				passwordDB= rs.getString(2);
				
				System.out.println(usernameDB);
				System.out.println(passwordDB);
				
				if(email.equals(usernameDB) && password.equals(passwordDB))
				{
					
					 return "SUCCESS";
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Invalid user credentials";
		}
	
	public void insert(login login) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection( "jdbc:mysql://localhost:3306/dashboard", "root", "root");
		
		PreparedStatement stmt = con.prepareStatement("insert into login values(?,?,?,?,?)");
		stmt.setString(1, login.getUsername());
		stmt.setString(2, login.getEmail());
		stmt.setString(3, login.getCity());
		stmt.setString(4, login.getAge());
		stmt.setString(5, login.getPassword());
		stmt.executeUpdate();
		
		stmt.close();
		con.close();
	}
	 

}
