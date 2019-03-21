package Day6;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends TestBase {
    @FindBy(id= "uh-search-box")
    private WebElement searchTextField;

    @FindBy(id= "uh-search-button")
    private WebElement submitButton;


    public HomePage() {
        super();
    }

    public SearchResultPage gotToSearchResultpage() {
        searchTextField.sendKeys("Portnov Computer School");
        submitButton.click();
        return new SearchResultPage();
    }
}
