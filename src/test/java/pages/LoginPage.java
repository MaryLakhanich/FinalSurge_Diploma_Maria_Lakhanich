package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final static String URL = "https://log.finalsurge.com/login.cshtml";
    private final static By EMAIL_INPUT = By.id("login_name");
    private final static By PASSWORD_INPUT = By.id("login_password");
    private final static By LOGIN_BUTTON = By.xpath("//button[text()=\"Login\"]");
    private final static By LOGOUT_MESSAGE = By.xpath("//div[@class='alert alert-success']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementVisible(LOGIN_BUTTON);
    }

    public void open() {
        driver.get(URL);
    }

    public void login(String email, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getLogoutMessageText() {
        return driver.findElement(LOGOUT_MESSAGE).getText();
    }
}
