package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class DropDown extends BaseElement{

    public DropDown(WebDriver driver) {
        super(driver);
    }
    public void selectOptionByOptionValue(By locator, String optionName) {
        log.info(String.format("selecting option: option value = %s", optionName));
        Select dropDown = new Select(driver.findElement(locator));
        dropDown.selectByValue(optionName);
    }
    public void selectOptionByVisibleText(By locator, String optionName) {
        log.info(String.format("selecting option: option name = %s", optionName));
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(optionName);
    }

}
