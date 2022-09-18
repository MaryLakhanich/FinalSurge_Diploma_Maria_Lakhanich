package modals;

import elements.DropDown;
import elements.Input;
import elements.RadioButtonWorkout;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Workout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AddWorkoutModal extends BaseModal{

    private final static By TIME_OF_DAY=By.id("WorkoutTime");
    private final static By WORKOUT_NAME=By.id("Name");
    private final static By WORKOUT_DESCRIPTION=By.id("Desc");
    private final static By DURATION=By.id("DurationNoInt");
    private final static By PERCEIVED_EFFORT=By.id("PerEffort");
    private final static By ADD_WORKOUT_BUTTON=By.id("saveButton");

    public AddWorkoutModal(WebDriver driver) {
        super(driver);
    }
    @Step ("Filling in the form to add a new workout")
    public AddWorkoutModal fillForm(Workout workout){
        new Input(driver).setValue(TIME_OF_DAY, workout.getTimeOfDay());
        new Input(driver).setValue(WORKOUT_NAME, workout.getWorkoutName());
        new Input(driver).setValue(WORKOUT_DESCRIPTION, workout.getWorkoutDescription());
        new Input(driver).setValue(DURATION, workout.getDuration());
        new RadioButtonWorkout(driver).clickRadioButton(workout.getFeelingWhileTraining().getName());
        new DropDown(driver).selectOptionByOptionValue(PERCEIVED_EFFORT,workout.getPerceivedEffort().getValue());
        return this;
    }
    @Step("Clicking button 'Add workout'")
    public void clickAddWorkoutButton(){
        log.info("clicking button 'Add workout'");
        driver.findElement(ADD_WORKOUT_BUTTON).click();
    }

}

