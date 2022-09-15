package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {

    protected final static String EMAIL = System.getenv().getOrDefault("EMAIL", PropertyReader.getProperty("finalSurge.email"));
    protected final static String PASSWORD = System.getenv().getOrDefault("PASSWORD", PropertyReader.getProperty("finalSurge.password"));
    protected final static String FAKE_GENERATED_CARD_NUMBER=System.getenv().getOrDefault("FAKE_GENERATED_CARD_NUMBER", PropertyReader.getProperty("finalSurge.cardNumber"));
    protected final static String FAKE_GENERATED_EXPIRY_DATE=System.getenv().getOrDefault("FAKE_GENERATED_EXPIRY_DATE", PropertyReader.getProperty("finalSurge.cardExpDate"));
    protected final static String FAKE_GENERATED_CVC=System.getenv().getOrDefault("FAKE_GENERATED_CVC", PropertyReader.getProperty("finalSurge.cardCVC"));

    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected WorkoutsPage workoutsPage;
    protected WorkoutDetailsPage workoutDetailsPage;
    protected DailyVitalsPage dailyVitalsPage;
    protected TrainingPlansPage trainingPlansPage;
    protected CoachPage coachPage;
    protected CheckoutPage checkoutPage;
    protected EquipmentBikesPage equipmentBikesPage;
    protected PrintPage printPage;

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
        trainingPlansPage = new TrainingPlansPage(driver);
        coachPage = new CoachPage(driver);
        checkoutPage = new CheckoutPage(driver);
        equipmentBikesPage = new EquipmentBikesPage(driver);
        printPage = new PrintPage(driver);
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
