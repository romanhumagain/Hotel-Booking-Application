package Controllers;

//import all the necessary libraries and classes for the GUI
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.UpdateBooking;

public class UpdateBookingJDBC {

	public boolean bookingUpdate(UpdateBooking updateBooking) {
		boolean result = false;
		// Connection details for MySQL Database
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		PreparedStatement prst;
		Connection conn;
		// sql query to update booking
		String query = "UPDATE booking SET Check_In = ?, Check_Out = ? WHERE Booking_ID = ?";
		try {
			// connection with database
			conn = DriverManager.getConnection(url, userName, passWord);
			prst = conn.prepareStatement(query);
			prst.setString(1, updateBooking.getCheckIn());
			prst.setString(2, updateBooking.getCheckOut());
			prst.setInt(3, updateBooking.getBookingId());

			prst.executeUpdate();
			prst.close();
			conn.close();// to close the connection
			result = true;
		} catch (SQLException ex) {
			System.out.println("ERROR :" + ex.getMessage());// printing the error message
			result = false;
		}
		return result;
	}

}
