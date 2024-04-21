package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Campaign;


public class CampaignListDao {

public ArrayList<Campaign> CampaignList = new ArrayList<Campaign>();
java.sql.Date currentDate = new java.sql.Date(new Date().getTime());
String allCampaigns = "SELECT * FROM donation_campaigns WHERE date >= ? ORDER BY date ASC";
String campaignsByCity = "SELECT * FROM donation_campaigns WHERE city= ? AND date >= ? ORDER BY date ASC";
	 
public ArrayList<Campaign> getCampaignByCity(String userCity) {
	 try {
		
		 Connection conn = DbConnection.getConnection();
		 PreparedStatement preparedStatement = conn.prepareStatement(campaignsByCity);
		 preparedStatement.setString(1, userCity);
		 preparedStatement.setDate(2, currentDate);

		 // Execute the query
		 ResultSet resultSet = preparedStatement.executeQuery();

		 // Iterate through the result set
		 while (resultSet.next()) {
			 int id = resultSet.getInt("id");
		     Date date = resultSet.getDate("date");
		     String location = resultSet.getString("location");
		     String city = resultSet.getString("city");

		     // Create Campaign object and add it to the list
		     CampaignList.add(new Campaign(id, date, location, city));
		 }

		 // Close resources
		 resultSet.close();
		 preparedStatement.close();
		 conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    return CampaignList;
}

	
	public ArrayList<Campaign> getCampaignList() {
		 try {
			
			 Connection conn = DbConnection.getConnection();
			 PreparedStatement preparedStatement = conn.prepareStatement(allCampaigns);
			 preparedStatement.setDate(1, currentDate);

			 // Execute the query
			 ResultSet resultSet = preparedStatement.executeQuery();

			 // Iterate through the result set
			 while (resultSet.next()) {
				 int id = resultSet.getInt("id");
			     Date date = resultSet.getDate("date");
			     String location = resultSet.getString("location");
			     String city = resultSet.getString("city");

			     // Create Campaign object and add it to the list
			     CampaignList.add(new Campaign(id, date, location, city));
			 }

			 // Close resources
			 resultSet.close();
			 preparedStatement.close();
			 conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
	     return CampaignList;
	 }
	 
	 public ArrayList<Campaign> clearCampaigns() {
		CampaignList.clear();
		
		return CampaignList;
	 }
	}
