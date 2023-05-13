package Controllers;

//import all the necessary libraries and classes for the GUI
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import models.Booking;
import models.GlobalBill;

public class ManagerBillTableJDBC {

	// to get all bill data-------------------

	public static DefaultTableModel getBillData() {

		// Connection details for MySQL Database
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(
				new String[] { "Booking_ID", "Name", "Bill_ID", "Amount", "Payment Status", "Payment_Date" }); // adding column

		// to get data from the database table
		String sqlQuery = "SELECT booking.Booking_ID ,customer.Full_Name ,bill.Bill_Number ,bill.Amount ,bill.Payment_Date ,booking.Payment_Status FROM booking "
				+ "INNER JOIN bill "
				+ "ON booking.Booking_ID = bill.Booking_ID "
				+ "INNER JOIN customer "
				+ "ON customer.Customer_ID = booking.Customer_ID ORDER BY customer.Full_Name ASC;"
				+ "";

		// String query = "SELECT bill.* ,booking.* ,customer.* INNER JOIN ";
		try {

			Connection conn = DriverManager.getConnection(url, userName, passWord);

			PreparedStatement stmt = conn.prepareStatement(sqlQuery);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// getting data from the table
				int bookingId = rs.getInt("Booking_ID");
				String name = rs.getString("Full_Name");
				int billId = rs.getInt("Bill_Number");
				int amount = rs.getInt("Amount");
				String paymentStatus = rs.getString("Payment_Status");
				String paymentDate = rs.getString("Payment_Date");

				// to add rows to the column
				model.addRow(new Object[] { bookingId, name, billId, amount, paymentStatus, paymentDate });
			}

			rs.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());// to get error message
		}

		return model;
	}

	// to get data of unpaid bills------------------------
	public static DefaultTableModel getUnPaidBillData() {

		// Connection details for MySQL Database
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(
				new String[] { "Booking_ID", "Name", "Bill_ID", "Amount", "Payment Status", "Payment_Date" }); // to add column

		// sql query to get data using join
		String sqlQuery = "SELECT booking.Booking_ID, customer.Full_Name, bill.Bill_Number, bill.Amount, bill.Payment_Date, booking.Payment_Status"
				+ " FROM booking INNER JOIN bill ON booking.Booking_ID = bill.Booking_ID "
				+ "INNER JOIN customer ON customer.Customer_ID = booking.Customer_ID WHERE booking.Payment_Status "
				+ "LIKE '%pending%' "
				+ "ORDER BY customer.Full_Name ASC";

		try {
			Connection conn = DriverManager.getConnection(url, userName, passWord);
			PreparedStatement stmt = conn.prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				// to get data from database table

				int bookingId = rs.getInt("Booking_ID");
				String name = rs.getString("Full_Name");
				int billId = rs.getInt("Bill_Number");
				int amount = rs.getInt("Amount");
				String paymentStatus = rs.getString("Payment_Status");
				String paymentDate = rs.getString("Payment_Date");

				// adding data in the jtable
				model.addRow(new Object[] { bookingId, name, billId, amount, paymentStatus, paymentDate });
			}
			rs.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());// to get error message
		}
		return model;
	}

	// for printing bill------------------------------------

	public static void printBill(Booking booking) {

		// Connection details for MySQL Database
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		// query to get data from booking and room using INNER JOIN
		String roomSql = "SELECT room.* FROM room INNER JOIN booking ON booking.Room_ID = room.Room_ID WHERE Booking_ID =?";
		// query to select all data from room
		String bookingSql = "SELECT * FROM booking WHERE Booking_ID =?";
		try {
			// connection with database
			Connection conn = DriverManager.getConnection(url, userName, passWord);

			PreparedStatement stmt = conn.prepareStatement(roomSql);
			stmt.setInt(1, booking.getBookingId());

			PreparedStatement prst = conn.prepareStatement(bookingSql);
			prst.setInt(1, booking.getBookingId());

			ResultSet rs = stmt.executeQuery();
			ResultSet result = prst.executeQuery();

			while (rs.next()) {
				// to get data from database table
				String roomType = rs.getString("Room_Type");
				int roomPrice = rs.getInt("Room_Price");

				// adding value to the global variable
				GlobalBill.RoomType = roomType;
				GlobalBill.roomPrice = roomPrice;

			}
			while (result.next()) {
				// to get data from database table
				String roomId = result.getString("Room_ID");
				int noOfBook = result.getInt("Number_of_room");

				// adding value to the global variable
				GlobalBill.noOfRoom = noOfBook;
				GlobalBill.roomId = roomId;
			}
			rs.close();
			result.close();
			conn.close();// closing the connection
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());// to get error message
		}
	}
}
