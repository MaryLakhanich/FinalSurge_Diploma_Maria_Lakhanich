package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DailyVitalsPage extends BasePage{
    private final static By ADD_VITALS_BUTTON = By.xpath("//button[@title='Add Vitals']");
    private final static By CUSTOM_VIEW_BUTTON = By.id("CustomLink");
    private final static By VIEW_BUTTON = By.id("viewButton");
    private final static By DATE_LOCATOR = By.xpath("//tr//td/a[@href]");
    private final static By STEPS_LOCATOR = By.xpath("//table[@class='table table-striped table-condensed']//tr//td[2]");
    public DailyVitalsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementVisible(ADD_VITALS_BUTTON);
    }
    public void clickCustomViewButton(){
        driver.findElement(CUSTOM_VIEW_BUTTON).click();
    }
    public void clickViewButton(){
        driver.findElement(VIEW_BUTTON).click();
    }
    public int getAmountOfDays(){
        List<WebElement> dates=driver.findElements(DATE_LOCATOR);
        return dates.size();

        }
    }

