package Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

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

        assertResultPage ();

    }

    private void assertResultPage() {
        WebElement assertResultsStats = driver.findElement(By.id("resultStats"));
       Boolean isResultsDisplayed = assertResultsStats.isDisplayed();
       if (isResultsDisplayed) {
           System.out.println("Search works");}
       else System.out.println("Search does not work");
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
