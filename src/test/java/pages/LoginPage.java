package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {
    private final static String URL = "https://log.finalsurge.com/login.cshtml";
    private final static By EMAIL_INPUT = By.id("login_name");
    private final static By PASSWORD_INPUT = By.id("login_password");
    private final static By LOGIN_BUTTON = By.xpath("//button[text()=\"Login\"]");
    private final static By LOGOUT_MESSAGE = By.xpath("//div[@class='alert alert-success']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step ("Checking if login page is opened")
    @Override
    public boolean isPageOpened() {
        log.info("checking if login page is opened");
        return isElementVisible(LOGIN_BUTTON);
    }
    @Step ("Getting URL")
    public void open() {
        log.info("getting URL");
        driver.get(URL);
    }
    @Step ("Entering user's data to log in and clicking login button")
    public void login(String email, String password) {
        log.info("entering email");
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        log.info("entering password");
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        log.info("clicking 'Login' button");
        driver.findElement(LOGIN_BUTTON).click();
    }
    @Step ("Getting logout message text")
    public String getLogoutMessageText() {
        log.info("getting logout message text");
        return driver.findElement(LOGOUT_MESSAGE).getText();
    }
}
