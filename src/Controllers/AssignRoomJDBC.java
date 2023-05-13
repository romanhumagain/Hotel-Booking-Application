package Controllers;

//import all the necessary libraries and classes for the GUI
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import models.GlobalManager;
import models.Room;
import models.UpdateBooking;
import views.ManagerPage;

public class AssignRoomJDBC {

	// This method is used for assigning a room to a booking
	public static boolean assignRoom(Room room, UpdateBooking updateBooking) {
		boolean result = false;
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		PreparedStatement prst;
		Connection conn;

		// SQL query to check if the room is already assigned
		String checkRoomId = "SELECT Room_ID FROM booking WHERE Room_ID = ?";

		// SQL query to assign the room to the booking
		String assignRoom = "UPDATE booking SET Room_ID = ? WHERE Booking_ID = ?";

		try {
			conn = DriverManager.getConnection(url, userName, passWord);

			// Prepare and execute the query to check if the room is already assigned
			prst = conn.prepareStatement(checkRoomId);
			prst.setInt(1, room.getRoomId());
			ResultSet rs = prst.executeQuery();

			if (rs.next()) {
				JOptionPane.showMessageDialog(ManagerPage.innerPanelEast, "This room is already assigned!", "ERROR !",
						JOptionPane.ERROR_MESSAGE);
			} else {
				// Prepare and execute the query to assign the room to the booking
				prst = conn.prepareStatement(assignRoom);
				prst.setInt(1, room.getRoomId());
				prst.setInt(2, updateBooking.getBookingId());
				prst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Room assigned successfully!");

				// Clear the global booking and room IDs
				GlobalManager.bookingId = "";
				GlobalManager.roomId = "";

				result = true;
			}

			prst.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ERROR:" + ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error assigning room.");
			result = false;
		}
		return result;
	}

	// This method is used for updating the availability status of a room
	public static boolean availableRoom(Room room) {

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
			prst.setString(1, room.getAvailabilityStatus());
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
		return result; // returns result
	}
}
