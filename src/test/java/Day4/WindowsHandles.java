package Day4;

import com.sun.xml.internal.ws.policy.AssertionValidationProcessor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class WindowsHandles {
    WebDriver driver;


    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\omelnikova\\IdeaProjects\\JavaTestNG\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testsabinas() {
        String url = "http://the-internet.herokuapp.com/windows";
        driver.get(url);
        openMainpage(url);
        waitForResultPage();
        assertResultPage();
    }

    private void assertResultPage() {
        WebElement resultStats = driver.findElement(By.id("New Window"));
        boolean isResultsDisplayed = resultStats.isDisplayed();
        assertTrue(isResultsDisplayed);
    }

    private void waitForResultPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("New Window")));

    }


    @Test
    //same as 001 but with explicit wait
    public void test002() {
        String url = "https://the-internet.herokuapp.com/windows";
        openMainpage(url);
        clickHyperLink("Click Here");
        waitForSecondPage("handle");
        assertTwoWindows();
        assertTextonPage();
    }

    private void waitForSecondPage(String mwh) {


        Set s=driver.getWindowHandles(); //this method will gives you the handles of all opened windows

        Iterator ite=s.iterator();

        while(ite.hasNext())
        {
            String popupHandle=ite.next().toString();
            if(!popupHandle.contains(mwh))
            {
                driver.switchTo().window(popupHandle);
                //here we switched to a new window. So switch method is no longer needed as a separate step.
                //next step will be the test assertions

            }
        }

    }

    @Test
    public void test001() {
        String url = "https://the-internet.herokuapp.com/windows";
        openMainpage(url);
        clickHyperLink("Click Here");
        mysleep(5);
        assertTwoWindows();
        switchtoNewWindow();
        assertTextonPage();


    }

    private void assertTextonPage() {
        assertTrue(driver.getPageSource().contains("New Window"));
    }

    private void switchtoNewWindow() {
        Object[] array = driver.getWindowHandles().toArray();
        String windowHandle1 = (String) array[1];
        driver.switchTo().window(windowHandle1);
        String actualWindowTitle = driver.getTitle();
        String expectedWindowTitle = "New Window";
        Assert.assertEquals(actualWindowTitle, expectedWindowTitle);
    }

    private void mysleep(int timeinseconds) {
        try {
            Thread.sleep(timeinseconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void assertTwoWindows() {
       Set<String> WindowHandles = driver.getWindowHandles();
       int size = WindowHandles.size();
       int ExpectSize = 2;
       Assert.assertEquals(size, ExpectSize);
       Object[] array = WindowHandles.toArray();
       String windowhandle1 = (String) array[1];
    }

    private void clickHyperLink(String linktext) {

       WebElement element = driver.findElement(By.partialLinkText(linktext));
       element.click();
    }

    private void openMainpage(String url) {
        driver.get(url);
        String mwh=driver.getWindowHandle();
    }
}
