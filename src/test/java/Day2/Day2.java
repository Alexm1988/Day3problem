package Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Day2 {
    WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\omelnikova\\IdeaProjects\\JavaTestNG\\src\\test\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void test001() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\omelnikova\\IdeaProjects\\JavaTestNG\\src\\test\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void testGoogleSearch() {

        String queryString = "portnov computer school";

       

        openMainPage ();

        typeQuery (queryString);

        submitSearch ();

        waitforResultPage ();

        assertResultPage ();

    }

    private void waitforResultPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultStats")));
    }

    private void assertResultPage() {
        WebElement resultsStats = driver.findElement(By.id("resultStats"));
       Boolean isResultsDisplayed = resultsStats.isDisplayed();
       assertTrue (isResultsDisplayed);
       }


    private void submitSearch() {
        WebElement inputTextField = driver.findElement(By.cssSelector(".gLFyf"));
        inputTextField.submit();
    }

    private void typeQuery(String textToType) {
        WebElement inputTextField = driver.findElement(By.cssSelector(".gLFyf"));
        inputTextField.sendKeys (textToType);
    }

    private void openMainPage() {
        String url = "https://www.google.com/";
        driver.get(url);
    }

    private void setupBrowser() {

    }
}
