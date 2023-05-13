package Controllers;

//import all the necessary libraries and classes for the GUI
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

import models.Room;

public class ManagerBookingTableJDBC {

	// creating method
	public static DefaultTableModel getBookingData() {

		// Connection details for MySQL Database
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "Booking Id", "Name", "Cust ID", "Cust Type", "Comp_Name", "Comp_Contact",
				"CheckIn", "CheckOut", "No Of Room", "Booking Status",
				"Room No", "Room Type", "Payment Status" }); // adding column in jtable

		// query to select data from customer and booking table using INNER JOIN
		String sqlQuery = "SELECT c.Full_Name,c.Customer_ID,c.Customer_Type ,c.Company_Name ,c.Company_Contact, b.Booking_ID, b.Check_In, b.Check_Out,b.Number_of_room, b.Booking_Status, b.Room_ID, b.Room_Type, b.Payment_Status "
				+
				"FROM customer c " +
				"INNER JOIN booking b ON c.Customer_ID = b.Customer_ID ORDER BY Full_Name ASC";

		try {

			Connection conn = DriverManager.getConnection(url, userName, passWord);

			PreparedStatement stmt = conn.prepareStatement(sqlQuery);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				// to get data from jtable
				String fullName = rs.getString("Full_Name");
				int customerId = rs.getInt("Customer_ID");
				String customerType = rs.getString("Customer_Type");
				String companyName = rs.getString("Company_Name");
				String companyContact = rs.getString("Company_Contact");
				int bookingID = rs.getInt("Booking_ID");
				Date checkIn = rs.getDate("Check_In");
				Date checkOut = rs.getDate("Check_Out");
				int numberOfRoom = rs.getInt("Number_of_room");
				String bookingStatus = rs.getString("Booking_Status");
				int roomID = rs.getInt("Room_ID");
				String roomType = rs.getString("Room_Type");
				String paymentStatus = rs.getString("Payment_Status");

				model.addRow(new Object[] { bookingID, fullName, customerId, customerType, companyName, companyContact, checkIn,
						checkOut, numberOfRoom, bookingStatus, roomID, roomType,
						paymentStatus }); // adding the data in the row

			}

			rs.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}

		return model; // returning model
	}

	// This method is used for updating the availability status of a room after
	// checking out
	public static boolean checkOut(Room room) {

		// Connection details for MySQL Database
		boolean result = false;
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		PreparedStatement prst;
		Connection conn;

		// SQL query to update the availability status of the room
		String query = "UPDATE room SET Availibility_Status = ? WHERE Room_ID = ?";

		try {
			conn = DriverManager.getConnection(url, userName, passWord);

			// Prepare and execute the query to update the availability status of the room
			prst = conn.prepareStatement(query);
			prst.setString(1, "Available");
			prst.setInt(2, room.getRoomId());
			prst.executeUpdate();
			prst.close();
			conn.close();

			result = true;
		} catch (Exception ex) {
			System.out.println("ERROR:" + ex.getMessage());
			// JOptionPane.showMessageDialog(AssignRoomPage.panelCenter,""
			// +ex.getMessage());
			result = false;
		}
		return result;
	}
}
