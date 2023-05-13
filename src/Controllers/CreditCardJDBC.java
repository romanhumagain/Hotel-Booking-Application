package Controllers;

//import all the necessary libraries and classes for the GUI
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import models.CreditCard;

public class CreditCardJDBC {

	public static boolean cardData(CreditCard card) {

		boolean result = false;
		PreparedStatement prst;
		Connection connection;
		ResultSet resultSet;

		// Connection details for MySQL Database
		String url = "jdbc:mysql://localhost:3306/java";
		String userName = "root";
		String passWord = "";
		String checkCreditCard = "SELECT Card_ID FROM creditcard WHERE Customer_ID =?"; // to select card details of a
																																										// specific customer

		// query to insert into credit card
		String query = "INSERT INTO creditcard (Card_ID ,Card_Type ,CardHolderName ,Customer_ID) VALUES (?,?,?,?)";

		try {
			// connection with database
			connection = DriverManager.getConnection(url, userName, passWord);
			prst = connection.prepareStatement(checkCreditCard);
			prst.setInt(1, card.getCustomerId());

			ResultSet resultCheck = prst.executeQuery();
			if (resultCheck.next()) {
				JOptionPane.showMessageDialog(null, "You Have Already Provided Card Details", "Alert",
						JOptionPane.WARNING_MESSAGE);
			} else {
				prst = connection.prepareStatement(query);
				prst.setString(1, card.getCardNumber());
				prst.setString(2, card.getCardType());
				prst.setString(3, card.getCardHolderName());
				prst.setInt(4, card.getCustomerId());
				prst.executeUpdate();
				result = true;
			}
			prst.close();
			connection.close();

		} catch (SQLException ex) {
			System.out.println("ERROR :" + ex.getMessage());// to get error message
			result = false;
		}
		return result;
	}
}
