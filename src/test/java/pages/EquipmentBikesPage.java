package pages;

import enums.BikeBrand;
import models.Bike;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EquipmentBikesPage extends BasePage{
    private final static By TITLE = By.xpath("//span[text()='Keep track of bike mileage.']");
    private final static By EDIT_BUTTON = By.xpath("//a[@title='Edit']");
    private final static By DELETE_BUTTON = By.xpath("//a[@id='del-shoe2']");
    private final static By OK_BUTTON = By.xpath("//a[text()='OK']");
    private final static By ACTUAL_BIKE_NAME = By.id("ShoeName");
    private final static By ACTUAL_BIKE_BRAND = By.xpath("//a[@class='select2-choice']/span");
    private final static By ACTUAL_BIKE_MODEL = By.id("ShoeModel");
    private final static By ACTUAL_BIKE_COST = By.id("ShoeCost");
    private final static By ACTUAL_DATE = By.id("ShoeDate");
    private final static By ACTUAL_STARTING_DISTANCE = By.id("StartDist");
    private final static By ACTUAL_NOTES = By.id("ShoeNotes");
    private final static By NO_BIKES_TEXT = By.xpath("//div[@class='hero-unit']/p[1]");

    public EquipmentBikesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementVisible(TITLE);
    }

    public Bike getAddedBikeDetails(){
        Bike addedBike = new Bike();
        addedBike.setBikeName(getActualName());
        addedBike.setBikeBrand(BikeBrand.fromString(getActualBrand()));
        addedBike.setModel(getActualModel());
        addedBike.setCost(getActualCost());
        addedBike.setDatePurchased(getActualDate());
        addedBike.setDistance(getActualDistance());
        addedBike.setNotes(getActualNotes());
        return addedBike;

    }
    public String getActualName() {
        return driver.findElement(ACTUAL_BIKE_NAME).getAttribute("value");
    }
    public String getActualBrand() {
        return driver.findElement(ACTUAL_BIKE_BRAND).getText();
    }
    public String getActualModel() {
        return driver.findElement(ACTUAL_BIKE_MODEL).getAttribute("value");
    }
    public String getActualCost() {
        return driver.findElement(ACTUAL_BIKE_COST).getAttribute("value");
    }
    public String getActualDate() {
        return driver.findElement(ACTUAL_DATE).getAttribute("value");
    }
    public String getActualDistance() {
        return driver.findElement(ACTUAL_STARTING_DISTANCE).getAttribute("value");
    }
    public String getActualNotes() {
        return driver.findElement(ACTUAL_NOTES).getAttribute("value");
    }

    public void clickEditButton(){
        driver.findElement(EDIT_BUTTON).click();
    }
    public void clickDeleteButton(){
        driver.findElement(DELETE_BUTTON).click();
    }
    public void clickOKButton(){
        driver.findElement(OK_BUTTON).click();
    }
    public String getNoBikesText(){
        return driver.findElement(NO_BIKES_TEXT).getText();
    }
}
