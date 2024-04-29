package Test;

import org.testng.annotations.Test;

import dao.DonorCRUDDao;
import model.Donor;

import static org.testng.Assert.*;

public class DonorCRUDTest {

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
}