package tests;

import io.qameta.allure.Description;
import modals.AddBikeModal;
import models.Bike;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BikeFactory;

public class BikeTest extends BaseTest {
    protected AddBikeModal addBikeModal;
    protected final String EXPECTED_TEXT = "You have no Current bikes. Add one now by using the Add New Bike form.";

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        addBikeModal = new AddBikeModal(driver);
    }

    @Test(groups = {"regression"})
    @Description("Adding a new bike and deleting it")
    public void addAndDeleteNewBikeTest() {
        loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(homePage.isPageOpened());
        homePage.moveToGearAndRoutesMenu();
        homePage.clickBikesButton();
        Assert.assertTrue(equipmentBikesPage.isPageOpened());
        Bike myBike = BikeFactory.addNewBike();
        addBikeModal.fillForm(myBike);
        addBikeModal.clickAddBikeButton();
        equipmentBikesPage.clickEditButton();
        Assert.assertEquals(myBike,equipmentBikesPage.getAddedBikeDetails());
        equipmentBikesPage.clickDeleteButton();
        equipmentBikesPage.waitForOKButtonIsVisible();
        equipmentBikesPage.clickOKButton();
        Assert.assertEquals(equipmentBikesPage.getNoBikesText(), EXPECTED_TEXT);
    }
}
