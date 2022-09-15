package modals;

import com.beust.ah.A;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public CaloricNeedsCalculatorModal fillFormWithoutGender(){
        new Input(driver).setValue(WEIGHT, "70");
        new Input(driver).setValue(HEIGHT, "170");
        new Input(driver).setValue(AGE, "40");
        new Input(driver).setValue(DISTANCE, "10");
        return this;
    }
    public void clickCaloricCalculatorNeedsButton(){
        driver.findElement(CALCULATE_CALORIC_NEEDS_BUTTON).click();
    }

    public boolean isModalNotCompletelyFilled (){
        return driver.findElement(ERROR_MESSAGE).getText().contains("fix the following errors");
    }
    public void waitForErrorMessageVisible(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
    }
}
