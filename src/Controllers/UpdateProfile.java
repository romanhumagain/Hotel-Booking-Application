package Controllers;

//import all the necessary libraries and classes
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProfile {

	public static boolean updateData(String date, String email, String contact, String address, int customerId) {

		boolean result = false;
		// sql query to update the customer
		String query = "UPDATE customer SET Date_Of_Birth =? ,Email =?, Contact =? ,Address =? WHERE Customer_ID = ?";
		PreparedStatement prst;
		try {
			// connection with database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
			prst = conn.prepareStatement(query);
			prst.setString(1, date);
			prst.setString(2, email);
			prst.setString(3, contact);
			prst.setString(4, address);
			prst.setInt(5, customerId);

			prst.executeUpdate();
			prst.close();
			conn.close();// to close the connection
			result = true;
		} catch (SQLException e) {
			System.out.println("ERROR:" + e.getMessage()); // to get error message
			result = false;
		}
		return result;

	}

}
