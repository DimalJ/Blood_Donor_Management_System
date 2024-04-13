package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DonorCRUDDao {
	private static final String INSERT_DONOR_SQL = "INSERT INTO donors (firstName, lastName, city, birthday, bloodType, email, NIC, password, mobile) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String CHECK_NIC_SQL = "SELECT COUNT(*) AS count FROM donors WHERE NIC = ?";
	
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
