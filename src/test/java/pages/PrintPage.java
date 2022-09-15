package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrintPage extends BasePage{

    private final static By PRINT_LINK = By.xpath("//table/tbody/tr[1]/td[1]");
    private final static By PRINT_BUTTON = By.xpath("//a[contains(@href, 'print')]");

    public PrintPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(PRINT_LINK).isDisplayed();
    }
    public void clickPrintButton() {
        //driver.findElement(PRINT_BUTTON).click();
        WebElement element = driver.findElement(By.xpath("//a[contains(@href, 'print')]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
