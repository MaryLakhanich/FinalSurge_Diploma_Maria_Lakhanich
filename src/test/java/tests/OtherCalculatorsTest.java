package tests;

import io.qameta.allure.Description;
import modals.CaloricNeedsCalculatorModal;
import modals.PaceCalculatorModal;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.CaloricNeedsCalculatorFactory;
import utils.PaceCalculatorFactory;

public class OtherCalculatorsTest extends BaseTest {
    protected PaceCalculatorModal paceCalculatorModal;
    protected CaloricNeedsCalculatorModal caloricNeedsCalculatorModal;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        paceCalculatorModal = new PaceCalculatorModal(driver);
        caloricNeedsCalculatorModal = new CaloricNeedsCalculatorModal(driver);
    }

    @Test(groups = {"smoke"})
    @Description("Checking pace calculating")
    public void paceCalculatorTest() {
        loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(homePage.isPageOpened());
        homePage.clickCalculatorsButton();
        homePage.switchToIframe();
        paceCalculatorModal.clickPaceCalculatorButton();
        paceCalculatorModal.fillForm(PaceCalculatorFactory.getPaceCalculator());
        paceCalculatorModal.clickCalculateButton();
        Assert.assertTrue(paceCalculatorModal.isPaceChartTableVisible());
        Assert.assertTrue(paceCalculatorModal.isPaceSplitsTableVisible());

    }
    @Test (groups = {"negative"})
    @Description ("Checking if it is possible to calculate caloric needs without choosing gender")
    public void negativeCaloricNeedsCalculatorTestWithoutGender() {
        loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(homePage.isPageOpened());
        homePage.clickCalculatorsButton();
        homePage.switchToIframe();
        caloricNeedsCalculatorModal.fillFormWithoutGender(CaloricNeedsCalculatorFactory.getCaloricNeedsCalculator());
        caloricNeedsCalculatorModal.clickCaloricCalculatorNeedsButton();
        caloricNeedsCalculatorModal.waitForErrorMessageVisible();
        Assert.assertTrue(caloricNeedsCalculatorModal.isModalNotCompletelyFilled());
        homePage.switchToDefaultContent();
    }
}
