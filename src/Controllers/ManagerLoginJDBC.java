package Controllers;

//import all the necessary libraries and classes for the GUI
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagerLoginJDBC {

    public static boolean checkCredentials(String username, String password) {
        try {
            // connect to database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
            // query to select data from manager table
            String query = "SELECT * FROM manager WHERE ManagerUsername = '" + username + "' AND ManagerPassword = '"
                    + password + "'";

            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet rs = stmt.executeQuery(query);

            // check if query returned any results
            boolean found = rs.next();

            // close resources
            rs.close();
            stmt.close();
            conn.close();

            // return result
            return found;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage()); // to get error message
            return false;
        }
    }
}
