import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.MTS2;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MTS {
    private static WebDriver driver;
    private MTS2 mts;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeEach
    void init() {
        driver.get("https://www.mts.by/");
        mts = new MTS2(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement cookieLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cookie-agree']")));
            if (cookieLocator.isDisplayed()) {
                cookieLocator.click();
            }
        } catch (TimeoutException e) {
            System.out.println("Cookie окно не появилось");
        }
    }

    @AfterEach
    void tearDown() {

    }

    @AfterAll
    static void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DisplayName("Проверка пополнение")
    @Test
    public void findText() {
        assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Онлайн пополнение')]")).isDisplayed());
    }

    @DisplayName("Проверка найти партнеров")
    @Test
    public void findPartners() {
        assertTrue(driver.findElement(By.xpath("//*[@class='pay__partners']")).isDisplayed());
    }

    @DisplayName("Проверка подробнее о сервисе")
    @Test
    public void findServis() {
        String linkpage = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        WebElement link = driver.findElement(By.linkText("Подробнее о сервисе"));
        link.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(linkpage));

        assertEquals(linkpage, driver.getCurrentUrl());
    }

    @DisplayName("Проверка работы кнопки 'Продолжить' с корректными данными")
    @Test
    public void checkContinueButtonWithValidData() {
        mts.fillPhoneField("(33)333-33-33");
        mts.fillSumField("156");
        mts.fillEmailField("tomas@gmail.ru");
        mts.clickContinueButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));

        System.out.println("Кнопка 'Продолжить' работает корректно, форма оплаты открылась");
    }
}