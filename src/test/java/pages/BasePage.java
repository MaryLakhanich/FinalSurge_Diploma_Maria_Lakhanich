package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    @Step ("Checking if element is visible")
    public boolean isElementVisible(By locator) {
        log.info(String.format("checking if element %s is visible", locator));
        return driver.findElement(locator).isDisplayed();
    }
    @Step ("Scrolling to element")
    public void scrollIntoView(WebElement element) {
        log.info(String.format("scrolling to element %s ", element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    @Step ("Javascript click")
    public void jsClick(WebElement element) {
        log.info(String.format("Javascript click at element:  %s ", element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
    }
    @Step ("Checking if the needed page is opened")
    public abstract boolean isPageOpened();

}
