package modals;

import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrintModal extends BaseModal{
    private final static By STARTING_DATE = By.id("PrintStartDate");
    private final static By ENDING_DATE = By.id("PrintEndDate");
    private final static By PRINT_WORKOUTS_BUTTON = By.id("saveButtonPrint");

    public PrintModal(WebDriver driver) {
        super(driver);
    }
    public PrintModal fillForm() {
        new Input(driver).setValue(STARTING_DATE,"08/28/2022");
        new Input(driver).setValue(ENDING_DATE,"09/13/2022");
        return this;
    }

    public void clickPrintWorkoutsButton(){
        driver.findElement(PRINT_WORKOUTS_BUTTON).click();
    }

}
