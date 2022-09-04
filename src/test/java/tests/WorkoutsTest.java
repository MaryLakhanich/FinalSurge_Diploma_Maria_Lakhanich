package tests;

import modals.AddWorkoutModal;
import models.Workout;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WorkoutFactory;

public class WorkoutsTest extends BaseTest {
    protected AddWorkoutModal addWorkoutModal;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        addWorkoutModal = new AddWorkoutModal(driver);
    }

    @Test
    public void addStrengthTrainingTest() {
        loginPage.Login(EMAIL, PASSWORD);
        homePage.isPageOpened();
        homePage.moveToWorkoutsMenu();
        homePage.clickAddWorkout();
        Assert.assertTrue(workoutsPage.isPageOpened());
        workoutsPage.clickStrengthTrainingButton();
        Workout strengthTraining= WorkoutFactory.addStrengthTraining();
        addWorkoutModal.fillForm(strengthTraining);
        addWorkoutModal.clickAddWorkoutButton();
        workoutDetailsPage.isPageOpened();
        Assert.assertEquals(strengthTraining,workoutDetailsPage.getAddedWorkoutDetails(),"Saved workout information differs from entered information");
    }
}
