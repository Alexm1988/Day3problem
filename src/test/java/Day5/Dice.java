package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Dice {
    WebDriver driver;
    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\omelnikova\\IdeaProjects\\JavaTestNG\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
   @AfterMethod
    public void closebrowser() {
        driver.close();
    }

    @Test
    //xpath for search box
    public void test001() {
        driver.get("https://www.dice.com/");
        driver.findElement(By.xpath("//*[@name='q' and @type='search']")).sendKeys("search field found");

    }

    @Test
    //xpath with position method
    public void test002() {
        driver.get("https://www.dice.com/jobs/");
        driver.findElement(By.xpath("//*[@type='checkbox' and @chktyp='radius'] [position()= 3]")).click();

    }
}
