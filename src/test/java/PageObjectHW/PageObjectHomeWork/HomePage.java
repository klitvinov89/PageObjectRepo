package PageObjectHW.PageObjectHomeWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(xpath = "//*[text()='Ключове слово']")
    private WebElement keyWordFilter;

    @FindBy(xpath = "//*[@class='block block-query' and .//*[text()='Ключове слово']]//input")
    private WebElement keyWordFilterInput;

    @FindBy(xpath = "//*[text()='Вартість']")
    private WebElement valueFilter;

    @FindBy(xpath = "//*[@class='block block-value' and .//*[text()='Вартість']]//input[@class='value from']")
    private WebElement valueFilterFromInput;

    @FindBy(xpath = "//*[@class='block block-value' and .//*[text()='Вартість']]//input[@class='value to']")
    private WebElement valueFilterToInput;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void selectKeywordFilter(){
        keyWordFilter.click();
    }
    public SearchResultsPage enterKeywordFilterSerchQuery(String text){
        keyWordFilterInput.sendKeys(text);
        return new SearchResultsPage(driver);
    }
    public void selectValueFilter(){
        valueFilter.click();
    }
    public SearchResultsPage enterValuesFilterSerchQuery(String valueFrom, String valueTo) {
        valueFilterFromInput.sendKeys(valueFrom);
        valueFilterToInput.sendKeys(valueTo);
        return new SearchResultsPage(driver);
    }
}
