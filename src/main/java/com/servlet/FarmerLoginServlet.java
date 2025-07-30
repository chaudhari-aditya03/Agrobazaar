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

@WebServlet("/farmLogin")
public class FarmerLoginServlet extends HttpServlet{
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
			
			PreparedStatement ps=con.prepareStatement("Select * from farmer_Registration where username=? and password=?");
			ps.setString(1, uname);
			ps.setString(2, hashedPassword);
			
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				
				int farmerId = rs.getInt("id");
				String fullname = rs.getString("fullname");
				String contact_number = rs.getString("contact_number");
				String email = rs.getString("email");
                HttpSession session = req.getSession();
                session.setAttribute("farmer_id", farmerId);
                session.setAttribute("fullname", fullname);
                session.setAttribute("contact_number", contact_number);
                session.setAttribute("email", email);
                res.sendRedirect("FarmerDashboardServlet"); 
//				out.print("<html><body style:'color:red'>Login Successful</body></html>");
			}
			else
			{
				//out.print("<h3>UserName and Password Dosent Match</h3>");
				RequestDispatcher rd =req.getRequestDispatcher("/HomeFarmer.jsp");
				rd.include(req, res);
			}
		}
		catch(Exception e)
		{
			
			out.print("<h3>"+e.getMessage()+"</h3>");
			RequestDispatcher rd =req.getRequestDispatcher("");
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
