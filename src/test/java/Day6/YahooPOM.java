package Day6;

import org.testng.Assert;
import org.testng.annotations.Test;

public class YahooPOM extends TestBase {
    BasePage basePage;
    HomePage homePage;
    SearchResultPage searchResultPage;

    public YahooPOM() {
        super();
    }

    @Test
    public void YahooSearchTest() {
        basePage = new BasePage();
        homePage = basePage.goToHomePage();
        searchResultPage = homePage.gotToSearchResultpage();
        Assert.assertTrue(searchResultPage.isSearchResultsDisplayed());
    }

}

