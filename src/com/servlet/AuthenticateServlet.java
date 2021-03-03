package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.UserDTO;


@WebServlet("/authenticateServlet")
public class AuthenticateServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pwd");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstdb","root","root24685");
			PreparedStatement ps =  conn.prepareStatement("select * from clients where username=? and password=?");
			ps.setString(1, user);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				//valid user
				String username=rs.getString(1);
				String password = rs.getString(2);
				String fullName = rs.getString(3);
				String email = rs.getString(4);
				
//				request.setAttribute("username", username);
//				request.setAttribute("password", password);
//				request.setAttribute("fullName", fullName);
//				request.setAttribute("email", email);
				
				//use data transfer object to create single object out of all the fields object above
				UserDTO userDTO = new UserDTO(username,password, fullName, email);
				
				//prepare to send it to jsp (frontend)
				request.setAttribute("userDTO", userDTO);

				//forward attributes to userDetails.jsp (frontend)
				request.getRequestDispatcher("userDetails.jsp").forward(request, response);
			} else {
				//invalid user
				request.setAttribute( "msg", "invalid credentials. .  Please login");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(user.equals("test@test.com")  && pass.equals("test")) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("userDetails.jsp").forward(request, response);
		} else {
			request.setAttribute("warning", user);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
