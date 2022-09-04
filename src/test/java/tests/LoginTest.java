package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private final static String expectedLogoutMessageText = "You have been successfully logged out of the system.";

    @Test
    public void positiveLoginTest() {
        loginPage.Login(EMAIL, PASSWORD);
        Assert.assertTrue(homePage.isPageOpened(), "Account Login has failed, home page isn't opened");
    }

    @DataProvider
    public Object[][] negativeDataForLoginTest() {
        return new Object[][]{
                {" ", " "},
                {EMAIL, " "},
                {" ", PASSWORD},
                {EMAIL, "555"},
                {"amigo@mail.ru", PASSWORD}
        };
    }

    @Test(dataProvider = "negativeDataForLoginTest")
    public void negativeLoginTest(String email, String password) {
        loginPage.Login(email, password);
        Assert.assertTrue(loginPage.isPageOpened());
    }

    @Test
    public void logoutTest() {
        loginPage.Login(EMAIL, PASSWORD);
        homePage.isPageOpened();
        homePage.clickLogoutButton();
        Assert.assertEquals(loginPage.getLogoutMessageText(), expectedLogoutMessageText);
    }
}
