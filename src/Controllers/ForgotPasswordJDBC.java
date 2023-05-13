package Controllers;

//import all the necessary libraries and classes for the GUI
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Customer;

public class ForgotPasswordJDBC {
	// creating method
	public Customer getData(String username, String contact) {
		Customer customer = null;

		// Connection details for MySQL Database
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		// query to select all from customer
		String query = "SELECT * FROM customer WHERE Customer_Username =? AND Contact = ?";

		Connection conn;
		PreparedStatement prst;
		try {
			conn = DriverManager.getConnection(url, userName, passWord);
			prst = conn.prepareStatement(query);
			prst.setString(1, username);
			prst.setString(2, contact);
			ResultSet rs = prst.executeQuery();
			if (rs.next()) {
				// to get data from customer table
				customer = new Customer();
				customer.setCustomerUserName(rs.getString("Customer_Username"));
				customer.setCustomerContact(rs.getString("Contact"));
				customer.setCustomerPassword(rs.getString("Customer_Password"));
			}
			prst.close();
			rs.close();
			conn.close(); // closing connection

		} catch (SQLException e) {
			System.out.println("ERROR: " + e.getMessage());// to get error message
		}
		return customer;
	}

}
