package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton extends BaseElement{
    private final String radioButtonLocator = "//input[@type='radio']//following-sibling::span[text()='%s']";
    public RadioButton(WebDriver driver) {
        super(driver);
    }
    public void clickRadioButton(String feeling){
        driver.findElement(By.xpath(String.format((radioButtonLocator),feeling))).click();
    }
}
