package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Donor;

public class DonorCRUDDao {
	private static final String INSERT_DONOR_SQL = "INSERT INTO donors (firstName, lastName, city, birthday, bloodType, email, NIC, password, mobile) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String CHECK_NIC_SQL = "SELECT COUNT(*) AS count FROM donors WHERE NIC = ?";
	private static final String searchId = "SELECT NIC, firstName, lastName FROM donors WHERE NIC = ?";
	private static final String searchName = "SELECT id, NIC, firstName, lastName FROM donors WHERE firstName LIKE ? OR lastName LIKE ?";
	private static final String deleteDonor = "DELETE FROM donors WHERE id = ?";
	private static final String getDonor = "SELECT * FROM donors WHERE id = ?";
	private static final String DonorByNic = "SELECT * FROM donors WHERE NIC = ?";
	
	private static final String updateDonor = "UPDATE donors SET firstName= ?, lastName= ?, city= ?, birthday= ?, bloodType= ?, email= ?, NIC= ?, password= ?, mobile= ? WHERE id = ?";
	private  ArrayList<Donor> donors = new ArrayList<Donor>();
	private Donor donor;
	
public ArrayList<Donor> clearDonors() {
	if(donors!= null) {
		donors.clear();
	}
	
	return donors;
 }
public Donor getDonorByNic(String nic) {
    
    try (
    		Connection conn = DbConnection.getConnection();
  			PreparedStatement ps = conn.prepareStatement(DonorByNic);
    	){	
	        	
	        	ps.setString(1, nic);
	        	
	            
            ResultSet resultSet = ps.executeQuery(); {
            if (resultSet.next()) {
            	int donorId = resultSet.getInt("id");
            	String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String city = resultSet.getString("city");
                String birthday = resultSet.getString("birthday");
                String bloodType = resultSet.getString("bloodType");
                String email = resultSet.getString("email");
                String NIC = resultSet.getString("NIC");
                String password = resultSet.getString("password");
                String mobile = resultSet.getString("mobile");
                
                
                donor = new Donor(donorId, firstName, lastName, city, birthday,bloodType,email,NIC,password,mobile);
                
                
            }else {
            	donors=null;
            }
            }
            conn.close();
            ps.close();
            resultSet.close();
    	 }catch (SQLException e) {
             e.printStackTrace();
         }
        
    
    return donor;
}
public boolean updateCampaign(int id, String firstName, String lastName, String city, String birthday, String bloodType, String email, String nic, String password, String mobile) {
    boolean isSuccess = false;
    try (
        Connection conn = DbConnection.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(updateDonor);
    ) {
    	preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, city);
        preparedStatement.setString(4,  birthday);
        preparedStatement.setString(5, bloodType);
        preparedStatement.setString(6, email);
        preparedStatement.setString(7, nic);
        preparedStatement.setString(8, password);
        preparedStatement.setString(9, mobile);
        preparedStatement.setInt(10, id);

        int rowsInserted = preparedStatement.executeUpdate();
        if (rowsInserted > 0) {
            isSuccess = true;
        }
        conn.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return isSuccess;
}
public Donor getDonor(int id) {
    
    try (
    		Connection conn = DbConnection.getConnection();
  			PreparedStatement ps = conn.prepareStatement(getDonor);
    	){	
	        	
	        	ps.setInt(1, id);
	        	
	            
            ResultSet resultSet = ps.executeQuery(); {
            if (resultSet.next()) {
            	int donorId = resultSet.getInt("id");
            	String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String city = resultSet.getString("city");
                String birthday = resultSet.getString("birthday");
                String bloodType = resultSet.getString("bloodType");
                String email = resultSet.getString("email");
                String NIC = resultSet.getString("NIC");
                String password = resultSet.getString("password");
                String mobile = resultSet.getString("mobile");
                
                
                donor = new Donor(donorId, firstName, lastName, city, birthday,bloodType,email,NIC,password,mobile);
                
                
            }else {
            	donors=null;
            }
            }
            conn.close();
            ps.close();
            resultSet.close();
    	 }catch (SQLException e) {
             e.printStackTrace();
         }
        
    
    return donor;
}
public boolean deleteDonor(int donorId) {
    boolean rowDeleted = false;
    try (Connection conn = DbConnection.getConnection();
         PreparedStatement preparedStatement = conn.prepareStatement(deleteDonor);)
    {
    	preparedStatement.setInt(1, donorId);
        rowDeleted = preparedStatement.executeUpdate() > 0;
        conn.close();
        preparedStatement.close();
    }catch (SQLException e) {
        e.printStackTrace();
    }
    
    return rowDeleted;
}
public ArrayList<Donor> searchByName(String name) {
        
        try (
        		Connection conn = DbConnection.getConnection();
      			PreparedStatement ps = conn.prepareStatement(searchName);
        	){	
		        	
		        	ps.setString(1, "%" + name + "%");
		        	ps.setString(2, "%" + name + "%");
		            
	            ResultSet resultSet = ps.executeQuery(); {
                if (resultSet.next()) {
                	int id = resultSet.getInt("id");
                    String NIC = resultSet.getString("NIC");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    
                   
                    donors.add(new Donor(id, NIC, firstName, lastName));
                    
                    
                }else {
                	donors=null;
                }
	            }
	            conn.close();
                ps.close();
                resultSet.close();
        	 }catch (SQLException e) {
                 e.printStackTrace();
             }
            
        
        return donors;
    }
public ArrayList<Donor> searchByNIC(String nic) {
        
        try (
        		Connection conn = DbConnection.getConnection();
      			PreparedStatement ps = conn.prepareStatement(searchId);
        	){	
		        	ps.setString(1, nic);
		        	
		            
	            ResultSet resultSet = ps.executeQuery(); {
                if (resultSet.next()) {
                	int id = resultSet.getInt("id");
                	String NIC = resultSet.getString("NIC");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                   
                    donors.add(new Donor(id,NIC, firstName, lastName));
                    
                    
                }else {
                	donors=null;
                }
	            }
	            conn.close();
                ps.close();
                resultSet.close();
        	 }catch (SQLException e) {
                 e.printStackTrace();
             }
            
        
        return donors;
    }

public ArrayList<Donor> searchDonors(String nic, String name) {
		if (nic == "") {
            if (name == "") {
                // Both NIC and name are null, so search by NIC
                return donors=null;
            } else {
                // NIC is null, search by name
                return searchByName(name);
            }
        } else {
            // NIC is not null, search by NIC
            return searchByNIC(nic);
        }

    }
public boolean isNICUsed(String nic) {
        boolean isUsed = false;
        try (
        		 Connection conn = DbConnection.getConnection();
      			 PreparedStatement preparedStatement = conn.prepareStatement(CHECK_NIC_SQL);
        ) {
        	preparedStatement.setString(1, nic);
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
	
	
public boolean insertDonor(String firstName, String lastName, String city, String birthday, String bloodType, String email, String nic, String password, String mobile) {
        boolean isSuccess = false;
        try (
        	 Connection conn = DbConnection.getConnection();
   			 PreparedStatement preparedStatement = conn.prepareStatement(INSERT_DONOR_SQL);
        ) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, city);
            preparedStatement.setString(4,  birthday);
            preparedStatement.setString(5, bloodType);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, nic);
            preparedStatement.setString(8, password);
            preparedStatement.setString(9, mobile);

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
