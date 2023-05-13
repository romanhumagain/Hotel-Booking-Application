package Controllers;
//import all the necessary libraries and classes for the GUI

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class BookingTableJDBC {
	
	public static DefaultTableModel getData(int customerId) {
		// Connection details for MySQL Database
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "Name", "Booking Id", "CheckIn", "CheckOut", "Booking Status",
				"Room No", "Room Type", "Payment Status" }); // adding column in table
		// query to get data from customer, booking and room table using join
		String sqlQuery = "SELECT c.Full_Name, b.Booking_ID, b.Check_In, b.Check_Out, b.Booking_Status, b.Room_ID, b.Room_Type, b.Payment_Status "
				+
				"FROM customer c " +
				"INNER JOIN booking b ON c.Customer_ID = b.Customer_ID " +
				"WHERE c.Customer_ID = ?";

		try {

			// connection with database
			Connection conn = DriverManager.getConnection(url, userName, passWord);
			PreparedStatement stmt = conn.prepareStatement(sqlQuery);

			stmt.setInt(1, customerId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// getting data from the table
				String fullName = rs.getString("Full_Name");
				int bookingID = rs.getInt("Booking_ID");
				Date checkIn = rs.getDate("Check_In");
				Date checkOut = rs.getDate("Check_Out");
				int roomID = rs.getInt("Room_ID");
				String roomType = rs.getString("Room_Type");
				String bookingStatus = rs.getString("Booking_Status");
				String paymentStatus = rs.getString("Payment_Status");

				model.addRow(new Object[] { fullName, bookingID, checkIn, checkOut, bookingStatus, roomID, roomType,
						paymentStatus }); // adding data in the table
			}

			
			rs.close();
			conn.close();// closing connection
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());// to get error message
		}
		return model; // returning the model
	}
}
