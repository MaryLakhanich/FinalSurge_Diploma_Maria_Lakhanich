package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends BaseElement{

    public DropDown(WebDriver driver) {
        super(driver);
    }
    public void selectOptionByOptionValue(By locator, String optionName) {
        Select dropDown = new Select(driver.findElement(locator));
        dropDown.selectByValue(optionName);
    }

}
