package PageObjectHW.Feature;

import PageObjectHW.PageObjectHomeWork.DetailedPage;
import PageObjectHW.PageObjectHomeWork.HomePage;
import PageObjectHW.PageObjectHomeWork.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageSearchFiltersTest extends WebDriverMy {

    @Test
    public void checkProzoroKeyWordSearchFilter() throws InterruptedException {
        PageObjectHW.Feature.WebDriverMy.driver.get("https://prozorro.gov.ua/tender/search/");
        HomePage homePage = new HomePage(PageObjectHW.Feature.WebDriverMy.driver);
        homePage.selectKeywordFilter();
        SearchResultsPage searchResultsPage = homePage.enterKeywordFilterSerchQuery("тест");
        DetailedPage detailedPage =  searchResultsPage.setSearchResult1stElementClick();
        Assert.assertTrue( detailedPage.TextPresentOnPage("тест"),"Oops");
    }
    @Test void checkProzoroPriceFromToSearchFilter () throws InterruptedException {
        PageObjectHW.Feature.WebDriverMy.driver.get("https://prozorro.gov.ua/tender/search/");
        HomePage homePage = new HomePage(PageObjectHW.Feature.WebDriverMy.driver);
        homePage.selectValueFilter();
        SearchResultsPage searchResultsPage = homePage.enterValuesFilterSerchQuery("1000","10000");
        DetailedPage detailedPage =  searchResultsPage.setSearchResult1stElementClick();
        String text = detailedPage.GetPriceTextFromPage();
        double value = detailedPage.CovertTextPriceToDigit(text);
        Assert.assertTrue( detailedPage.PriceIsFromRange(value),"Oops");
    }
}
