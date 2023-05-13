package Controllers;

//import all the necessary libraries and classes for the GUI
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Password;

public class PasswordJDBC {

	public boolean updatePassword(Password password) {

		boolean result = false;
		// query to update customer password
		String query = "UPDATE customer set Customer_Password =? WHERE Customer_ID =?";
		// Connection details for MySQL Database
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		PreparedStatement prst;
		Connection conn;

		try {
			conn = DriverManager.getConnection(url, userName, passWord);
			prst = conn.prepareStatement(query);
			prst.setString(1, password.getPassword());
			prst.setInt(2, password.getCustomerId());
			prst.executeUpdate();
			prst.close();
			result = true;
		} catch (SQLException e) {
			System.out.println("ERROR: " + e.getMessage()); // to get error message
			result = false;
		}
		return result;

	}

}
