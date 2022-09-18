package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.PrintDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

@Log4j2
public class PrintPage extends BasePage{

    private final static By PRINT_LINK = By.xpath("//table/tbody/tr[1]/td[1]");
    private final static By REPORT_PERIOD = By.xpath("//td/span[2]");

    public PrintPage(WebDriver driver) {
        super(driver);
    }

    @Step ("Checking if print page is opened")
    @Override
    public boolean isPageOpened() {
        log.info("checking if print page is opened");
        return driver.findElement(PRINT_LINK).isDisplayed();
    }
    @Step ("Getting report first and last dates")
    public PrintDate getReportDates(){
        log.info("getting report first and last dates");
        PrintDate reportDates = new PrintDate();
        ArrayList<String> tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        reportDates.setPrintStartingDate(getFirstDateInReport());
        reportDates.setPrintEndingDate(getLastDateInReport());
        driver.switchTo().window(tabs.get(0));
        return reportDates;
    }
    @Step ("Getting first date")
    public String getFirstDateInReport(){
        log.info("getting first date");
        return driver.findElement(REPORT_PERIOD).getText().split(" ")[1];
    }
    @Step ("Getting last date")
    public String getLastDateInReport(){
        log.info("getting last date");
        return driver.findElement(REPORT_PERIOD).getText().split(" ")[3];
    }

}
