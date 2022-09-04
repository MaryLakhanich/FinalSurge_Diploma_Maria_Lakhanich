package tests;

import org.testng.annotations.Test;

public class DailyVitalsTest extends BaseTest{

    @Test
    public void CustomViewTest(){
        loginPage.Login(EMAIL,PASSWORD);
        homePage.isPageOpened();
        homePage.moveToDailyVitalsMenu();
        homePage.clickViewAndAddVitalsButton();
        dailyVitalsPage.isPageOpened();
        dailyVitalsPage.clickCustomViewButton();
        dailyVitalsPage.clickViewButton();

    }

}
