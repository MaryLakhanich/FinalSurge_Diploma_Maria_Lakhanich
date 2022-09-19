package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Workout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import enums.FeelingWhileTraining;
import enums.PerceivedEffort;

@Log4j2
public class WorkoutDetailsPage extends BasePage{
    private final static By VIEW_YOUR_WORKOUT_TEXT= By.xpath("//span[text()='View and Edit your workout.']");
    private static final By ACTUAL_TIME = By.xpath("//div[@class='formSep']/div/small");
    private static final By ACTUAL_NAME = By.xpath("//span[@class='activityTypeName']/parent::div/following-sibling::div");
    private static final By ACTUAL_DESCRIPTION = By.xpath("//small[contains(text(),'Description:')]/ancestor::p");
    private static final By ACTUAL_DURATION = By.xpath("//small[text()='Workout Statistics:']/following-sibling::span[@class='label label-info']");
    private static final By ACTUAL_PERCEIVED_EFFORT = By.xpath("//small[text()='Perceived Effort']/parent::div[@class='formSep']");
    private static final By ACTUAL_FEELING = By.xpath("//small[text()='How I Felt:']/following-sibling::span");

    public WorkoutDetailsPage(WebDriver driver) {
        super(driver);
    }
    @Step ("Getting added workout information")
    public Workout getAddedWorkoutDetails() {
        Workout addedWorkout = new Workout();
        addedWorkout.setTimeOfDay(getActualTime());
        addedWorkout.setWorkoutName(getActualName());
        addedWorkout.setWorkoutDescription(getDescription());
        addedWorkout.setDuration(getActualDuration());
        addedWorkout.setPerceivedEffort(PerceivedEffort.fromString(getActualPerceivedEffort()));
        addedWorkout.setFeelingWhileTraining(FeelingWhileTraining.fromString(getActualFeeling()));
        return addedWorkout;
    }
    @Step ("Checking if workout details page is opened")
    @Override
    public boolean isPageOpened() {
        log.info("checking if workout details page is opened");
        return isElementVisible(VIEW_YOUR_WORKOUT_TEXT);
    }

    @Step ("Getting added workout name")
    public String getActualName() {
        log.info("getting added workout name");
        return driver.findElement(ACTUAL_NAME).getText().trim();
    }

    @Step ("Getting added workout time")
    public String getActualTime() {
        log.info("getting added workout time");
        return driver.findElement(ACTUAL_TIME).getText().split("-")[1].trim();
    }

    @Step ("Getting added workout description")
    public String getDescription() {
        log.info("getting added workout description");
        return driver.findElement(ACTUAL_DESCRIPTION).getText().split(":")[1].trim();
    }

    @Step ("Getting added workout duration")
    public String getActualDuration() {
        log.info("getting added workout duration");
        return driver.findElement(ACTUAL_DURATION).getText().split(":",2)[1].trim();
    }

    @Step ("Getting added workout perceived effort")
    public String getActualPerceivedEffort() {
        log.info("getting added workout perceived effort");
        return driver.findElement(ACTUAL_PERCEIVED_EFFORT).getText().split("rt")[1].trim();
    }

    @Step ("Getting added workout feeling")
    public String getActualFeeling() {
        log.info("getting added workout feeling");
        return driver.findElement(ACTUAL_FEELING).getText().trim();
    }


}
