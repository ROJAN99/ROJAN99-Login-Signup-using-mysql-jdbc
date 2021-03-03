package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegistrationServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String fullName = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pwd");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstdb","root","root24685");
			
			PreparedStatement ps = conn.prepareStatement("insert into myfirstdb.clients values(?,?,?,?)");
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setString(3,fullName);
			ps.setString(4, email);
			
			//check if all values are inserted
			int rows = ps.executeUpdate();
			if(rows>0) {
//				System.out.println("Successful signup");
				request.setAttribute("regMsg", "You are successfully signed up. Please login!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				System.out.println("insertion unsuccessful");
			}
			
			conn.close();
			
		} catch(Exception e) {
			
		}

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
