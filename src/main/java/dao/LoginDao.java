package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	private String user;
    // Method to authenticate user
    public String authenticateUser(String username, String password) {
        try (
        	Connection conn = DbConnection.getConnection();
            PreparedStatement donorStatement = conn.prepareStatement("SELECT * FROM donors WHERE NIC = ? AND password = ?");
            PreparedStatement adminStatement = conn.prepareStatement("SELECT * FROM admin WHERE username = ? AND password =? ")
        ) {
            // Check in donor table
            donorStatement.setString(1, username);
            donorStatement.setString(2, password);
            ResultSet donorResult = donorStatement.executeQuery();
            if (donorResult.next()) {
            	
                user = "Donor"; // Return "Donor" if authenticated as a donor
            }

            // Check in admin table
            adminStatement.setString(1, username);
            adminStatement.setString(2, password);
            ResultSet adminResult = adminStatement.executeQuery();
            if (adminResult.next()) {
            	
                user = "Admin"; // Return "Admin" if authenticated as an admin
            }

            // Return "Invalid" if not authenticated
            donorStatement.close();
            adminStatement.close();
            adminResult.close();
            donorResult.close();
            conn.close();
            user =  "Invalid";
        } catch (SQLException e) {
            e.printStackTrace();
            user =  "Error";
        }
        return user;
    }

}
	

