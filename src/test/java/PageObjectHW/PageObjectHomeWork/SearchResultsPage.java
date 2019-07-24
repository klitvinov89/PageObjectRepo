package PageObjectHW.PageObjectHomeWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends PageObjectHW.PageObjectHomeWork.PageObject {

    public SearchResultsPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "(//*[@class='items-list']//*[@class='items-list--header'])[1]")
    private WebElement searchResult1stElement;

    @FindBy(xpath = "//*[text()='Знайдено: ']")
    private WebElement result;



    public PageObjectHW.PageObjectHomeWork.DetailedPage setSearchResult1stElementClick(){
        searchResult1stElement.click();
        return new PageObjectHW.PageObjectHomeWork.DetailedPage(driver);
    }
}
