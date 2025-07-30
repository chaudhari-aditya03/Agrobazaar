	package com.servlet;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.sql.*;
	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	@WebServlet("/adminLogin")
	public class AdminLoginServlet extends HttpServlet{
		private static final long serialVersionUID = 1L;
		protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
		{
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			String uname=req.getParameter("uname");
			String password=req.getParameter("password");
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/AGROBAZAAR","root","7709648063");
				
				PreparedStatement ps=con.prepareStatement("Select * from AdminLogin1 where username=? and password=?");
				ps.setString(1, uname);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next())
				{
					   res.sendRedirect("AdminDashboardServlet"); 
//					RequestDispatcher rd =req.getRequestDispatcher("/AdminDashboardServlet");//next page
//					rd.include(req, res);
				}
				else
				{
					out.print("<h3>UserName and Password Dosent Match</h3>");
					RequestDispatcher rd =req.getRequestDispatcher("/AdminLogin.jsp");
//					out.println("<html><body><h2>Login SUccessfully</h2>></body></html>");
					rd.include(req, res);
				}
			}
			catch(Exception e)
			{
				out.print("<h3>"+e.getMessage()+"</h3>");
				RequestDispatcher rd =req.getRequestDispatcher("/AdminLogin.jsp");
				rd.include(req, res);
			}
	 }
	}