package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private final static String expectedLogoutMessageText = "You have been successfully logged out of the system.";

    @Test(groups = {"regression"})
    @Description("Login test with correct data")
    public void positiveLoginTest() {
        loginPage.login(EMAIL, PASSWORD);
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

    @Test(dataProvider = "negativeDataForLoginTest", groups = {"negative"})
    @Description ("Checking if it is possible to login with incorrect data")
    public void negativeLoginTest(String email, String password) {
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.isPageOpened());
    }

    @Test (groups = {"regression"})
    @Description ("Positive log out test")
    public void logoutTest() {
        loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(homePage.isPageOpened());
        homePage.clickLogoutButton();
        Assert.assertEquals(loginPage.getLogoutMessageText(), expectedLogoutMessageText);
    }
}
