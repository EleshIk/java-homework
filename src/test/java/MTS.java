import io.github.bonigarcia.wdm.WebDriverManager;
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

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MTS {
    PayPage payPage;
    Pay pay;
    WebDriver driver;

    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        payPage = new PayPage(driver);
        pay = new Pay(driver);
        driver.get("https://www.mts.by/?hash-offset=70&hash-dur=1300#pay-section");
        driver.manage().window().maximize();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cookie-agree']")));
        if (cookieLocator.isDisplayed()) {
            cookieLocator.click();
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            try {
                Thread.sleep(2000); // Пауза в 2 секунды между тестами
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }

    @DisplayName("Проверка заголовка")
    @Test
    public void FindTitle() {
        String title = "Онлайн пополнение без комиссии";
        assertEquals(title, payPage.getTitle(), "Заголовок не найден");
    }

    @DisplayName("Проверка логотипа Visa")
    @Test
    public void FindLogoVisa() {
        assertTrue(payPage.isLogoPresent(payPage.logoVisa), "Логотип Visa не найден");
    }

    @DisplayName("Проверка логотипа Verified by Visa")
    @Test
    public void FindLogoVisa2() {
        assertTrue(payPage.isLogoPresent(payPage.logoVisa2), "Логотип Verified by Visa не найден");
    }

    @DisplayName("Проверка логотипа MasterCard")
    @Test
    public void FindLogoMasterCard() {
        assertTrue(payPage.isLogoPresent(payPage.logoMasterCard), "Логотип MasterCard не найден");
    }

    @DisplayName("Проверка логотипа MasterCardSecure")
    @Test
    public void FindLogoMasterCardSecure() {
        assertTrue(payPage.isLogoPresent(payPage.logoMasterCardSecure), "Логотип MasterCard не найден");
    }

    @DisplayName("Проверка логотипа Belkart")
    @Test
    public void FindLogoBelkart() {
        assertTrue(payPage.isLogoPresent(payPage.logoBelkart), "Логотип Belkart не найден");
    }

    @DisplayName("Проверка работы ссылки 'Подробнее о сервисе'")
    @Test
    public void CheckServiceLink() {
        payPage.clickServiceLink();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        assertEquals(expectedUrl, payPage.getCurrentUrl(), "URL не совпадает");
    }

    @DisplayName("Проверка работы кнопки 'Продолжить'")
    @Test
    public void CheckContinueButton() {
        String phoneNumber = "297777777";
        String sum = "10";

        payPage.fillPhoneField(phoneNumber);
        payPage.fillSumField(sum);
        payPage.clickContinueButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
        driver.switchTo().frame(iframe);

        try {
            Thread.sleep(5000); // Пауза в 5 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @DisplayName("Проверка заполнения полей и отображения ошибок")
    @Test
    public void CheckFieldValidation() {
        payPage.fillPhoneField("(33)333-33-33");
        payPage.fillSumField("156");
        payPage.fillEmailField("tomas@gmail.ru");
        payPage.clickContinueButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Неверный формат')]")));

        assertEquals("Номер телефона", payPage.getPhoneFieldPlaceholder(), "Неверная надпись в поле 'Номер телефона'");
        assertEquals("Сумма", payPage.getSumFieldPlaceholder(), "Неверная надпись в поле 'Сумма'");
        assertEquals("E-mail для отправки чека", payPage.getEmailFieldPlaceholder(), "Неверная надпись в поле");
    }

}