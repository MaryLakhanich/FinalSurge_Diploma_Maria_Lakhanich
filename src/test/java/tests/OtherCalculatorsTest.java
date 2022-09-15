package tests;

import modals.CaloricNeedsCalculatorModal;
import modals.PaceCalculatorModal;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OtherCalculatorsTest extends BaseTest{
    protected PaceCalculatorModal paceCalculatorModal;
    protected CaloricNeedsCalculatorModal caloricNeedsCalculatorModal;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        paceCalculatorModal = new PaceCalculatorModal(driver);
        caloricNeedsCalculatorModal = new CaloricNeedsCalculatorModal(driver);
    }
    @Test
    public void paceCalculatorTest(){
        loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(homePage.isPageOpened());
        homePage.clickCalculatorsButton();
        homePage.switchToIframe();
        paceCalculatorModal.clickPaceCalculatorButton();
        paceCalculatorModal.fillForm();
        paceCalculatorModal.clickCalculateButton();
        Assert.assertTrue(paceCalculatorModal.isPaceChartTableVisible());
        Assert.assertTrue(paceCalculatorModal.isPaceSplitsTableVisible());

    }
    @Test
    public void negativeCaloricNeedsCalculatorTestWithoutGender() {
        loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(homePage.isPageOpened());
        homePage.clickCalculatorsButton();
        homePage.switchToIframe();
        caloricNeedsCalculatorModal.fillFormWithoutGender();
        caloricNeedsCalculatorModal.clickCaloricCalculatorNeedsButton();
        caloricNeedsCalculatorModal.waitForErrorMessageVisible();
        Assert.assertTrue(caloricNeedsCalculatorModal.isModalNotCompletelyFilled());
    }
}
