package application;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTest extends Login {

    private Login login;
    @Before
    public void setUp() {
        login = new Login();
        
    }
    public String getUserID() {
        return UserID;
    }

    @Test
    public void testCheckLoginSuccessful() {
        // Sets the test values
        login.getUserIDField().setText("user1");
        login.getPasswordField().setText("12345");
        // Calls test method
        try {
            login.checkLogin();
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testCheckLoginUnsuccessful() {
        // Set the test values
        login.getUserIDField().setText("user1");
        login.getPasswordField().setText("WRONGPASSWORD");

        // Calls test method
        try {
            login.checkLogin();
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }
}
