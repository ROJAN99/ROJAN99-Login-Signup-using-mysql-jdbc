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


@WebServlet("/fetchRecord")
public class FetchRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FetchRecord() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usr = request.getParameter("username");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstdb","root","root24685");
			PreparedStatement ps = conn.prepareStatement("select * from clients where username=?");
			
			ps.setString(1, usr);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				//valid user
				String username=rs.getString(1);
				String password = rs.getString(2);
				String fullName = rs.getString(3);
				String email = rs.getString(4);
				
				//use data transfer object to create single object out of all the fields object above
				UserDTO userDTO = new UserDTO(username,password, fullName, email);
				
				//prepare to send it to jsp (frontend)
				request.setAttribute("userDTO", userDTO);

				//forward attributes to userDetails.jsp (frontend)
				request.getRequestDispatcher("updateWarning.jsp").forward(request, response);
				
			}
				
			
//			PreparedStatement ps = conn.prepareStatement("update clients set username=?, password=?, fullname=?, email=?");
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
