package Test;

import org.testng.annotations.Test;

import dao.CampaignCRUDDao;
import dao.DonationCRUDDao;
import dao.DonorCRUDDao;
import dao.LoginDao;
import model.Donor;

import static org.testng.Assert.*;

import java.sql.SQLException;

public class UnitTest {
	@Test
    public void testLogin() {
        // Arrange: Prepare test data and dependencies
        LoginDao loginDao = new LoginDao();
        
        // Act: Call the method you want to test
        String user = loginDao.authenticateUser("19981061748", "12345678"); // Assuming 1 is the ID of the donor to retrieve
        
        // Assert: Verify the result
        assertNotNull(user); // Assert that the donor object is not null
        assertEquals("Donor", user); // Assert that the donor ID is as expected
        // Add more assertions for other attributes of the donor object if needed
    }
	
	@Test
    public void testgetAdminType() {
        // Arrange: Prepare test data and dependencies
        LoginDao loginDao = new LoginDao();
        
        // Act: Call the method you want to test
        String user = loginDao.userType("admin"); // Assuming 1 is the ID of the donor to retrieve
        
        // Assert: Verify the result
        assertNotNull(user); // Assert that the donor object is not null
        assertEquals("Admin", user); // Assert that the donor ID is as expected
        // Add more assertions for other attributes of the donor object if needed
    }
	@Test
    public void testgetDonorType() {
        // Arrange: Prepare test data and dependencies
        LoginDao loginDao = new LoginDao();
        
        // Act: Call the method you want to test
        String user = loginDao.userType("19981061748"); // Assuming 1 is the ID of the donor to retrieve
        
        // Assert: Verify the result
        assertNotNull(user); // Assert that the donor object is not null
        assertEquals("Donor", user); // Assert that the donor ID is as expected
        // Add more assertions for other attributes of the donor object if needed
    }
    @Test
    public void testGetDonor() {
        // Arrange: Prepare test data and dependencies
        DonorCRUDDao donorCRUD = new DonorCRUDDao();
        
        // Act: Call the method you want to test
        Donor donor = donorCRUD.getDonor(14); // Assuming 1 is the ID of the donor to retrieve
        
        // Assert: Verify the result
        assertNotNull(donor); // Assert that the donor object is not null
        assertEquals(donor.getId(), 14); // Assert that the donor ID is as expected
        // Add more assertions for other attributes of the donor object if needed
    }
    @Test
    public void testNicUsed() {
        // Arrange: Prepare test data and dependencies
        DonorCRUDDao donorCRUD = new DonorCRUDDao();
        
        // Act: Call the method you want to test
       boolean used = donorCRUD.isNICUsed("19981061748"); // Assuming 1 is the ID of the donor to retrieve
        
        // Assert: Verify the result
        assertNotNull(used); // Assert that the donor object is not null
        assertEquals(true, used); // Assert that the donor ID is as expected
        // Add more assertions for other attributes of the donor object if needed
    }
    @Test
    public void testCampaignDeleted() throws SQLException {
        // Arrange: Prepare test data and dependencies
        CampaignCRUDDao campaignCRUD = new CampaignCRUDDao();
        
        // Act: Call the method you want to test
       boolean delete =campaignCRUD.deleteCampaign(9); // Assuming 1 is the ID of the donor to retrieve
        
        // Assert: Verify the result
        assertNotNull(delete); // Assert that the donor object is not null
        assertEquals(false, delete); // Assert that the donor ID is as expected
        // Add more assertions for other attributes of the donor object if needed
    }
    @Test
    public void testDonationDeleted() throws SQLException {
        // Arrange: Prepare test data and dependencies
        DonationCRUDDao donation = new DonationCRUDDao();
        
        // Act: Call the method you want to test
       boolean delete =donation.deleteDonation(1); // Assuming 1 is the ID of the donor to retrieve
        
        // Assert: Verify the result
        assertNotNull(delete); // Assert that the donor object is not null
        assertEquals(false, delete); // Assert that the donor ID is as expected
        // Add more assertions for other attributes of the donor object if needed
    }
}