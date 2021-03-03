package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.UserDTO;


@WebServlet("/ascendByEmail")
public class AscendByEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AscendByEmail() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserDTO> listOfUsers = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstdb", "root", "root24685");
			PreparedStatement ps = conn.prepareStatement("select * from clients order by email asc");
			
			ps.executeQuery();
			
			ResultSet rs = ps.executeQuery();
			//iterate through all records 
			while(rs.next()) {
				String username = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				
				UserDTO userDTO = new UserDTO(username, password, name, email);
				listOfUsers.add(userDTO);
								
			}
			
			request.setAttribute("listOfUsers", listOfUsers);
			request.getRequestDispatcher("allUserDetails.jsp").forward(request, response);
			
			
			
			
			
			
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
