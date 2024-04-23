package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Donation;




public class DonationCRUDDao {
	
	private static final String insertDonation = "INSERT INTO donations (nic, date, city, bloodType) VALUES (?, ?, ?, ?)";
	private static final String searchDonation = "SELECT * FROM donations WHERE bloodtype = ? ORDER BY city, date DESC ";
	private static final String deleteDonation = "DELETE FROM donations WHERE id = ?";
	private static final String donationByDonor = "SELECT * FROM donations WHERE nic = ? ORDER BY city, date DESC ";
	private ArrayList<Donation> donationList = new ArrayList<Donation>();
	
	public ArrayList<Donation> donationsByDonor(String username) {
		 try {
			
			 Connection conn = DbConnection.getConnection();
			 PreparedStatement preparedStatement = conn.prepareStatement(donationByDonor);
			 preparedStatement.setString(1, username);
			 ResultSet resultSet = preparedStatement.executeQuery();

			 while (resultSet.next()) {
				 int id = resultSet.getInt("id");
				 String nic = resultSet.getString("nic");
			     Date date = resultSet.getDate("date");
			     String city = resultSet.getString("city");
			     String bloodType = resultSet.getString("bloodType");

			     donationList.add(new Donation(id,nic,date,city,bloodType));
			 }

			 // Close resources
			 resultSet.close();
			 preparedStatement.close();
			 conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
	     return donationList;
	 }
	
	public ArrayList<Donation> clearDonations() {
		if(donationList!= null) {
			donationList.clear();
		}
		
		return donationList;
	 } 
	public boolean deleteDonation(int donationId) throws SQLException {
	        boolean rowDeleted;
	        try (Connection conn = DbConnection.getConnection();
	                PreparedStatement preparedStatement = conn.prepareStatement(deleteDonation);)
	        {
	        	preparedStatement.setInt(1, donationId);
	            rowDeleted = preparedStatement.executeUpdate() > 0;
	            conn.close();
	            preparedStatement.close();
	        }
	        
	        return rowDeleted;
	    }
	public ArrayList<Donation> donations(String bType) {
		 try {
			
			 Connection conn = DbConnection.getConnection();
			 PreparedStatement preparedStatement = conn.prepareStatement(searchDonation);
			 preparedStatement.setString(1, bType);
			 ResultSet resultSet = preparedStatement.executeQuery();

			 while (resultSet.next()) {
				 int id = resultSet.getInt("id");
				 String nic = resultSet.getString("nic");
			     Date date = resultSet.getDate("date");
			     String city = resultSet.getString("city");
			     String bloodType = resultSet.getString("bloodType");

			     donationList.add(new Donation(id,nic,date,city,bloodType));
			 }

			 // Close resources
			 resultSet.close();
			 preparedStatement.close();
			 conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    
	     return donationList;
	 }
	public boolean insertDonation(String nic, Date date, String city, String bloodType) {
        boolean isSuccess = false;
        try (
            Connection conn = DbConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(insertDonation);
        ) {
        	preparedStatement.setString(1, nic);
            preparedStatement.setDate(2, new java.sql.Date(date.getTime()));
            preparedStatement.setString(3, city);
            preparedStatement.setString(4, bloodType);

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

}
