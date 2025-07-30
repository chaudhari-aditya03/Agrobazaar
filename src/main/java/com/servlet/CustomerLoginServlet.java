package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/custLogin")
public class CustomerLoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String uname=req.getParameter("uname");
		String password=req.getParameter("password");
		
		String hashedPassword = hashPassword(password);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/AGROBAZAAR","root","7709648063");
			
			PreparedStatement ps=con.prepareStatement("Select * from Customer_Reg where username=? and password=?");
			ps.setString(1, uname);
			ps.setString(2, hashedPassword);
			
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				
				HttpSession s1=req.getSession();
				s1.setAttribute("session_1", rs.getString("full_name"));
				s1.setAttribute("session_2", rs.getString("email"));
//				s1.setAttribute("session_1", rs.getString("full_name"));
//				RequestDispatcher rd =req.getRequestDispatcher("/Customer_Dashboard.jsp");//next page
//				rd.include(req, res);
			    res.sendRedirect("CustomerDashboard"); 
//				out.print("<html><body><h2 style=color>Login SUccessfully</h2>></body></html>");
			}
			else
			{
				out.print("<h3>UserName and Password Dosent Match</h3>");
				RequestDispatcher rd =req.getRequestDispatcher("/HomeCustomer.jsp");
//				out.println("<html><body><h2>Login SUccessfully</h2>></body></html>");
				rd.include(req, res);
			}
		}
		catch(Exception e)
		{
			out.print("<h3>"+e.getMessage()+"</h3>");
			RequestDispatcher rd =req.getRequestDispatcher("/HomeCustomer.jsp");
			rd.include(req, res);
		}
	}
	private static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedhash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        	} 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
            return null;
        }
 }
}
