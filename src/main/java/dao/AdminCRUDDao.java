package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Admin;

public class AdminCRUDDao {

	private static final String insertAdmin = "INSERT INTO admin (first_name, last_name, username, password) VALUES (?, ?, ?, ?)";
	private static final String checkUsername = "SELECT COUNT(*) AS count FROM admin WHERE username = ?";
	private static final String searchId = "SELECT id, first_name, last_name, username  FROM admin WHERE username = ?";
	private static final String searchName = "SELECT id, first_name, last_name, username FROM admin WHERE first_name LIKE ? OR last_name LIKE ?";
	private static final String deleteAdmin = "DELETE FROM admin WHERE id = ?";
	private static final int password= 1234;
	
	private  ArrayList<Admin> admins = new ArrayList<Admin>();
	
	
	
	public int deleteAdmin(int userPassword, int adminId) {
	   
	   if(userPassword==password) {
		   boolean rowDeleted = false;
		    try (Connection conn = DbConnection.getConnection();
		         PreparedStatement preparedStatement = conn.prepareStatement(deleteAdmin);)
		    {
		    	preparedStatement.setInt(1, adminId);
		        rowDeleted = preparedStatement.executeUpdate() > 0;
		        conn.close();
		        preparedStatement.close();
		    }catch (SQLException e) {
		        e.printStackTrace();
		    }
			    if(rowDeleted) {
			    	return 1;
			    }else {
			    	return 2;
			    }
	   }else {
		   return 3;
	   }
	    
	}
	
	public ArrayList<Admin> clearAdmins() {
		if(admins!= null) {
			admins.clear();
		}
		
		return admins;
	 }
	public ArrayList<Admin> searchDonors(String username, String name) {
		if (username == "") {
            if (name == "") {
                // Both NIC and name are null, so search by NIC
                return admins=null;
            } else {
                // NIC is null, search by name
                return searchByName(name);
            }
        } else {
            // NIC is not null, search by NIC
            return searchByNIC(username);
        }

    }
	public ArrayList<Admin> searchByNIC(String adminUsername) {
	        
	        try (
	        		Connection conn = DbConnection.getConnection();
	      			PreparedStatement ps = conn.prepareStatement(searchId);
	        	){	
			        	ps.setString(1, adminUsername);
			        	
			            
		            ResultSet resultSet = ps.executeQuery(); {
	                if (resultSet.next()) {
	                	int id = resultSet.getInt("id");
	                    String firstName = resultSet.getString("first_name");
	                    String lastName = resultSet.getString("last_name");
	                    String username = resultSet.getString("username");
	                   
	                    admins.add(new Admin(id,firstName, lastName,username));
	                    
	                    
	                }else {
	                	admins=null;
	                }
		            }
		            conn.close();
	                ps.close();
	                resultSet.close();
	        	 }catch (SQLException e) {
	                 e.printStackTrace();
	             }
	            
	        
	        return admins;
	    }	
	public ArrayList<Admin> searchByName(String name) {
	        
	        try (
	        		Connection conn = DbConnection.getConnection();
	      			PreparedStatement ps = conn.prepareStatement(searchName);
	        	){	
			        	
			        	ps.setString(1, "%" + name + "%");
			        	ps.setString(2, "%" + name + "%");
			            
		            ResultSet resultSet = ps.executeQuery(); {
	                if (resultSet.next()) {
	                	int id = resultSet.getInt("id");
	                    String firstName = resultSet.getString("first_name");
	                    String lastName = resultSet.getString("last_name");
	                    String username = resultSet.getString("username");
	                   
	                    admins.add(new Admin(id,firstName, lastName,username));
	                    
	                    
	                }else {
	                	admins=null;
	                }
		            }
		            conn.close();
	                ps.close();
	                resultSet.close();
	        	 }catch (SQLException e) {
	                 e.printStackTrace();
	             }
	            
	        
	        return admins;
	    }
	public boolean isUsernameUsed(String username) {
        boolean isUsed = false;
        try (
        		 Connection conn = DbConnection.getConnection();
      			 PreparedStatement preparedStatement = conn.prepareStatement(checkUsername);
        ) {
        	preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt("count");
            if (count > 0) {
                isUsed = true;
            }
            resultSet.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUsed;
    }
	public boolean insertAdmin(String firstName, String lastName, String username, String password) {
        boolean isSuccess = false;
        try (
        	 Connection conn = DbConnection.getConnection();
   			 PreparedStatement preparedStatement = conn.prepareStatement(insertAdmin);
        ) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, password);
            
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                isSuccess = true;
            }
			 preparedStatement.close();
			 conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

}
