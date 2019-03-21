package Day6;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends TestBase{
    @FindBy(xpath = "//div[@class='compPagination']/span")
    private WebElement searchNumber;

    public SearchResultPage() {
        super();
    }

    public boolean isSearchResultsDisplayed() {
        return searchNumber.isDisplayed();
    }
}
