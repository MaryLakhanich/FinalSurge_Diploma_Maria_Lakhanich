package modals;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.PrintDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PrintModal extends BaseModal{
    private final static By STARTING_DATE = By.id("PrintStartDate");
    private final static By ENDING_DATE = By.id("PrintEndDate");
    private final static By PRINT_WORKOUTS_BUTTON = By.id("saveButtonPrint");

    public PrintModal(WebDriver driver) {
        super(driver);
    }
    @Step ("Filling in the form to choose a period")
    public PrintModal fillForm(PrintDate printDate) {
        new Input(driver).setValue(STARTING_DATE, printDate.getPrintStartingDate());
        new Input(driver).setValue(ENDING_DATE, printDate.getPrintEndingDate());
        return this;
    }

    @Step ("Clicking button 'Print workouts'")
    public void clickPrintWorkoutsButton(){
        log.info("clicking button 'Print workouts'");
        driver.findElement(PRINT_WORKOUTS_BUTTON).click();
    }

}
