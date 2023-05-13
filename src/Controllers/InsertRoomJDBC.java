package Controllers;

//import all the necessary libraries and classes for the GUI
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import models.Room;

public class InsertRoomJDBC {
	// for assigning room to customer

	public static boolean addRoom(Room room) {

		boolean result = false;

		// Connection details for MySQL Database
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		PreparedStatement prst;
		Connection conn;

		// query to insert value in room table in database
		String query = "INSERT INTO room (Room_ID, Room_Type, Room_Price ,Availibility_Status) VALUES(?,?,?,?)";

		try {
			// connection with database
			conn = DriverManager.getConnection(url, userName, passWord);
			prst = conn.prepareStatement(query);

			prst.setInt(1, room.getRoomId());
			prst.setString(2, room.getRoomType());
			prst.setInt(3, room.getRoomPrice());
			prst.setString(4, room.getAvailabilityStatus());

			prst.executeUpdate();
			prst.close();
			conn.close();

			result = true;
		} catch (Exception ex) {

			System.out.println("ERROR:" + ex.getMessage());// to get error message
			result = false;
		}
		return result;

	}
}
