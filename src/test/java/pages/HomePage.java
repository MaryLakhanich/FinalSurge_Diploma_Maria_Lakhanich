package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@Log4j2
public class HomePage extends BasePage {
    private final static By USER_AVATAR = By.id("LayoutProfilePic");
    private final static By LOGOUT_BUTTON = By.xpath("//a[text()='Logout']");
    private final static By WORKOUTS_MENU_LOCATOR = By.xpath("//a[text()='Workouts']");
    private final static By ADD_WORKOUT_BUTTON = By.xpath("//a[text()='Add Workout']");
    private final static By DAILY_VITALS_MENU_LOCATOR = By.xpath("//a[text()='Daily Vitals']");
    private final static By VIEW_ADD_VITALS_BUTTON = By.xpath("//a[text()='View & Add Vitals']");
    private final static By TRAINING_PLANS_MENU_LOCATOR = By.xpath("//a[text()='Training Plans']");
    private final static By FIND_PLAN_BUTTON = By.xpath("//a[text()='Find a Plan']");
    private final static By GEAR_ROUTES_MENU_LOCATOR = By.xpath("//a[text()='Gear & Routes']");
    private final static By BIKES_BUTTON = By.xpath("//a[text()='Bikes']");
    private final static By OTHER_CALCUlATORS_BUTTON= By.xpath("//a[@data-reveal-id='OtherCalc']/i");
    private final static By IFRAME_LOCATOR = By.id("OtherCalciFrame");
    private final static By PRINT_WORKOUTS_BUTTON = By.xpath("//a[@data-reveal-id='PrintWorkouts']/i");
    private final static By PRINT_WORKOUTS_IFRAME = By.id("PrintWorkoutsiFrame");
    private static final By REPORTS_STATISTICS_BUTTON = By.xpath("//a[contains(@href,'Report')]/i");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step ("Checking if home page is opened")
    @Override
    public boolean isPageOpened() {
        log.info("checking if home page is opened");
        return isElementVisible(USER_AVATAR);
    }
    @Step ("Clicking 'Logout' button")
    public void clickLogoutButton() {
        log.info("clicking 'Logout' button");
        driver.findElement(LOGOUT_BUTTON).click();
    }
    @Step ("Moving to workouts menu")
    public void moveToWorkoutsMenu() {
        log.info("moving to workouts menu");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(WORKOUTS_MENU_LOCATOR)).perform();
    }
    @Step ("Clicking 'Add workout' button")
    public void clickAddWorkout() {
        log.info("clicking 'Add workout' button");
        driver.findElement(ADD_WORKOUT_BUTTON).click();
    }
    @Step ("Moving to daily vitals menu")
    public void moveToDailyVitalsMenu() {
        log.info("moving to daily vitals menu");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(DAILY_VITALS_MENU_LOCATOR)).perform();
    }
    @Step ("Clicking 'View & Add' button")
    public void clickViewAndAddVitalsButton() {
        log.info("clicking 'View & Add' button");
        driver.findElement(VIEW_ADD_VITALS_BUTTON).click();
    }
    @Step ("Moving to training plans menu")
    public void moveToTrainingPlansMenu() {
        log.info("moving to training plans menu");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(TRAINING_PLANS_MENU_LOCATOR)).perform();
    }
    @Step("Clicking 'Find a plan' button")
    public void clickFindAPlanButton() {
        log.info("clicking 'Find a plan' button");
        driver.findElement(FIND_PLAN_BUTTON).click();
    }
    @Step ("Moving to 'Gear & Routes' menu")
    public void moveToGearAndRoutesMenu() {
        log.info("moving to 'Gear & Routes' menu");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(GEAR_ROUTES_MENU_LOCATOR)).perform();
    }
    @Step ("Clicking 'Bikes' button")
    public void clickBikesButton() {
        log.info("clicking 'Bikes' button");
        driver.findElement(BIKES_BUTTON).click();
    }
    @Step("Clicking 'Other calculators' button")
    public void clickCalculatorsButton(){
        log.info("clicking 'Other calculators' button");
        driver.findElement(OTHER_CALCUlATORS_BUTTON).click();
    }
    @Step ("Switching to iframe")
    public void switchToIframe() {
        log.info("switching to iframe");
        WebElement iframe = driver.findElement(IFRAME_LOCATOR);
        driver.switchTo().frame(iframe);
    }
    @Step ("Switching to default content")
    public void switchToDefaultContent(){
        log.info("switching to default content");
        driver.switchTo().defaultContent();
    }
    @Step ("Clicking 'Reports & Statistics' button")
    public void clickPrintWorkoutsButton(){
        log.info("clicking 'Reports & Statistics' button");
        driver.findElement(PRINT_WORKOUTS_BUTTON).click();
    }
    @Step("Clicking 'Reports & Statistics' button")
    public void clickReportsAndStatistics() {
        log.info("clicking 'Reports & Statistics' button");
        driver.findElement(REPORTS_STATISTICS_BUTTON).click();
    }
    @Step ("Switching to iframe")
    public void switchToPrintIframe(){
        log.info("switching to iframe");
        WebElement iframe = driver.findElement(PRINT_WORKOUTS_IFRAME);
        driver.switchTo().frame(iframe);
    }
}

