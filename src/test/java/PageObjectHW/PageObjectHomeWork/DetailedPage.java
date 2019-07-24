package PageObjectHW.PageObjectHomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailedPage extends PageObject {

    public DetailedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = ".//body")
    private WebElement bodyContainer;

    @FindBy (xpath = "//*[@class='green tender--description--cost--number']//strong")
    private WebElement priceText;

    public boolean TextPresentOnPage(String text) {
        boolean bool;
        if(driver.findElements(By.xpath("//*[contains(text(),'"+text+"')]")).size() != 0){
            bool = true;
        }else{
            bool = false;
        }
        return bool;
    }
    public String GetPriceTextFromPage (){
        String textPrice;
        textPrice = priceText.getText();
        return textPrice;
    }
    public double CovertTextPriceToDigit(String textPrice){
        double price = 0;
        price = Double.parseDouble(textPrice.replace(" ","").replace(",",".").replace("UAH",""));
        return price;
    }
    public boolean PriceIsFromRange(double price){
        Boolean bool = false;
        if (price > 1000 & price < 10000){
            bool = true;
        }else{
            bool = false;
        }
        return bool;
    }
}
