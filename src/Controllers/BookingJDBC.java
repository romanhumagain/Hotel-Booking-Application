package Controllers;

//import all the necessary libraries and classes for the GUI
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.Bill;
import models.Booking;
import models.Room;

public class BookingJDBC {

	public boolean insertBooking(Room room, Booking booking, Bill bill) {
		boolean result = false;

		// Connection details for MySQL Database
		// private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";

		Connection connection = null;
		PreparedStatement bookingStatement = null;
		PreparedStatement billStatement = null;
		PreparedStatement roomStatement = null;
		ResultSet bookingResultSet = null;
		ResultSet roomResultSet = null;
		ResultSet billResultSet = null;

		try {
			// connection with database
			connection = DriverManager.getConnection(url, userName, passWord);
			connection.setAutoCommit(false);

			// Insert Room Information into Room Table
			String roomQuery = "INSERT INTO room (Room_ID, Room_Type, Room_Price ,Availibility_Status) VALUES(?,?,?,?)";
			roomStatement = connection.prepareStatement(roomQuery, Statement.RETURN_GENERATED_KEYS);

			roomStatement.setInt(1, room.getRoomId());
			roomStatement.setString(2, room.getRoomType());
			roomStatement.setInt(3, room.getRoomPrice());
			roomStatement.setString(4, room.getAvailabilityStatus());
			int affectedRows1 = roomStatement.executeUpdate();
			if (affectedRows1 == 0) {
				throw new SQLException("Creating Room failed, no rows affected.");
			}

			// Retrieve the Room ID generated by Auto Increment
			roomResultSet = roomStatement.getGeneratedKeys();
			int roomId = 0;
			if (roomResultSet.next()) {
				roomId = roomResultSet.getInt(1);
			} else {
				throw new SQLException("Creating Room failed, no ID obtained.");
			}
			// query to insert into booking table
			String query = "INSERT INTO booking (Booking_ID,Check_In,Check_Out,Room_Type,Number_of_room,Booking_Status,Payment_Status,Customer_ID) VALUES(?,?,?,?,?,?,?,?)";
			bookingStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			bookingStatement.setInt(1, booking.getBookingId());
			bookingStatement.setString(2, booking.getCheckIn());
			bookingStatement.setString(3, booking.getCheckOut());
			bookingStatement.setString(4, booking.getRoomType());
			bookingStatement.setInt(5, booking.getNumberOfRoom());
			bookingStatement.setString(6, booking.getBookingStatus());
			bookingStatement.setString(7, booking.getPaymentStatus());
			bookingStatement.setInt(8, booking.getCustomerId());
			// bookingStatement.setInt(9, roomId);

			int affectedRows = bookingStatement.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Creating Booking failed, no rows affected.");
			}

			// Step 6 - Retrieve the Booking ID generated by Auto Increment
			bookingResultSet = bookingStatement.getGeneratedKeys();
			int bookingId = 0;
			if (bookingResultSet.next()) {
				bookingId = bookingResultSet.getInt(1);
			} else {
				throw new SQLException("Creating Booking failed, no ID obtained.");
			}

			/// for Billing table

			// query to insert into bill
			String billQuery = "INSERT INTO bill (Amount ,Booking_ID) VALUES(?,?)";
			billStatement = connection.prepareStatement(billQuery);

			billStatement.setInt(1, bill.getTotalAmount());
			billStatement.setInt(2, bookingId);

			affectedRows = billStatement.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Creating Bill failed, no rows affected.");
			}
			connection.commit();
			result = true;
		} catch (SQLException e) {
			try {
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException ex) {
				System.out.println("Error rolling back transaction: " + ex.getMessage());
			}
			System.out.println("Error creating Booking and Bill: " + e.getMessage());
			result = false;
		} finally {
			// Close all resources
			try {
				if (bookingResultSet != null) {
					bookingResultSet.close();
				}
				if (billResultSet != null) {
					billResultSet.close();
				}

				if (roomResultSet != null) {
					roomResultSet.close();
				}
				if (roomStatement != null) {
					roomStatement.close();
				}
				if (bookingStatement != null) {
					bookingStatement.close();
				}
				if (billStatement != null) {
					billStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException ex) {
				System.out.println("Error closing resources: " + ex.getMessage()); // to get error message
			}
		}
		return result;
	}

	// for updating payment status
	public static boolean paymentStatus(Booking booking) {

		boolean result = false;
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		PreparedStatement prst;
		Connection conn;
		// query to update booking
		String query = "UPDATE booking SET Payment_Status = ? WHERE Booking_ID = ?";
		try {
			// connection with database
			conn = DriverManager.getConnection(url, userName, passWord);
			prst = conn.prepareStatement(query);
			prst.setString(1, booking.getPaymentStatus());
			prst.setInt(2, booking.getBookingId());
			prst.executeUpdate();
			prst.close();
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("ERROR:" + ex.getMessage()); // to get error message
			result = false;
		}
		return result;
	}

	// for checking out -------------------
	public static boolean checkOut(Booking booking) {

		boolean result = false;
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		PreparedStatement prst;
		Connection conn;
		// query to update column of booking table
		String query = "UPDATE booking SET Booking_Status = ? WHERE Booking_ID = ?";
		try {
			// connection with database
			conn = DriverManager.getConnection(url, userName, passWord);
			prst = conn.prepareStatement(query);
			prst.setString(1, booking.getBookingStatus());
			prst.setInt(2, booking.getBookingId());
			prst.executeUpdate();
			prst.close();
			conn.close();

			result = true;
		} catch (Exception ex) {
			System.out.println("ERROR:" + ex.getMessage()); // to get error message
			result = false;
		}
		return result; // returning result
	}
}
