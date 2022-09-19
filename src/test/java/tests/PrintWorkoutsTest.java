package tests;

import io.qameta.allure.Description;
import modals.PrintModal;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PrintDateFactory;

public class PrintWorkoutsTest extends BaseTest{
    PrintModal printModal;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        printModal = new PrintModal(driver);
    }

    @Test (groups = {"smoke"})
    @Description ("Checking if it is possible to print the report")
    public void printWorkoutsForPeriod() {
        loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(homePage.isPageOpened());
        homePage.clickPrintWorkoutsButton();
        homePage.switchToPrintIframe();
        printModal.fillForm(PrintDateFactory.getPrintDate());
        printModal.clickPrintWorkoutsButton();
        homePage.switchToDefaultContent();
        Assert.assertTrue(printPage.isPageOpened());
        Assert.assertEquals(printPage.getReportDates(), PrintDateFactory.getPrintDate());
    }
}
