package Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import dao.LoginDao;

public class LoginTest {
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
}
