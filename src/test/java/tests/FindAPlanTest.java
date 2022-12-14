package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindAPlanTest extends BaseTest {

    @Test(groups = {"negative"})
    @Description("Choosing a training plan and trying to pay for it")
    public void negativePlanCheckoutTest() {
        loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(homePage.isPageOpened());
        homePage.moveToTrainingPlansMenu();
        homePage.clickFindAPlanButton();
        Assert.assertTrue(trainingPlansPage.isPageOpened());
        trainingPlansPage.clickTrainingPlan();
        coachPage.isPageOpened();
        coachPage.clickContinueCheckoutButton();
        coachPage.clickLoginButton();
        coachPage.login(EMAIL, PASSWORD);
        checkoutPage.waitForElementDisplayed();
        checkoutPage.enterCardDataAndClickPayButton(FAKE_GENERATED_CARD_NUMBER, FAKE_GENERATED_EXPIRY_DATE, FAKE_GENERATED_CVC);
        checkoutPage.waitForPayButtonIsClickable();
        checkoutPage.clickPayButton();
        checkoutPage.waitForErrorMessageVisible();
        Assert.assertTrue(checkoutPage.isCardNumberInvalid());
    }
}
