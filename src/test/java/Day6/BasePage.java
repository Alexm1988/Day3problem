package Day6;

public class BasePage extends TestBase {
    public BasePage() {
        super();
    }

    public HomePage goToHomePage() {
        driver.get("https://www.yahoo.com/");
        return new HomePage();
    }

}
