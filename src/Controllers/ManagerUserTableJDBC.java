package Controllers;

//import all the necessary libraries and classes for the GUI
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

public class ManagerUserTableJDBC {

	public static DefaultTableModel getUserData() {
		// Connection details for MySQL Database
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		DefaultTableModel model = new DefaultTableModel();
		// adding column in the model
		model.setColumnIdentifiers(new String[] { "Customer Id", "Name", "DOB", "Address", "Email", "Country", "Cust Type",
				"Card No", "Comp_Name", "Comp_Contact" });

		// query to get customer and creditcard details using LEFT JOIN
		String sqlQuery = "SELECT customer.*, creditcard.Card_ID FROM customer LEFT JOIN creditcard ON customer.Customer_ID = creditcard.Customer_ID";

		try {

			Connection conn = DriverManager.getConnection(url, userName, passWord);

			PreparedStatement stmt = conn.prepareStatement(sqlQuery);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				// to get data from database table
				String fullName = rs.getString("Full_Name");
				int customerId = rs.getInt("Customer_ID");
				String DOB = rs.getString("Date_Of_Birth");
				String address = rs.getString("Address");
				String email = rs.getString("Email");
				String country = rs.getString("Country");
				String customerType = rs.getString("Customer_Type");
				String cardNo = rs.getString("Card_ID");
				String companyName = rs.getString("Company_Name");
				String companyContact = rs.getString("Company_Contact");

				// adding data in the model
				model.addRow(new Object[] { customerId, fullName, DOB, address, email, country, customerType, cardNo,
						companyName, companyContact });
			}

			rs.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage()); // to get error message
		}
		return model;
	}
}
