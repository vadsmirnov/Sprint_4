import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingBrowserTest {
    WebDriver driver;

    /** Браузер для  теста*/
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\bin\\chromedriver.exe");
        driver = new ChromeDriver();

    }
    /** Закрыть браузер*/
    @After
    public void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }
}
