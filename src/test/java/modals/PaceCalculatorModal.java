package modals;


import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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
    public PaceCalculatorModal fillForm() {
        new Input(driver).setValue(DISTANCE, "10");
        new Input(driver).setValue(HOURS, "1");
        new Input(driver).setValue(MINUTES,"5");
        new Input(driver).setValue(SECONDS, "15");
        return this;
    }
    public void clickPaceCalculatorButton(){
        driver.findElement(PACE_CALCULATOR_BUTTON).click();
    }

    public void clickCalculateButton() {
        clickButton(CALCULATE_PACES_BUTTON);
    }

    public boolean isPaceChartTableVisible() {
        return driver.findElement(PACE_CHART_TABLE).isDisplayed();
    }
    public boolean isPaceSplitsTableVisible() {
        return driver.findElement(PACE_SPLITS_TABLE).isDisplayed();
    }


}
