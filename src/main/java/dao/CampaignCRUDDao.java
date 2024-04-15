package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class CampaignCRUDDao {

	private static final String addCampaign = "INSERT INTO donation_campaigns (date, location, city) VALUES (?, ?, ?)";
	private static final String deleteCampaign = "DELETE FROM donation_campaigns WHERE id = ?";
	private  static final String updateCampaign = "UPDATE donation_campaigns SET date = ?, location = ?, city = ? WHERE id = ?";
    
	public boolean updateCampaign(int id, Date date, String location, String city) {
        boolean isSuccess = false;
        try (
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(updateCampaign);
        ) {
        	ps.setDate(1, new java.sql.Date(date.getTime()));
        	ps.setString(2, location);
        	ps.setString(3, city);
        	ps.setInt(4, id);

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                isSuccess = true;
            }
            conn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
	public boolean insertCampaign(Date date, String location, String city) {
        boolean isSuccess = false;
        try (
            Connection conn = DbConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(addCampaign);
        ) {
            preparedStatement.setDate(1, new java.sql.Date(date.getTime()));
            preparedStatement.setString(2, location);
            preparedStatement.setString(3, city);

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
	

    public boolean deleteCampaign(int campaignId) throws SQLException {
        boolean rowDeleted;
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(deleteCampaign);)
        {
        	preparedStatement.setInt(1, campaignId);
            rowDeleted = preparedStatement.executeUpdate() > 0;
            conn.close();
            preparedStatement.close();
        }
        
        return rowDeleted;
    }
}

