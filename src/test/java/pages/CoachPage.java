package pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class CoachPage extends BasePage{
    private final static By CONTINUE_CHECKOUT_BUTTON=By.xpath("//span[contains(text(),'Continue to Checkout')]");
    private final static By LOGIN_BUTTON = By.xpath("//div/span[contains(text(),'Log In')]");
    private final static By EMAIL_INPUT = By.xpath("//input[@name='email']");
    private final static By PASSWORD_INPUT = By.xpath("//input[@name='password']");
    private final static By SIGN_IN_BUTTON = By.xpath("//span[contains(text(),'Sign In')]");

    public CoachPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step ("Checking if coach page is opened")
    public boolean isPageOpened() {
        log.info("checking if coach page is opened");
        return isElementVisible(CONTINUE_CHECKOUT_BUTTON);
    }

    @Step ("Clicking button 'Continue checkout'")
    public void clickContinueCheckoutButton(){
        log.info("clicking button 'Continue checkout'");
        driver.findElement(CONTINUE_CHECKOUT_BUTTON).click();
    }
    @Step ("Clicking button 'Log in'")
    public void clickLoginButton(){
        log.info("clicking button 'Log in'");
        driver.findElement(LOGIN_BUTTON).click();
    }
    @Step ("Entering data to sign in")
    public void login(String email,String password){
        log.info("setting email");
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        log.info("setting password");
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        log.info("clicking button 'Sign in'");
        driver.findElement(SIGN_IN_BUTTON).click();
    }

}
