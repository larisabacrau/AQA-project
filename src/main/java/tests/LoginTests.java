package tests;

import org.junit.Test;

import testdata.pages.LoginTD;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @Test
    public void validLogin() {
        loginPage.login(standardUser);
        assertEquals("Products", headerPage.getTitle());

    }
    @Test
    public void wrongUserLogin() {
        standardUser.setUsername("wrong_user");
        loginPage.login(standardUser);
        assertEquals("Epic sadface: Username is required", LoginTD.USERNAME_ERROR_MESSAGE);
    }

    @Test
    public void lockedOutLogin() {
        standardUser.setUsername("locked_out_user");
        loginPage.login(standardUser);
        assertEquals("Epic sadface: Sorry, this user has been locked out.",LoginTD.LOCKEDOUT_ERROR_MESSAGE);
    }
    @Test
    public void logout() {
        loginPage.login(standardUser);
        assertEquals("Products", headerPage.getTitle());
        headerPage.logout();
        assertTrue(loginPage.loginButtonCheck());
    }
}