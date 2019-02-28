package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.testng.Assert.assertTrue;

public class YahooTest<var> {

    WebDriver driver;
    By compPaginationElement = By.className("compPagination");
    WebElement resultsAmountElement;
    int Resultcount;
    int num;
    String value;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\omelnikova\\IdeaProjects\\JavaTestNG\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void testYahooSearch() {

        String QueryString = "Reed Tech";

        setupbrowser();
        openMainPage();
        typeQuery(QueryString);
        submitSearch();
        waitforResultPage();
        assertResults();

    }


    @AfterSuite
    public void closebrowser() {
        driver.close();
    }


    private void waitforResultPage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(compPaginationElement));
        WebElement compPaginationEl = driver.findElement(compPaginationElement);
        resultsAmountElement = compPaginationEl.findElement(By.tagName("span"));
    }


    private void assertResults() {
        Boolean isResultVisible = resultsAmountElement.isDisplayed();
        assertTrue(isResultVisible);
    }

    private void submitSearch() {
        WebElement inputTextField = driver.findElement(By.id("uh-search-box"));
        inputTextField.submit();
    }

    private void typeQuery(String queryString) {

        WebElement inputTextField = driver.findElement(By.id("uh-search-box"));
        inputTextField.sendKeys(queryString);

    }


    private void openMainPage() {
        String address = "https://www.yahoo.com/";
        driver.get(address);
    }

    private void setupbrowser() {
    }

    @Test
    //verify that the amount of results for the keyword "alex" is greater than 500
    public void testYahooSearch2() {
        String typeKey = "alex";



        openBrowserpage();
        typeKey(typeKey);
        submitSearchKey();
        waitforResultstobeloaded();
       // countresults();
        //verifyresults();


    }

    //public  void countresults() {
       //String value = driver.findElement(By.tagName("span")).getText();

       //public void int getNumber(){
        //    Integer.parseInt(getNumberText().getText());
     //  System.out.println (getNumber);
      //  }

       //Integer num = parseInt(('value').text().match(/\d+/)[0], 10);


       // var text = $('ui_3_10_0_1_1551066496611_2472').text();


     //   var num = parseInt($('span').text().match(/\d+/)[0], 10);


   // private WebElement getNumberText() {
    //}

    private void waitforResultstobeloaded() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(compPaginationElement));
        WebElement compPaginationEl = driver.findElement(compPaginationElement);
        resultsAmountElement = compPaginationEl.findElement(By.tagName("span"));
        System.out.println(resultsAmountElement);
    }


    private void verifyresults() {
        if (num > 100) {
            System.out.println("Test pass");}
        else {System.out.println("Test fail");}
    }

    private void submitSearchKey() {
        WebElement searchbox = driver.findElement(By.id("uh-search-box"));
        searchbox.submit();

    }

    private void typeKey(String typeKey) {
        WebElement searchbox = driver.findElement(By.id("uh-search-box"));
        searchbox.sendKeys(typeKey);
    }

    private void openBrowserpage() {
        String url = "https://www.yahoo.com";
        driver.get(url);
    }
}
