package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MTS2 {
    WebDriver driver;

    public MTS2(WebDriver driver) {
        this.driver = driver;
    }

    By pay_wrapper = By.xpath("//div[@class='pay__wrapper']/h2");

    public String getTitle() {
        return driver.findElement(pay_wrapper).getText().replaceAll("\n", " ");
    }

    By logoVisa = By.xpath("//img[@alt='Visa']");
    By logoVisa2 = By.xpath("//img[contains(@src, 'visa-verified.svg')]");
    By logoMasterCard = By.xpath("//img[@alt='MasterCard']");
    By logoMasterCardSecure = By.xpath("//img[contains(@src, 'mastercard-secure.svg')]");
    By logoBelkart = By.xpath("//img[@alt='Белкарт']");

    public boolean isLogoPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    By serviceLink = By.linkText("Подробнее о сервисе");

    public void clickServiceLink() {
        driver.findElement(serviceLink).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    By phoneField = By.id("connection-phone");
    By sumField = By.id("connection-sum");
    By continueButton = By.cssSelector("button.button.button__default[type='submit']");
    By emailField = By.id("connection-email");

    public void fillPhoneField(String phoneNumber) {
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }

    public void fillSumField(String sum) {
        driver.findElement(sumField).sendKeys(sum);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void fillEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    // ДОБАВЬТЕ ЭТИ МЕТОДЫ:
    public String getPhoneFieldPlaceholder() {
        return driver.findElement(phoneField).getAttribute("placeholder");
    }

    public String getSumFieldPlaceholder() {
        return driver.findElement(sumField).getAttribute("placeholder");
    }

    public String getEmailFieldPlaceholder() {
        return driver.findElement(emailField).getAttribute("placeholder");
    }
}