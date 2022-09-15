package modals;

import elements.DropDown;
import elements.Input;
import models.Bike;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddBikeModal extends BaseModal{

    private final static By BIKE_NAME = By.id("ShoeName");
    private final static By BIKE_BRAND = By.xpath("//span[text()='Select Brand...']");
    private static final String bikeBrandLocator = "//ul[@class='select2-results']//div[contains(.,'%s')]";
    private final static By BIKE_MODEL = By.id("ShoeModel");
    private final static By BIKE_COST = By.id("ShoeCost");
    private final static By DATE = By.id("ShoeDate");
    private final static By STARTING_DISTANCE = By.id("StartDist");
    private final static By NOTES = By.id("ShoeNotes");
    private final static By ADD_BIKE_BUTTON = By.id("saveButton");

    public AddBikeModal(WebDriver driver) {
        super(driver);
    }
    public void selectBikeBrand(String optionName) {
        driver.findElement(BIKE_BRAND).click();
        WebElement optionToClick = driver.findElement(By.xpath(String.format(bikeBrandLocator, optionName)));
        optionToClick.click();
    }
    public AddBikeModal fillForm (Bike bike){
        new Input(driver).setValue(BIKE_NAME, bike.getBikeName());
        selectBikeBrand(bike.getBikeBrand().getName());
        new Input(driver).setValue(BIKE_MODEL, bike.getModel());
        new Input(driver).setValue(BIKE_COST, bike.getCost());
        new Input(driver).setValue(DATE, bike.getDatePurchased());
        driver.findElement(STARTING_DISTANCE).clear();
        new Input(driver).setValue(STARTING_DISTANCE, bike.getDistance());
        new Input(driver).setValue(NOTES, bike.getNotes());
        return this;
    }

    public void clickAddBikeButton () {
        driver.findElement(ADD_BIKE_BUTTON).click();
    }
}

