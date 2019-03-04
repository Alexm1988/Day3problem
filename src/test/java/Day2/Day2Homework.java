package Day2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class Day2Homework {
    WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\omelnikova\\IdeaProjects\\JavaTestNG\\src\\test\\resources\\drivers\\chromedriver.exe" );
        driver = new ChromeDriver();

    }

    @Test
    public void testYahooSearch() {

        String QueryString = "Reed Tech";

        setupbrowser ();
        openMainPage();
        typeQuery(QueryString);
        submitSearch ();
        waitforResultPage ();
        assertResults ();


    }



    @AfterSuite
 public void closebrowser (){
        driver.close();
    }


    private void waitforResultPage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ysch")));
    }

    private void assertResults() {
        WebElement resultsStats = driver.findElement(By.id("ysch"));
        Boolean isResultsDisplayed = resultsStats.isDisplayed();
        assertTrue (isResultsDisplayed);
    }

    private void submitSearch() {
        WebElement inputTextField = driver.findElement(By.id("uh-search-box"));
        inputTextField.submit();
    }

    private void typeQuery(String queryString) {

            WebElement inputTextField = driver.findElement(By.id("uh-search-box"));
            inputTextField.sendKeys (queryString);

    }
    //


    private void openMainPage() {
        String address = "https://www.yahoo.com/";
        driver.get(address);
    }

    private void setupbrowser() {
    }
}
