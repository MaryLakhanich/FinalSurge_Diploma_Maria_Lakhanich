package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WorkoutsPage extends BasePage {
    private final static By ACTIVITIES_SIDEBAR = By.cssSelector(".aw_sidebar");
    private final static By STRENGTH_TRAINING_BUTTON_LOCATOR = By.xpath("//a[@data-code='strength-t']");

    public WorkoutsPage(WebDriver driver) {
        super(driver);
    }

    @Step ("Checking if page is opened")
    @Override
    public boolean isPageOpened() {
        log.info("checking if page is opened");
        return isElementVisible(ACTIVITIES_SIDEBAR);
    }
    @Step ("Clicking 'Strength training' button")
    public void clickStrengthTrainingButton() {
        log.info("clicking 'Strength training' button");
        driver.findElement(STRENGTH_TRAINING_BUTTON_LOCATOR).click();
    }
}
