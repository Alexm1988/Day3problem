package epmAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

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


}

