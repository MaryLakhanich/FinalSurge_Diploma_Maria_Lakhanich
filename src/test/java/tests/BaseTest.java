package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {

    protected final static String EMAIL = "amigo-10291@mail.ru";
    protected final static String PASSWORD = "8467189178Qq";
    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected WorkoutsPage workoutsPage;
    protected WorkoutDetailsPage workoutDetailsPage;
    protected DailyVitalsPage dailyVitalsPage;

    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext testContext) throws Exception {
        String browserName = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browserName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        testContext.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        workoutsPage = new WorkoutsPage(driver);
        workoutDetailsPage = new WorkoutDetailsPage(driver);
        dailyVitalsPage = new DailyVitalsPage(driver);

    }

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        loginPage.open();
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
