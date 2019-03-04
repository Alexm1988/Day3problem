package Day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BasicAuth {
    WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\omelnikova\\IdeaProjects\\JavaTestNG\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
        @Test
        public void test001 () {

            String url = "the-internet.herokuapp.com/basic_auth";
            String login = "admin";
            String password = "admin";
            String url2 = "https://" + login + ":" + password + "@" + url;

            driver.get(url2);

            boolean isCongratsInSource = driver.getPageSource().contains("Congratulations!");

            Assert.assertTrue(isCongratsInSource);
        }
    }


