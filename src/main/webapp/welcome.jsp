<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.io.*" %>
<%@ page import="model.login" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Dashboard</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
    body {
        color: #404E67;
        background: #F5F7FA;
		font-family: 'Open Sans', sans-serif;
	}
	.table-wrapper {
		width: 700px;
		margin: 30px auto;
        background: #fff;
        padding: 20px;	
        box-shadow: 0 1px 1px rgba(0,0,0,.05);
    }
    .table-title {
        padding-bottom: 10px;
        margin: 0 0 10px;
    }
    .table-title h2 {
        margin: 6px 0 0;
        font-size: 22px;
    }
    .table-title .add-new {
        float: right;
		height: 30px;
		font-weight: bold;
		font-size: 12px;
		text-shadow: none;
		min-width: 100px;
		border-radius: 50px;
		line-height: 13px;
    }
	.table-title .add-new i {
		margin-right: 4px;
	}
    table.table {
        table-layout: fixed;
    }
    table.table tr th, table.table tr td {
        border-color: #e9e9e9;
    }
    table.table th i {
        font-size: 13px;
        margin: 0 5px;
        cursor: pointer;
    }
    table.table th:last-child {
        width: 100px;
    }
    table.table td a {
		cursor: pointer;
        display: inline-block;
        margin: 0 5px;
		min-width: 24px;
    }    
	table.table td a.add {
        color: #27C46B;
    }
    table.table td a.edit {
        color: #FFC107;
    }
    table.table td a.delete {
        color: #E34724;
    }
    table.table td i {
        font-size: 19px;
    }
	table.table td a.add i {
        font-size: 24px;
    	margin-right: -1px;
        position: relative;
        top: 3px;
    }    
    table.table .form-control {
        height: 32px;
        line-height: 32px;
        box-shadow: none;
        border-radius: 2px;
    }
	table.table .form-control.error {
		border-color: #f50000;
	}
	table.table td .add {
		display: none;
	}
</style>

</script>
</head>
<body>


    <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8"><h2>Book <b>Details</b></h2></div>
                    <div class="col-sm-4">
                    
                        <a href="AddBooks.jsp">Add New</a>
                        
                        <tr></tr><tr><td></td><td></td><td><a href="index.jsp"><b>Logout</b></a>
                    </div>
                </div>
            </div>
           
            <% String username = request.getParameter("username"); %>
<a>Welcome   <% out.println(username); %> !!!! You have logged in.</a>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Author</th>                
                <th>Year</th>
                <th>Discount</th>
                <th>Status</th>
                <th>update</th>
                <th>delete</th>
                    </tr>
                </thead>
                <tbody>
                  <%
                  try {
          			Class.forName("com.mysql.jdbc.Driver");
        			Connection con= DriverManager.getConnection( "jdbc:mysql://localhost:3306/dashboard", "root", "root");
        			Statement st=con.createStatement();
        			ResultSet rs=st.executeQuery("select * from books");
              	     
        			while(rs.next()){
      		
      		%>
      		
                <tr>
                    <td><%=rs.getInt(1) %></td>
                    <td><%=rs.getString(2) %></td>
                    <td><%=rs.getString(3) %></td>
                    <td><%=rs.getString(4) %></td>
                    <td><%=rs.getString(5) %></td>
                    <td><%=rs.getString(6) %></td>
                    <td><%=rs.getString(7) %></td>
                    
                    <td>
                     <form action="ShowEditForm" method="post">
                        <input type="hidden" name="id" value="<%=rs.getInt(1)%>">
                        <input type="submit" value="Update">
                    </form>                    
                    </td>
                    <td>
                     <form action="DeleteBook" method="post">
                        <input type="hidden" name="id" value="<%=rs.getInt(1)%>">
                        <input type="submit" value="delete">
                    </form>                    
                    </td>
                    <%} %>
        			<%
                  }catch (Exception e) {
              			// TODO Auto-generated catch block
              			e.printStackTrace();
              		}  %>
                   
                </tr>
           
                </tbody>
            </table>
           
        </div>
    </div>     
</body>
</html>                            