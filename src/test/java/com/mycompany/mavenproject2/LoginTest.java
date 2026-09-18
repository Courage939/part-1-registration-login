package com.mycompany.mavenproject2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    public void testValidUsername() {
        Login login = new Login(
                "Kyle", "Smith", "kyl_1",
                "Ch&&sec@ke99!", "+27838968976"
        );

        assertEquals(true, login.checkUserName());
    }

    @Test
    public void testInvalidUsername() {
        Login login = new Login(
                "Kyle", "Smith", "kyle!!!!!!",
                "Ch&&sec@ke99!", "+27838968976"
        );

        assertEquals(false, login.checkUserName());
    }

    @Test
    public void testValidPassword() {
        Login login = new Login(
                "Kyle", "Smith", "kyl_1",
                "Ch&&sec@ke99!", "+27838968976"
        );

        assertEquals(true, login.checkPasswordComplexity());
    }

    @Test
    public void testInvalidPassword() {
        Login login = new Login(
                "Kyle", "Smith", "kyl_1",
                "password", "+27838968976"
        );

        assertEquals(false, login.checkPasswordComplexity());
    }

    @Test
    public void testValidCellPhone() {
        Login login = new Login(
                "Kyle", "Smith", "kyl_1",
                "Ch&&sec@ke99!", "+27838968976"
        );

        assertEquals(true, login.checkCellPhoneNumber());
    }

    @Test
    public void testInvalidCellPhone() {
        Login login = new Login(
                "Kyle", "Smith", "kyl_1",
                "Ch&&sec@ke99!", "08966553"
        );

        assertEquals(false, login.checkCellPhoneNumber());
    }

    @Test
    public void testSuccessfulRegistration() {
        Login login = new Login(
                "Kyle", "Smith", "kyl_1",
                "Ch&&sec@ke99!", "+27838968976"
        );

        assertEquals(
                "User registered successfully.",
                login.registerUser()
        );
    }

    @Test
    public void testSuccessfulLogin() {
        Login login = new Login(
                "Kyle", "Smith", "kyl_1",
                "Ch&&sec@ke99!", "+27838968976"
        );

        assertEquals(
                true,
                login.loginUser("kyl_1", "Ch&&sec@ke99!")
        );
    }

    @Test
    public void testFailedLogin() {
        Login login = new Login(
                "Kyle", "Smith", "kyl_1",
                "Ch&&sec@ke99!", "+27838968976"
        );

        assertEquals(
                false,
                login.loginUser("wrong", "password")
        );
    }

    @Test
    public void testLoginStatus() {
        Login login = new Login(
                "Kyle", "Smith", "kyl_1",
                "Ch&&sec@ke99!", "+27838968976"
        );

        assertEquals(
                "Welcome Kyle, Smith it is great to see you again.",
                login.returnLoginStatus(
                        "kyl_1",
                        "Ch&&sec@ke99!"
                )
        );
    }
}
