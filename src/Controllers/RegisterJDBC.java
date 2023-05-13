package Controllers;
//import all the necessary libraries and classes 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import models.Register;

public class RegisterJDBC {

	public boolean insert(Register register) {
		// sql query to insert value into customer table
		String query = "INSERT INTO customer(Customer_ID, Full_Name,Address,Contact,Email,Gender, Country, Customer_Type,Customer_Username,Customer_Password ,Date_Of_Birth ,Company_Name ,Company_Contact) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		boolean result = false;
		PreparedStatement prst;

		try {
			// connection with database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
			prst = conn.prepareStatement(query);
			prst.setInt(1, register.getCustomerId());
			prst.setString(2, register.getFullName());
			prst.setString(3, register.getAddress());
			prst.setString(4, register.getContact());
			prst.setString(5, register.getEmail());
			prst.setString(6, register.getGender());
			prst.setString(7, register.getCountry());
			prst.setString(8, register.getCustomerType());
			prst.setString(9, register.getCustomerUserName());
			prst.setString(10, register.getCustomerPassword());
			prst.setString(11, register.getDateOfBirth());
			prst.setString(12, register.getCompanyName());
			prst.setString(13, register.getCompanyContact());

			prst.executeUpdate();
			prst.close(); // closing PreparedStatement
			conn.close();

			result = true;
		} catch (Exception ex) {
			System.out.println("ERROR:" + ex.getMessage()); //to get error message
			result = false;
		}
		return result;

	}

}
