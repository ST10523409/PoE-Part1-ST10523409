

import com.mycompany.progpoe.Part1Login;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Part1LoginTest {
    
   @Test
   public void testUsernameCorrectlyFormatted() {
       Part1Login user = new Part1Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
       
       boolean login = user.loginUser("kyl_1", "Ch&&sec@ake99!");
       String result = user.returnLoginStatus(login);
       
        assertEquals("Welcome Kyle, Smith it is great to see you again.", result);
    
   }//end testUsernameCorrectlyFormatted
   
   @Test
    public void testUsernameIncorrectlyFormatted() {
        Part1Login user = new Part1Login("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");

        String result = user.registerUser();

        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }//end testUsernameIncorrectlyFormatted

    @Test
    public void testPasswordMeetsComplexity() {
        Part1Login user = new Part1Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");

        String result = user.registerUser();

        assertEquals("Registration successful.", result);
    }//end testPasswordMeetsComplexity

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        Part1Login user = new Part1Login("kyl_1", "password", "+27838968976", "Kyle", "Smith");

        String result = user.registerUser();

        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", result);
    }//end testPasswordDoesNotMeetComplexity

    @Test
    public void testCellPhoneCorrectlyFormatted() {
        Part1Login user = new Part1Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");

        String result = user.registerUser();

        assertEquals("Registration successful.", result);
    }//end testCellPhoneCorrectlyFormatted

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        Part1Login user = new Part1Login("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Smith");

        String result = user.registerUser();

        assertEquals("Cell phone number incorrectly formatted or does not contain international code.", result);
    }//end testCellPhoneIncorrectlyFormatted
    
    
    
    
    
    @Test
    public void testLoginSuccessful() {
        Part1Login user = new Part1Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");

        assertTrue(user.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }//end testLoginSuccessful

    @Test
    public void testLoginFailed() {
        Part1Login user = new Part1Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");

        assertFalse(user.loginUser("wrong", "wrong"));
    }//end testLoginFailed

    @Test
    public void testUsernameValid() {
        Part1Login user = new Part1Login("kyl_1", "Password1!", "+27838968976", "Kyle", "Smith");

        assertTrue(user.checkUserName());
    }//end testUsernameValid

    @Test
    public void testUsernameInvalid() {
        Part1Login user = new Part1Login("kyle!!!!!!!", "Password1!", "+27838968976", "Kyle", "Smith");

        assertFalse(user.checkUserName());
    }//end testUsernameInvalid

    @Test
    public void testPasswordValid() {
        Part1Login user = new Part1Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");

        assertTrue(user.checkPasswordComplexity());
    }//end testPasswordValid

    @Test
    public void testPasswordInvalid() {
        Part1Login user = new Part1Login("kyl_1", "password", "+27838968976", "Kyle", "Smith");

        assertFalse(user.checkPasswordComplexity());
    }//end testPasswordInvalid

    @Test
    public void testCellPhoneValid() {
        Part1Login user = new Part1Login("kyl_1", "Password1!", "+27838968976", "Kyle", "Smith");

        assertTrue(user.checkCellNumber());
    }//end testCellPhoneValid

    @Test
    public void testCellPhoneInvalid() {
        Part1Login user = new Part1Login("kyl_1", "Password1!", "08966553", "Kyle", "Smith");

        assertFalse(user.checkCellNumber());
    }//end testCellPhoneInvalid
    
    
    
    
    
    
}//end class
