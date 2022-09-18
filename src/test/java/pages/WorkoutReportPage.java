package pages;

import elements.DropDown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Report;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WorkoutReportPage extends BasePage {

    private static final By VIEW_REPORT_BUTTON = By.id("saveButton");
    private static final By START_DATE = By.id("WorkoutDate");
    private static final By END_DATE = By.id("WorkoutDateEnd");
    private static final By ACTIVITY_TYPE = By.id("ActivityType");
    private static final By TABLE_ACTIVITY_COLUMN = By.xpath("//table[contains(@class,'table-striped')]/tbody/tr[1]/td[2]");


    public WorkoutReportPage(WebDriver driver) {
        super(driver);
    }

    @Step("Filling 'Report Filters' form")
    public WorkoutReportPage fillForm(Report report) {
        log.info("clearing prefilled input");
        driver.findElement(START_DATE).clear();
        new Input(driver).setValue(START_DATE, report.getStartDate());
        log.info("clearing prefilled input");
        driver.findElement(END_DATE).clear();
        new Input(driver).setValue(END_DATE, report.getEndDate());
        new DropDown(driver).selectOptionByVisibleText(ACTIVITY_TYPE, report.getActivityType().getName());
        return this;
    }

    @Step("Clicking 'View Report' button")
    public void clickViewReportButton() {
        log.info("clicking 'View Report' button");
        driver.findElement(VIEW_REPORT_BUTTON).click();
    }

    @Step("Getting data from the actions column in the final table")
    public String getActivityFromTable() {
        log.info("getting data from the actions column in the final table");
        return driver.findElement(TABLE_ACTIVITY_COLUMN).getText();
    }

    @Step ("Checking if workout report page is opened")
    @Override
    public boolean isPageOpened() {
        log.info("checking if workout report page is opened");
        return driver.findElement(VIEW_REPORT_BUTTON).isDisplayed();
    }
}