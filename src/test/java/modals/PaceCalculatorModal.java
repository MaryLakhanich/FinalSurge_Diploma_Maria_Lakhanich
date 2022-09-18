package modals;


import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.PaceCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PaceCalculatorModal extends BaseModal{
    private final static By DISTANCE = By.id("RunDist");
    private final static By HOURS = By.id("TimeHH");
    private final static By MINUTES = By.id("TimeMM");
    private final static By SECONDS = By.id("TimeSS");
    private final static By CALCULATE_PACES_BUTTON = By.id("saveButtonSettings");
    private final static By PACE_CHART_TABLE = By.xpath("//div[@class='span6']/div[@class='w-box w-box-green']");
    private final static By PACE_SPLITS_TABLE = By.xpath("//div[@class='w-box']");
    private final static By PACE_CALCULATOR_BUTTON = By.xpath("//*[text()='Pace Calculator']");

    public PaceCalculatorModal(WebDriver driver) {
        super(driver);
    }

    @Step ("Filling in the form to calculate pace")
    public PaceCalculatorModal fillForm(PaceCalculator paceCalculator) {
        new Input(driver).setValue(DISTANCE, String.valueOf(paceCalculator.getDistance()));
        new Input(driver).setValue(HOURS, String.valueOf(paceCalculator.getHours()));
        new Input(driver).setValue(MINUTES, String.valueOf(paceCalculator.getMinutes()));
        new Input(driver).setValue(SECONDS, String.valueOf(paceCalculator.getSeconds()));
        return this;
    }
    @Step ("Clicking button 'Pace Calculator'")
    public void clickPaceCalculatorButton(){
        log.info("clicking button 'Pace Calculator'");
        driver.findElement(PACE_CALCULATOR_BUTTON).click();
    }

    @Step ("Clicking button 'Calculate Paces'")
    public void clickCalculateButton() {
        log.info("clicking button 'Calculate Paces'");
        clickButton(CALCULATE_PACES_BUTTON);
    }
    @Step ("Checking if Pace chart table is visible")
    public boolean isPaceChartTableVisible() {
        log.info("checking if Pace chart table is visible");
        return driver.findElement(PACE_CHART_TABLE).isDisplayed();
    }
    @Step ("Checking if Pace splits table is visible")
    public boolean isPaceSplitsTableVisible() {
        log.info("checking if Pace splits table is visible");
        return driver.findElement(PACE_SPLITS_TABLE).isDisplayed();
    }
}
