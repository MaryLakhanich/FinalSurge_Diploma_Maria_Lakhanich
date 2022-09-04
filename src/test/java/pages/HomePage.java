package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
    private final static By USER_AVATAR = By.id("LayoutProfilePic");
    private final static By LOGOUT_BUTTON = By.xpath("//a[text()='Logout']");
    private final static By WORKOUTS_MENU_LOCATOR = By.xpath("//a[text()='Workouts']");
    private final static By ADD_WORKOUT_BUTTON = By.xpath("//a[text()='Add Workout']");
    private final static By DAILY_VITALS_MENU_LOCATOR = By.xpath("//a[text()='Daily Vitals']");
    private final static By VIEW_ADD_VITALS_BUTTON = By.xpath("//a[text()='View & Add Vitals']");

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

    public void  clickViewAndAddVitalsButton(){
        driver.findElement(VIEW_ADD_VITALS_BUTTON).click();
    }
}

