package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CoachPage extends BasePage{
    private final static By CONTINUE_CHECKOUT_BUTTON=By.xpath("//span[contains(text(),'Continue to Checkout')]");
    private final static By LOGIN_BUTTON = By.xpath("//div/span[contains(text(),'Log In')]");
    private final static By EMAIL_INPUT = By.xpath("//input[@name='email']");
    private final static By PASSWORD_INPUT = By.xpath("//input[@name='password']");
    private final static By SIGN_IN_BUTTON = By.xpath("//span[contains(text(),'Sign In')]");

    private final static By SIGN_IN_MESSAGE = By.xpath("//div[@class='notification_content']");


    public CoachPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementVisible(CONTINUE_CHECKOUT_BUTTON);
    }

    public void clickContinueCheckoutButton(){
        driver.findElement(CONTINUE_CHECKOUT_BUTTON).click();
    }
    public void clickLoginButton(){
        driver.findElement(LOGIN_BUTTON).click();
    }
    public void login(String email,String password){
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(SIGN_IN_BUTTON).click();
    }

    public void waitForMessageInvisible () {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(SIGN_IN_MESSAGE));
    }
    public String getText () {
        return  driver.findElement(SIGN_IN_MESSAGE).getText();
    }
}
