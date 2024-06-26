package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class LoginDao {
	PasswordHashDao ph;
	private String firstName;
	String StoredPassword=null;
    // Method to authenticate user
	
	public String userType(String username) {
		String user="";
		 try (
		        	Connection conn = DbConnection.getConnection();
		            PreparedStatement donorStatement = conn.prepareStatement("SELECT * FROM donors WHERE NIC = ?");
		            PreparedStatement adminStatement = conn.prepareStatement("SELECT * FROM admin WHERE username = ?")
		        ) {
		            // Check in donor table
		            donorStatement.setString(1, username);
		            
		            ResultSet donorResult = donorStatement.executeQuery();
		            adminStatement.setString(1, username);
		           
		            ResultSet adminResult = adminStatement.executeQuery();
		            if (donorResult.next()) {
		                    user = "Donor";
		                
		            }else if(adminResult.next()){
		                    	user = "Admin";
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
	
    public String authenticateUser(String username, String password) {
    	String user="";
    	
    	try (
        	Connection conn = DbConnection.getConnection();
            PreparedStatement donorStatement = conn.prepareStatement("SELECT * FROM donors WHERE NIC = ?");
            PreparedStatement adminStatement = conn.prepareStatement("SELECT * FROM admin WHERE username = ?")
        ) {
            // Check in donor table
            donorStatement.setString(1, username);
            
            ResultSet donorResult = donorStatement.executeQuery();
            adminStatement.setString(1, username);
           
            ResultSet adminResult = adminStatement.executeQuery();
            if (donorResult.next()) {
            	StoredPassword =donorResult.getString("password");
            	
            	if (StoredPassword != null) {
                    // Verify the hashed password
                    BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), StoredPassword);
                    if(result.verified) {
                    	user = "Donor";// Return "Donor" if authenticated as an Donor
                    }
            		
            	}
               
            }
            if(adminResult.next()){
            	StoredPassword =adminResult.getString("password");
            	if (StoredPassword != null) {
                    // Verify the hashed password
            		
                    BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), StoredPassword);
                    if(result.verified) {
                    	user = "Admin";// Return "Admin" if authenticated as an admin
                    }
            		
            	}
            	
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
            firstName =  "unknown";
        }
        return firstName;
    }
    
}
	

