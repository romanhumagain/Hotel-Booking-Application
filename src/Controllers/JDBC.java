package Controllers;

//import all the necessary libraries and classes for the GUI
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import models.Customer;

public class JDBC {

	public Customer login(Customer customer) {

		// to select the customer username and customer password
		String search = "SELECT * FROM customer WHERE Customer_Username = ? AND Customer_Password = ?";

		try {
			// connection with database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
			PreparedStatement prst = conn.prepareStatement(search);
			prst.setString(1, customer.getCustomerUserName());
			prst.setString(2, customer.getCustomerPassword());

			ResultSet rs = prst.executeQuery();
			while (rs.next()) {
				// select data from customer table
				customer.setCustomerId(rs.getInt("Customer_ID"));
				customer.setCustomerName(rs.getString("Full_Name"));
				customer.setCustomerEmail(rs.getString("Email"));
				customer.setCustomerContact(rs.getString("Contact"));
				customer.setCustomerAddress(rs.getString("Address"));
				customer.setCustomerType(rs.getString("Customer_Type"));
				customer.setDateOfBirth(rs.getString("Date_Of_Birth"));
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());// to get error message
		
		}
		return customer;
	}
}
