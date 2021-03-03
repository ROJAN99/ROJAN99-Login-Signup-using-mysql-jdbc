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


@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("username");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstdb","root", "root24685");
			PreparedStatement ps = conn.prepareStatement("delete from clients where username=?");
			
			ps.setString(1, uname);
			
//			ResultSet rs = ps.executeQuery();
			
			
			//goest to fetch all servlet and then goes to all usedetails.jsp
			
			
			int rows = ps.executeUpdate();
			
			if(rows>0) {
				request.setAttribute("deleteMsg", "Successfully deleted");
				request.getRequestDispatcher("fetchAllRecords").forward(request, response);
			}else {
				System.out.println("Deletion NOT succeed");
			}
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
