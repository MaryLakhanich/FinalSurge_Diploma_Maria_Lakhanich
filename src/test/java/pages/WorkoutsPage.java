package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkoutsPage extends BasePage {
    private final static By ACTIVITIES_SIDEBAR = By.cssSelector(".aw_sidebar");
    private final static By STRENGTH_TRAINING_BUTTON_LOCATOR = By.xpath("//a[@data-code='strength-t']");

    public WorkoutsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementVisible(ACTIVITIES_SIDEBAR);
    }

    public void clickStrengthTrainingButton() {
        driver.findElement(STRENGTH_TRAINING_BUTTON_LOCATOR).click();
    }
}
