package pages;

import enums.BikeBrand;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Bike;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
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
    @Step ("Checking if equipment page is opened")
    public boolean isPageOpened() {
        log.info("checking if equipment page is opened");
        return isElementVisible(TITLE);
    }

    @Step ("Getting added bike details")
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
    @Step ("Getting added bike name")
    public String getActualName() {
        log.info("getting added bike name");
        return driver.findElement(ACTUAL_BIKE_NAME).getAttribute("value");
    }
    @Step ("Getting added bike brand")
    public String getActualBrand() {
        log.info("getting added bike brand");
        return driver.findElement(ACTUAL_BIKE_BRAND).getText();
    }
    @Step ("Getting added bike model")
    public String getActualModel() {
        log.info("getting added bike model");
        return driver.findElement(ACTUAL_BIKE_MODEL).getAttribute("value");
    }
    @Step ("Getting added bike cost")
    public String getActualCost() {
        log.info("getting added bike cost");
        return driver.findElement(ACTUAL_BIKE_COST).getAttribute("value");
    }
    @Step ("Getting actual date")
    public String getActualDate() {
        log.info("getting actual date");
        return driver.findElement(ACTUAL_DATE).getAttribute("value");
    }
    @Step("Getting actual distance")
    public String getActualDistance() {
        log.info("getting actual distance");
        return driver.findElement(ACTUAL_STARTING_DISTANCE).getAttribute("value");
    }
    @Step ("Getting added bike notes")
    public String getActualNotes() {
        log.info("getting added bike notes");
        return driver.findElement(ACTUAL_NOTES).getAttribute("value");
    }
    @Step ("Clicking button 'Edit'")
    public void clickEditButton(){
        log.info("clicking button 'Edit'");
        driver.findElement(EDIT_BUTTON).click();
    }
    @Step ("Clicking button 'Delete'")
    public void clickDeleteButton(){
        log.info("clicking button 'Delete'");
        driver.findElement(DELETE_BUTTON).click();
    }
    @Step ("Clicking button 'OK'")
    public void clickOKButton(){
        log.info("clicking button 'OK'");
        driver.findElement(OK_BUTTON).click();
    }
    @Step ("Waiting until button in modal window is visible")
    public void waitForOKButtonIsVisible(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(OK_BUTTON));
    }
    @Step ("Getting text about absence of current bikes")
    public String getNoBikesText(){
        log.info("getting text about absence of current bikes");
        return driver.findElement(NO_BIKES_TEXT).getText();
    }
}
