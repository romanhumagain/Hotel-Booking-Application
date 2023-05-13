package Controllers;
//import all the necessary libraries and classes for the GUI

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Cancel;
import models.Customer;

public class CancelBooking {

	public boolean cancelBooking(Cancel cancel) {
		boolean result = false;
		// Connection details for MySQL Database
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		Connection conn = null;
		PreparedStatement prst = null;

		try {
			// Retrieve the room ID for the cancelled booking
			int roomId = -1;
			conn = DriverManager.getConnection(url, userName, passWord);

			// query to select room id from booking table
			String query = "SELECT Room_ID FROM booking WHERE Booking_ID = ?";
			prst = conn.prepareStatement(query);
			prst.setInt(1, cancel.getBookingId());
			ResultSet rs = prst.executeQuery();
			if (rs.next()) {
				// getting roomid from room table
				roomId = rs.getInt("Room_ID");
			}
			rs.close();
			prst.close();

			// Update the availability status of the room to "available"
			if (roomId != -1) {
				query = "UPDATE room SET Availibility_Status = 'Available' WHERE Room_ID = ?";
				prst = conn.prepareStatement(query);
				prst.setInt(1, roomId);
				prst.executeUpdate();
				prst.close();
			}

			// Delete the row from the booking table
			query = "DELETE FROM booking WHERE Booking_ID = ?";
			prst = conn.prepareStatement(query);
			prst.setInt(1, cancel.getBookingId());
			prst.executeUpdate();
			prst.close();

			result = true;
		} catch (SQLException ex) {
			System.out.println("ERROR:" + ex.getMessage());// to get error message
			result = false;
		} finally {
			try {
				if (prst != null) {
					prst.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("ERROR:" + ex.getMessage());// to get error message
			}
		}

		return result;
	}

	public boolean deleteUser(Customer customer) {

		boolean result = false;
		// query to delete the customer
		String query = "DELETE FROM customer WHERE Customer_ID =?"; // query to delete from customer

		// Connection details for MySQL Database
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		PreparedStatement prst;

		try {
			// connection with database
			Connection conn = DriverManager.getConnection(url, userName, passWord);
			prst = conn.prepareStatement(query);
			prst.setInt(1, customer.getCustomerId());
			prst.executeUpdate();
			prst.close();
			conn.close();// closing connection

			result = true;
		} catch (SQLException ex) {
			System.out.println("ERROR:" + ex.getMessage());// to get error message
			result = false;
		}
		return result;
	}

}
