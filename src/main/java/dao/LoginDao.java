package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	private String user,firstName;
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
            adminStatement.setString(1, username);
            adminStatement.setString(2, password);
            ResultSet adminResult = adminStatement.executeQuery();
            if (donorResult.next()) {
            	
                user = "Donor"; // Return "Donor" if authenticated as a donor
            }else if(adminResult.next()){
            	
            	user = "Admin";// Return "Admin" if authenticated as an admin
            }
            else {
            	 user =  "Invalid";// Return "Invalid" if not authenticated
            }

         
            donorStatement.close();
            adminStatement.close();
            adminResult.close();
            donorResult.close();
            conn.close();
           
        } catch (SQLException e) {
            e.printStackTrace();
            user =  "Error";
        }
        return user;
    }
    public String getFirstName(String id) {
        try (
        	Connection conn = DbConnection.getConnection();
            PreparedStatement donorStatement = conn.prepareStatement("SELECT firstName FROM donors WHERE NIC = ?");
            PreparedStatement adminStatement = conn.prepareStatement("SELECT first_name FROM admin WHERE username = ? ")
        ) {
            // Check in donor table
            donorStatement.setString(1, id);
            
            ResultSet donorResult = donorStatement.executeQuery();
            adminStatement.setString(1, id);
            
            ResultSet adminResult = adminStatement.executeQuery();
            if (donorResult.next()) {
            	
                firstName = donorResult.getString("firstName"); // Retrive Donor First name
            }else if(adminResult.next()){
            	
            	firstName = adminResult.getString("first_name"); // Retrive admin First name
            }
            else {
            	firstName =  "unknown";// Return "unknown" if not authenticated
            }

           
            
            donorStatement.close();
            adminStatement.close();
            adminResult.close();
            donorResult.close();
            conn.close();
           
        } catch (SQLException e) {
            e.printStackTrace();
            user =  "unknown";
        }
        return firstName;
    }
    
}
	

