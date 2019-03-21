package epmAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class epmAdmin {
    WebDriver driver;


    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\omelnikova\\IdeaProjects\\JavaTestNG\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    //open apmAdmin page
    public void test001() {
        String url = "https://epmadminportalqat.reedtech.com/";
        openMainPage(url);

    }

    private void openMainPage(String url) {
        driver.get(url);
    }

    @Test
    //authorize access / does not work
    public void test002() {
        //http://username:password@example.com/yourpage/
        String url = "epmadminportalqat.reedtech.com/";
        String login = "omelnikova";
        String password = "Ruslan198631@";
        String url2 = "https://" + login + ":" + password + "@" + url;

        driver.get(url2);
    }

    @Test
    public void testPassLogin() throws IOException {
        String url = "https://epmadminportalqat.reedtech.com/";
        openMainPage(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Runtime.getRuntime().exec("C:\\Users\\omelnikova\\IdeaProjects\\JavaTestNG\\src\\test\\resources\\AUTOIT\\epmadminlogin.exe").sendKeys("omelnikova");


    }
}

