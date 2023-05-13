package Controllers;
//import all the necessary libraries and classes for the GUI

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

public class ManagerRoomTableJDBC {

	public static DefaultTableModel getRoomData() {

		// Connection details for MySQL Database
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		DefaultTableModel model = new DefaultTableModel();
		// to add column
		model.setColumnIdentifiers(new String[] { "Room_NO", "Room_Type", "Room_Price", "Availability Status" });

		// gettting all data from room table from database
		String sqlQuery = "SELECT * FROM room " +
				"WHERE Availibility_Status LIKE '%Available%' " +
				"ORDER BY CASE Room_Type " +
				"WHEN 'Single Room' THEN 1 " +
				"WHEN 'Double Room' THEN 2 " +
				"WHEN 'Twin Room' THEN 3 " +
				"END";
		try {

			// connection with database
			Connection conn = DriverManager.getConnection(url, userName, passWord);

			PreparedStatement stmt = conn.prepareStatement(sqlQuery);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// to get data from room table from database
				int roomId = rs.getInt("Room_ID");
				String roomType = rs.getString("Room_Type");
				int roomPrice = rs.getInt("Room_Price");
				String avaiabilityStatus = rs.getString("Availibility_Status");

				// addding data in table
				model.addRow(new Object[] { roomId, roomType, roomPrice, avaiabilityStatus });
			}

			rs.close();
			conn.close();// closing the connection
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());// to get error message
		}

		return model; // returing the model
	}

	public static DefaultTableModel getAllRoomData() {

		// Connection details for MySQL Database
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "Room_NO", "Room_Type", "Room_Price", "Availability Status" });

		// query to select all data from room
		String sqlQuery = "SELECT * FROM room " +
				"ORDER BY CASE Room_Type " +
				"WHEN 'Single Room' THEN 1 " +
				"WHEN 'Double Room' THEN 2 " +
				"WHEN 'Twin Room' THEN 3 " +
				"END";
		try {

			Connection conn = DriverManager.getConnection(url, userName, passWord);

			PreparedStatement stmt = conn.prepareStatement(sqlQuery);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				int roomId = rs.getInt("Room_ID");
				String roomType = rs.getString("Room_Type");
				int roomPrice = rs.getInt("Room_Price");
				String avaiabilityStatus = rs.getString("Availibility_Status");

				// addding data to the model
				model.addRow(new Object[] { roomId, roomType, roomPrice, avaiabilityStatus });
			}

			rs.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage()); //to get error message
		}
		return model;
	}
}
