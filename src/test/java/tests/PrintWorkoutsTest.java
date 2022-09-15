package tests;

import modals.CaloricNeedsCalculatorModal;
import modals.PaceCalculatorModal;
import modals.PrintModal;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PrintWorkoutsTest extends BaseTest{
    PrintModal printModal;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        printModal = new PrintModal(driver);
    }

    @Test
    public void printWorkoutsForPeriod(){
        loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(homePage.isPageOpened());
        homePage.clickPrintWorkoutsButton();
        homePage.switchToPrintIframe();
        printModal.fillForm();
        printModal.clickPrintWorkoutsButton();
        driver.switchTo().defaultContent();
        Assert.assertTrue(printPage.isPageOpened());
    }
}
