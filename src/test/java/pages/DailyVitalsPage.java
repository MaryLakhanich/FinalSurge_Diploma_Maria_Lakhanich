package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
@Log4j2
public class DailyVitalsPage extends BasePage{
    private final static By ADD_VITALS_BUTTON = By.xpath("//button[@title='Add Vitals']");
    private final static By CUSTOM_VIEW_BUTTON = By.id("CustomLink");
    private final static By VIEW_BUTTON = By.id("viewButton");
    private final static By START_DATE = By.id("CDateStart");
    private final static By END_DATE = By.id("CDateEnd");
    private static final By LAST_DATE_IN_TABLE = By.xpath("//table[contains(@class,'table-striped')]/tbody/tr[1]/td[1]");

    public DailyVitalsPage(WebDriver driver) {
        super(driver);
    }

    @Step ("Checking if daily vitals page is opened")
    @Override
    public boolean isPageOpened() {
        log.info("checking if daily vitals page is opened");
        return isElementVisible(ADD_VITALS_BUTTON);
    }
    @Step ("Clicking button 'Custom view'")
    public void clickCustomViewButton(){
        log.info("clicking button 'Custom view'");
        driver.findElement(CUSTOM_VIEW_BUTTON).click();
    }
    @Step ("Clicking button 'View'")
    public void clickViewButton(){
        log.info("clicking button 'View'");
        driver.findElement(VIEW_BUTTON).click();
    }

    @Step ("Entering dates to set a period")
    public void setPeriod(String startDate, String endDate){
        log.info("clearing prefilled input");
        driver.findElement(START_DATE).clear();
        log.info("setting start date");
        driver.findElement(START_DATE).sendKeys(startDate);
        log.info("clearing prefilled input");
        driver.findElement(END_DATE).clear();
        log.info("setting end date");
        driver.findElement(END_DATE).sendKeys(endDate);
    }
    @Step ("Getting last date in the final table")
    public String getLastDate(){
        log.info("getting last date in the final table");
        return driver.findElement(LAST_DATE_IN_TABLE).getText();
    }
    @Step ("Getting first date in the final table")
    public String geFirstDate(){
        log.info("looking for all dates of chosen period in the final table");
        List<WebElement> amountOfDays= driver.findElements(By.xpath("//tbody/tr/td/a"));
        int i = amountOfDays.size();
        log.info("getting first date in the final table");
        return driver.findElement(By.xpath("//table[contains(@class,'table-striped')]/tbody/tr["+(i)+"]/td[1]")).getText();
    }
}

