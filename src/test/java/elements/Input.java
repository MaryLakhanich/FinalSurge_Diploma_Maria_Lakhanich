package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input extends BaseElement {

    public Input(WebDriver driver) {
        super(driver);
    }

    public void setValue(By locator, String value) {
        log.info(String.format("setting input: value = %s", value));
        driver.findElement(locator).sendKeys(value);
    }
}
