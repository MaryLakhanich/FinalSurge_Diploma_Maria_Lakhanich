package modals;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.CaloricNeedsCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class CaloricNeedsCalculatorModal extends BaseModal{
    private final static By WEIGHT = By.xpath("//input[@name='Weight']");
    private final static By HEIGHT = By.xpath("//input[@name='HeightInchCent']");
    private final static By AGE = By.xpath("//input[@name='Age']");
    private final static By DISTANCE = By.xpath("//input[@name='RunDist']");
    private final static By CALCULATE_CALORIC_NEEDS_BUTTON = By.id("saveButtonSettings");
    private final static By ERROR_MESSAGE = By.xpath("//div[@class='alert alert-error']/strong");

    public CaloricNeedsCalculatorModal(WebDriver driver) {
        super(driver);
    }

    @Step ("Filling in the form to calculate caloric needs")
    public CaloricNeedsCalculatorModal fillFormWithoutGender(CaloricNeedsCalculator caloricNeedsCalculator){
        new Input(driver).setValue(WEIGHT, String.valueOf(caloricNeedsCalculator.getWeight()));
        new Input(driver).setValue(HEIGHT, String.valueOf(caloricNeedsCalculator.getHeight()));
        new Input(driver).setValue(AGE, String.valueOf(caloricNeedsCalculator.getAge()));
        new Input(driver).setValue(DISTANCE, String.valueOf(caloricNeedsCalculator.getRunDistance()));
        return this;
    }
    @Step ("Clicking button 'Calculate caloric needs'")
    public void clickCaloricCalculatorNeedsButton(){
        log.info("clicking button 'Calculate caloric needs'");
        driver.findElement(CALCULATE_CALORIC_NEEDS_BUTTON).click();
    }

    @Step ("Checking if modal window isn't completely filled in")
    public boolean isModalNotCompletelyFilled (){
        log.info("checking if modal window isn't completely filled in");
        return driver.findElement(ERROR_MESSAGE).getText().contains("fix the following errors");
    }

    @Step ("Waiting for error message to appear on the screen")
    public void waitForErrorMessageVisible(){
        log.info("Waiting for error message to appear on the screen");
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
    }
}
