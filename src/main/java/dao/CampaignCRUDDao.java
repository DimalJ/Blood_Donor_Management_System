package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class CampaignCRUDDao {

	private static final String addCampaign = "INSERT INTO donation_campaigns (date, location, city) VALUES (?, ?, ?)";

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
}
