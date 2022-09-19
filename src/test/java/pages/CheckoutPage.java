package pages;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class CheckoutPage extends CoachPage {
    private final static By CHANGE_REGION_BUTTON = By.xpath("//span[contains(text(),'Change')]");
    private final static By CARD_NUMBER_INPUT = By.xpath("//span[@class]/input[@name='cardnumber']");
    private final static By EXPIRY_DATE = By.xpath("//span[@class]/input[@name='exp-date']");
    private final static By CVC_CODE = By.xpath("//span[@class]/input[@name='cvc']");
    private final static By CARD_NUMBER_IFRAME = By.xpath("//div//iframe[contains(@title,'карты')]");
    private final static By EXP_DATE_IFRAME = By.xpath("//div//iframe[contains(@title,'даты')]");
    private final static By CVC_IFRAME = By.xpath("//div//iframe[contains(@title,'CVC')]");
    private final static By PAY_BUTTON = By.xpath("//div[contains(@class,'action-button')]");
    private final static By CHECKOUT_ERROR_MESSAGE = By.xpath("//div[contains(@class, 'alert__text')]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting for error message to appear on the screen ")
    public void waitForElementDisplayed() {
        log.info("waiting for error message to appear on the screen");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_ERROR_MESSAGE));
    }
    @Step ("Checking if checkout page is opened")
    public boolean isPageOpened() {
        log.info("checking if checkout page is opened");
        return isElementVisible(CHANGE_REGION_BUTTON);
    }

    @Step ("Setting card number, expiry date and cvc-code")
    public void enterCardDataAndClickPayButton(String cardNumber, String expiryDate, String cvcCode) {
        driver.switchTo().frame(driver.findElement(CARD_NUMBER_IFRAME));
        new Input(driver).setValue(CARD_NUMBER_INPUT, cardNumber);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(EXP_DATE_IFRAME));
        new Input(driver).setValue(EXPIRY_DATE, expiryDate);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(CVC_IFRAME));
        new Input(driver).setValue(CVC_CODE, cvcCode);
        driver.switchTo().defaultContent();
        driver.findElement(PAY_BUTTON).click();
    }

    @Step ("Clicking pay button")
    public void clickPayButton() {
        log.info("clicking pay button");
        driver.findElement(PAY_BUTTON).click();
    }

    @Step ("Waiting until pay button is clickable")
    public void waitForPayButtonIsClickable() {
        log.info("waiting until pay button is clickable");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(PAY_BUTTON));
    }

    @Step ("Checking if card number is valid")
    public boolean isCardNumberInvalid (){
        log.info("checking if card number is valid");
        return driver.findElement(CHECKOUT_ERROR_MESSAGE).getText().contains("the following error: Неверный номер карты");
    }

    @Step ("Waiting until error message is visible")
    public void waitForErrorMessageVisible(){
        log.info("waiting until error message is visible");
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_ERROR_MESSAGE));
    }


}
