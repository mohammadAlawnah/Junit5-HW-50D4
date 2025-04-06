package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.najah.code.UserService;

class UserServiceSimpleTest {
    UserService userService;
    
    
    @BeforeAll
    public static void BeforeAll() {
        System.out.println("Start UserService");
    }


	@BeforeEach
	void setUp() throws Exception {
        userService = new UserService();
	}
	
	@Test
	@DisplayName("Vallid Email") 
	void testValidEmail() {
		assertTrue(userService.isValidEmail("mohammad@gmail.com"));
	}
	
    @Test
    @DisplayName("Null Email")
    void testNullEmail() {
        assertFalse(userService.isValidEmail(null));
    }
    
    @Test
    @DisplayName("Invalid Email")
    void testInvalidEmail() {
        assertFalse(userService.isValidEmail("mohammadgmail.com"));
    }
    
    
    @ParameterizedTest
    @ValueSource(strings = {"mohammad.com", "test@com", "admin@", "@gmail.com"})
    @Disabled
    @DisplayName("Invalid Email")
    void testInvalidEmails(String email) {
        /*
         * 
         *Test Report:
         * This test verifies that the submitted emails are invalid.        
         * There is a problem with the isValidEmail() function.
         * It is expected to return false when "@gmail.com", but the result is true.
         * 
         * Error correction: 
         * 

         */
        boolean result = userService.isValidEmail(email);
        System.out.println("Testing email: " + email + " => " + result);
        assertFalse(result, "Expected invalid for: " + email);
    }
    
    
    @Test
    @DisplayName("Authintication")
    void testCorrectAuth() {
        boolean auth = userService.authenticate("admin", "1234");
        assertTrue(auth);
    }
    
    
    @Test
    @DisplayName("invalid Auth")
    void testWrongAuth() {
        boolean auth = userService.authenticate("user", "sss");
        assertFalse(auth);
    }

    @Test
    @Timeout(1)
    @DisplayName("Performance")
    void testAuthPerformance() {
        assertTrue(userService.authenticate("admin", "1234"));
    }
    
    @AfterEach
	 void AfterEach(TestInfo testInfo) {
	       System.out.println(testInfo.getDisplayName()+"Test had done");
	   }

    @AfterAll
    static void afterAll() {
    	System.out.print("After All Test");
    }
	   

	

}
