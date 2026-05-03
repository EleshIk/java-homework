import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AllureJunit5.class)
public class MTS {
    PayPage paymentPage;
    Pay paymentIframe;
    WebDriver driver;

    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        paymentPage = new PayPage(driver);
        paymentIframe = new Pay(driver);
        driver.get("https://www.mts.by/?hash-offset=70&hash-dur=1300#pay-section");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cookie-agree']")));
        if (cookieLocator.isDisplayed()) {
            cookieLocator.click();
        }
    }

//    @AfterEach
//    public void tearDown() {
//        if (driver != null) {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            driver.quit();
//        }
//    }

    @DisplayName("Проверка заголовка")
    @Test
    @Owner("Zinnur")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Проверка заголовка на странице оплаты")
    public void FindTitle() {
        String title = "Онлайн пополнение без комиссии";
        assertEquals(title, paymentPage.getTitle(), "Заголовок не найден");
    }

    @DisplayName("Проверка логотипа Visa")
    @Test
    @Owner("Zinnur")
    @Severity(SeverityLevel.NORMAL)
    @Step("Проверка наличия логотипа Visa")
    public void FindLogoVisa() {
        assertTrue(paymentPage.isLogoPresent(paymentPage.logoVisa), "Логотип Visa не найден");
    }

    @DisplayName("Проверка логотипа Verified by Visa")
    @Test
    @Owner("Zinnur")
    @Severity(SeverityLevel.NORMAL)
    @Step("Проверка наличия логотипа Verified by Visa")
    public void FindLogoVisa2() {
        assertTrue(paymentPage.isLogoPresent(paymentPage.logoVisa2), "Логотип Verified by Visa не найден");
    }

    @DisplayName("Проверка логотипа MasterCard")
    @Test
    @Owner("Zinnur")
    @Severity(SeverityLevel.NORMAL)
    @Step("Проверка наличия логотипа MasterCard")
    public void FindLogoMasterCard() {
        assertTrue(paymentPage.isLogoPresent(paymentPage.logoMasterCard), "Логотип MasterCard не найден");
    }

    @DisplayName("Проверка логотипа MasterCardSecure")
    @Test
    @Owner("Zinnur")
    @Severity(SeverityLevel.NORMAL)
    @Step("Проверка наличия логотипа MasterCardSecure")
    public void FindLogoMasterCardSecure() {
        assertTrue(paymentPage.isLogoPresent(paymentPage.logoMasterCardSecure), "Логотип MasterCard не найден");
    }

    @DisplayName("Проверка логотипа Belkart")
    @Test
    @Owner("Zinnur")
    @Severity(SeverityLevel.NORMAL)
    @Step("Проверка наличия логотипа Belkart")
    public void FindLogoBelkart() {
        assertTrue(paymentPage.isLogoPresent(paymentPage.logoBelkart), "Логотип Belkart не найден");
    }

    @DisplayName("Проверка работы ссылки 'Подробнее о сервисе'")
    @Test
    @Owner("Zinnur")
    @Severity(SeverityLevel.NORMAL)
    @Step("Проверка работы ссылки 'Подробнее о сервисе'")
    public void CheckServiceLink() {
        paymentPage.clickServiceLink();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        assertEquals(expectedUrl, paymentPage.getCurrentUrl(), "URL не совпадает");
    }

    @DisplayName("Проверка работы кнопки 'Продолжить'")
    @Test
    @Owner("Zinnur")
    @Severity(SeverityLevel.NORMAL)
    @Step("Проверка работы кнопки 'Продолжить'")
    public void CheckContinueButton() {
        String phoneNumber = "297777777";
        String sum = "10";

        paymentPage.fillPhoneField(phoneNumber);
        paymentPage.fillSumField(sum);
        paymentPage.clickContinueButton();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("Проверка надписей в незаполненных полях")
    @Test
    @Owner("Zinnur")
    @Severity(SeverityLevel.NORMAL)
    @Step("Проверка надписей в незаполненных полях")
    public void CheckEmptyFieldPlaceholders() {
        assertEquals("Номер телефона", paymentPage.getPhoneFieldPlaceholder(), "Неверная надпись в поле 'Номер телефона'");
        assertEquals("Сумма", paymentPage.getSumFieldPlaceholder(), "Неверная надпись в поле 'Сумма'");
        assertEquals("E-mail для отправки чека", paymentPage.getEmailFieldPlaceholder(), "Неверная надпись в поле 'E-mail'");
    }

    @DisplayName("Проверка заполнения полей и отображения ошибок")
    @Test
    @Owner("Zinnur")
    @Severity(SeverityLevel.NORMAL)
    @Step("Проверка заполнения полей и отображения ошибок")
    public void CheckFieldValidation() {
        //paymentPage.selectService("Услуги связи");
        paymentPage.fillPhoneField("invalid");
        paymentPage.fillSumField("0");
        paymentPage.fillEmailField("invalid-email");
        paymentPage.clickContinueButton();

        assertEquals("Номер телефона", paymentPage.getPhoneFieldPlaceholder(), "Неверная надпись в поле 'Номер телефона'");
        assertEquals("Сумма", paymentPage.getSumFieldPlaceholder(), "Неверная надпись в поле 'Сумма'");
        assertEquals("E-mail для отправки чека", paymentPage.getEmailFieldPlaceholder(), "Неверная надпись в поле 'E-mail'");
    }

    @DisplayName("Проверка корректности отображения суммы и номера телефона")
    @Test
    @Owner("Zinnur")
    @Severity(SeverityLevel.NORMAL)
    @Step("Проверка корректности отображения суммы и номера телефона")
    public void CheckPaymentDetails() {
        //paymentPage.selectService("Услуги связи");
        paymentPage.fillPhoneField("297777777");
        paymentPage.fillSumField("10");
        paymentPage.fillEmailField("test@example.com");
        paymentPage.clickContinueButton();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        paymentIframe.switchToIframe();


    }

    @DisplayName("Проверка ошибок в полях карты")
    @Test
    @Owner("Zinnur")
    @Severity(SeverityLevel.NORMAL)
    @Step("Проверка ошибок в полях карты")
    public void CheckCardFieldErrors() {
        paymentPage.selectService("Услуги связи");
        paymentPage.fillPhoneField("297777777");
        paymentPage.fillSumField("10");
        paymentPage.fillEmailField("test@example.com");
        paymentPage.clickContinueButton();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        paymentIframe.switchToIframe();

        paymentIframe.fillCardNumber("invalid");
        paymentIframe.fillExpirationDate("invalid");

        paymentIframe.fillHolderName(" \n");

        assertEquals("Некорректный номер карты", paymentIframe.getCardNumberError(), "Неверная ошибка в поле 'Номер карты'");
        assertEquals("Исправьте срок действия", paymentIframe.getExpirationDateError(), "Неверная ошибка в поле 'Срок действия'");
        assertEquals("Введите CVC-код", paymentIframe.getCvcError(), "Неверная ошибка в поле 'CVC'");
        assertEquals("Введите имя и фамилию как указано на карте", paymentIframe.getHolderNameError(), "Неверная ошибка в поле 'Имя держателя'");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String screenshotPath = "target/screenshots/screenshot_" + System.currentTimeMillis() + ".png";
                Files.copy(screenshot.toPath(), Paths.get(screenshotPath));

                // Закрываем драйвер
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver.quit();
            }
        }
    }
}