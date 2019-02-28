package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class Checkbox {
    WebDriver driver;


    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\omelnikova\\IdeaProjects\\JavaTestNG\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test001() {
        String url = "https://the-internet.herokuapp.com/checkboxes";
        driver.get(url);
        WebElement checkbox1 = driver.findElement(By.tagName("input")).get(0);
        WebElement checkbox2 = driver.findElement(By.tagName("input")).get(1);
        String checkbox1Attribute = checkbox1.getAttribute("checked");
        Assert.assertNull(checkbox1Attribute);
        checkbox1.click();
        String checkbox1Attribute2 = checkbox1.getAttribute("checked");
        Assert.assertEquals(checkbox1Attribute2, "true");
    }
}







