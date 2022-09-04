package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input extends BaseElement{

    public Input(WebDriver driver) {
        super(driver);
    }

    public void setValue (By locator,String value){
        driver.findElement(locator).sendKeys(value);
    }
}
