package com.example.projects;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			ServletContext context=getServletContext();
            Driverdetails details=(Driverdetails) context.getAttribute("driverInfo");
            Connection con=null;
            Statement st=null;
            ResultSet rs=null;
            List<Emp> employees=new ArrayList();
            try {
				Class.forName(details.getDriver());
				con=DriverManager.getConnection(details.getUrl(), details.getUsername(), details.getPassword());
				st=con.createStatement();
				rs=st.executeQuery("select * from emp");
				while(rs.next()) {
				
					employees.add(new Emp(rs.getInt(1),rs.getString(2),rs.getString(3)));
				}
				request.setAttribute("employees", employees);
				RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
            
		}

}
