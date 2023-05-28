package com.example.projects;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		ServletContext context=getServletContext();
		Driverdetails details=(Driverdetails) context.getAttribute("driverInfo");
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			Class.forName(details.getDriver());
			con=DriverManager.getConnection(details.getUrl(),details.getUsername(),details.getPassword());
			if(con!=null)
			pst=con.prepareStatement("select * from user where username=? and password=?");
			pst.setString(1,username);
			pst.setString(2, password);
			rs=pst.executeQuery();
			if(rs.next()) {
			
				HttpSession session=request.getSession();
				session.setAttribute("username",username);
				System.out.println("user login successfully");
				RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			}
			else
			{
				System.out.println("Wrong username or password entered");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
