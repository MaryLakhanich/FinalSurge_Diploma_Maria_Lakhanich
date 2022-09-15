package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementVisible(USER_AVATAR);
    }

    public void clickLogoutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
    }
    public void moveToWorkoutsMenu() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(WORKOUTS_MENU_LOCATOR)).perform();
    }
    public void clickAddWorkout() {
        driver.findElement(ADD_WORKOUT_BUTTON).click();
    }
    public void moveToDailyVitalsMenu() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(DAILY_VITALS_MENU_LOCATOR)).perform();
    }
    public void clickViewAndAddVitalsButton() {
        driver.findElement(VIEW_ADD_VITALS_BUTTON).click();
    }
    public void moveToTrainingPlansMenu() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(TRAINING_PLANS_MENU_LOCATOR)).perform();
    }
    public void clickFindAPlanButton() {
        driver.findElement(FIND_PLAN_BUTTON).click();
    }
    public void moveToGearAndRoutesMenu() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(GEAR_ROUTES_MENU_LOCATOR)).perform();
    }
    public void clickBikesButton() {
        driver.findElement(BIKES_BUTTON).click();
    }
    public void clickCalculatorsButton(){
        driver.findElement(OTHER_CALCUlATORS_BUTTON).click();
    }
    public void switchToIframe() {
        WebElement iframe = driver.findElement(IFRAME_LOCATOR);
        driver.switchTo().frame(iframe);
    }
    public void clickPrintWorkoutsButton(){
        driver.findElement(PRINT_WORKOUTS_BUTTON).click();
    }

    public void switchToPrintIframe(){
        WebElement iframe = driver.findElement(PRINT_WORKOUTS_IFRAME);
        driver.switchTo().frame(iframe);
    }

}

