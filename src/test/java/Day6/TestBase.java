package Day6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;

    public TestBase() {
        PageFactory.initElements(driver, this);
    }

    @BeforeTest
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\omelnikova\\IdeaProjects\\JavaTestNG\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest()
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }


}
