package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DailyVitalsTest extends BaseTest {
    protected final static String START_DATE = "8/25/2022";
    protected final static String END_DATE = "9/2/2022";

    @Test(groups = {"smoke"})
    @Description("Checking if data is displayed for the correct period")
    public void CustomViewTest() {
        loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(homePage.isPageOpened());
        homePage.moveToDailyVitalsMenu();
        homePage.clickViewAndAddVitalsButton();
        Assert.assertTrue(dailyVitalsPage.isPageOpened());
        dailyVitalsPage.clickCustomViewButton();
        dailyVitalsPage.setPeriod(START_DATE, END_DATE);
        dailyVitalsPage.clickViewButton();
        Assert.assertEquals(dailyVitalsPage.getLastDate(), END_DATE);
        Assert.assertEquals(dailyVitalsPage.geFirstDate(),START_DATE);
    }
}
