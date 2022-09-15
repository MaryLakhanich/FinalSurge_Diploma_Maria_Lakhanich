package tests;

import modals.AddBikeModal;
import modals.AddWorkoutModal;
import models.Bike;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BikeFactory;

public class BikeTest extends BaseTest{
    protected AddBikeModal addBikeModal;
    protected final String EXPECTED_TEXT = "You have no Current bikes. Add one now by using the Add New Bike form.";

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        addBikeModal = new AddBikeModal(driver);
    }

    @Test
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
        equipmentBikesPage.clickOKButton();
        Assert.assertEquals(equipmentBikesPage.getNoBikesText(), EXPECTED_TEXT);
    }

}
