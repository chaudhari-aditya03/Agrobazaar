


package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustRegForm")
public class CustomerRegServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter out =res.getWriter();
		
		String fname=req.getParameter("fullName");
		String dob=req.getParameter("dob");
	    String contactNumber = req.getParameter("contactNumber");
	    String email = req.getParameter("email");
	    String username = req.getParameter("username");
	    String password = req.getParameter("password");
	    String fullAddress = req.getParameter("fullAddress");
	    String city = req.getParameter("city");
	    String state = req.getParameter("state");
	    String pincode = req.getParameter("pincode");	
	    
	    String hashedPassword = hashPassword(password);
	    
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/AGROBAZAAR","root","7709648063");
			
			PreparedStatement ps= con.prepareStatement("insert into Customer_Reg (full_name,dob,contact_number,email,username,password,full_address,city,state,pincode)"+" values(?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, fname);
			ps.setString(2, dob);
			ps.setString(3,contactNumber);
			ps.setString(4, email);
			ps.setString(5, username);
			ps.setString(6, hashedPassword);
			ps.setString(7, fullAddress);
			ps.setString(8, city);
			ps.setString(9, state);
			ps.setString(10, pincode);
			
			int count =	ps.executeUpdate();
			
			if(count > 0)
				{
				res.setContentType("text/html");
				//out.print("<h3>User Regestration Succesful</h3>");
				RequestDispatcher rd =req.getRequestDispatcher("/HomeCustomer.jsp");
				rd.include(req, res);
				}
			else
				{
				res.setContentType("text/html");
				out.print("<h3>User Regestration Failed</h3>");
				RequestDispatcher rd =req.getRequestDispatcher("/Customer_Reg.jsp");
				rd.include(req, res);
				}
		  }
	    catch(Exception e)
		    {
				System.out.println(e);
				res.setContentType("text/html");
				out.print("<h3>Exception Occurs"+e.getMessage()+"</h3>");
				RequestDispatcher rd =req.getRequestDispatcher("/Customer_Reg.jsp");
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
