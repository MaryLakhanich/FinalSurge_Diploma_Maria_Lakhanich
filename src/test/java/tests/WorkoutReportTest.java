package tests;

import io.qameta.allure.Description;
import models.Report;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ReportFactory;

public class WorkoutReportTest extends BaseTest {

    @Test( groups = {"smoke"})
    @Description(value = "Reporting on workouts of the selected type for the selected period")
    public void reportWorkoutTest() {
        loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(homePage.isPageOpened());
        homePage.clickReportsAndStatistics();
        Assert.assertTrue(workoutReportPage.isPageOpened());
        Report reportView = ReportFactory.getReportInform();
        workoutReportPage.fillForm(reportView)
                .clickViewReportButton();
        Assert.assertEquals(workoutReportPage.getActivityFromTable(), reportView.getActivityType().getName());
    }
}
