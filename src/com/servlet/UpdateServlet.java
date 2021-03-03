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


@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userFrom = request.getParameter("userFrom");
		String username = request.getParameter("user");
		String fullname = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstdb","root","root24685");
			PreparedStatement ps = conn.prepareStatement("update clients set username=?, password=?, fullname=?, email=? where username=? ");
			
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, fullname);
			ps.setString(4, email);
			ps.setString(5, userFrom);
			
			int rows = ps.executeUpdate();
			
			if(rows>0) {
//				UserDTO userDTO = new UserDTO(username,password, fullname, email);
				request.setAttribute("updateMsg", "Updated Successfully!");
				request.getRequestDispatcher("fetchAllRecords").forward(request, response);
				
			}else {
				System.out.println("Update failed!");
			}

				
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
