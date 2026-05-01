import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class App {
    protected WebDriver driver;

    public App(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}