package Controllers;

//import all the necessary libraries and classes for the GUI
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import models.Bill;
import models.Booking;

public class BillingTableJDBC {
	// Method to retrieve data from database and populate it in a table model
	public static DefaultTableModel getData(int customerId) {

		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "Booking Id", "Name", "Total Amount", "Payment Status" });

		// sql query to get data
		String sqlQuery = "SELECT c.Customer_ID, c.Full_Name, b.Booking_ID, b.Payment_Status, bill.Bill_Number, bill.Amount "
				+
				"FROM customer c " +
				"INNER JOIN booking b ON c.Customer_ID = b.Customer_ID " +
				"INNER JOIN bill ON b.Booking_ID = bill.Booking_ID " +
				"WHERE c.Customer_ID = ?";

		try {
			// connection with database
			Connection conn = DriverManager.getConnection(url, userName, passWord);

			PreparedStatement stmt = conn.prepareStatement(sqlQuery);

			stmt.setInt(1, customerId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int bookingID = rs.getInt("Booking_ID");
				String fullName = rs.getString("Full_Name");
				int totalAmount = rs.getInt("Amount");
				String paymentStatus = rs.getString("Payment_Status");

				model.addRow(new Object[] { bookingID, fullName, totalAmount, paymentStatus });// adding data in the tables row
			}

			rs.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());// to get error message
		}

		return model;
	}

	// for updating payment date

	public static boolean paymentDate(Bill bill) {

		boolean result = false;
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		PreparedStatement prst;
		Connection conn;

		// sql query to update bill
		String query = "UPDATE bill SET Payment_Date = ? ,Amount =? WHERE Booking_ID = ?";
		try {
			// connection with database
			conn = DriverManager.getConnection(url, userName, passWord);
			prst = conn.prepareStatement(query);
			prst.setString(1, bill.getPaymentDate());
			prst.setInt(2, bill.getTotalAmount());
			prst.setInt(3, bill.getBookingId());

			prst.executeUpdate();
			prst.close();
			conn.close();// closing connection

			result = true;
		} catch (Exception ex) {

			System.out.println("ERROR:" + ex.getMessage());// to get error message
			result = false;
		}
		return result;
	}
}
