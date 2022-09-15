package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DailyVitalsPage extends BasePage{
    private final static By ADD_VITALS_BUTTON = By.xpath("//button[@title='Add Vitals']");
    private final static By CUSTOM_VIEW_BUTTON = By.id("CustomLink");
    private final static By VIEW_BUTTON = By.id("viewButton");
    private final static By START_DATE = By.id("CDateStart");
    private final static By END_DATE = By.id("CDateEnd");
    private static final By LAST_DATE_IN_TABLE = By.xpath("//table[contains(@class,'table-striped')]/tbody/tr[1]/td[1]");
    private static final By FIRST_DATE_IN_TABLE = By.xpath("//table[contains(@class,'table-striped')]/tbody/tr[4]/td[1]");

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

    public void setPeriod(String startDate, String endDate){
        driver.findElement(START_DATE).clear();
        driver.findElement(START_DATE).sendKeys(startDate);
        driver.findElement(END_DATE).clear();
        driver.findElement(END_DATE).sendKeys(endDate);
    }
    public String getLastDate(){
        return driver.findElement(LAST_DATE_IN_TABLE).getText();
    }
    public String geFirstDate(){
        return driver.findElement(FIRST_DATE_IN_TABLE).getText();
    }
}

