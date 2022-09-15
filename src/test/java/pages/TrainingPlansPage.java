package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TrainingPlansPage extends BasePage{

    private final static By TRAINING_TYPES_IMAGE=By.xpath("//img[@alt='Sport types']");
    private final static By TRAINING_PLAN_BUTTON=By.xpath("//div[@class='training-plan-list-item__name text-xl']");

    public TrainingPlansPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementVisible(TRAINING_TYPES_IMAGE);
    }

    public void clickTrainingPlan() {
        List<WebElement> planLinks=driver.findElements(TRAINING_PLAN_BUTTON);
        WebElement button = planLinks.get(2);
        scrollIntoView(button);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", button);
    }


}
