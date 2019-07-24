package com.a_level.konstantin_litvinov.test_project.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Date;

public class HomeWorkWaitsPart2 {

    WebDriver driver;

    @BeforeTest
    public void precondition(){
        System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterTest
    public void close(){
        driver.quit();
    }

    @Test
    public void checkProzoroKeyWordSearchFilter() throws InterruptedException {
        driver.get("https://prozorro.gov.ua/tender/search/");
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//*[text()='Ключове слово']")).click();
        driver.findElement(By.xpath("//*[@class='block block-query' and .//*[text()='Ключове слово']]//input")).sendKeys("тест");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Знайдено: ']")));
        driver.findElement(By.xpath("(//*[@class='items-list']//*[@class='items-list--header'])[1]")).click();
        Boolean bool = false;
        if(driver.findElements(By.xpath("//*[contains(text(),'тест')]")).size() != 0){
            bool = true;
        }else{
            bool = false;
        }
        Assert.assertTrue( bool,"Oops");
//        Thread.sleep(5000);
    }
    @Test
    public void checkProzoroPriceFromToSearchFilter() throws InterruptedException {
        driver.get("https://prozorro.gov.ua/tender/search/");
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//*[text()='Вартість']")).click();
        driver.findElement(By.xpath("//*[@class='block block-value' and .//*[text()='Вартість']]//input[@class='value from']")).sendKeys("1000");
        driver.findElement(By.xpath("//*[@class='block block-value' and .//*[text()='Вартість']]//input[@class='value to']")).sendKeys("10000");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Знайдено: ']")));
        driver.findElement(By.xpath("(//*[@class='items-list']//*[@class='items-list--header'])[1]")).click();
        double price = 0;
        String textPrice = driver.findElement(By.xpath("//*[@class='green tender--description--cost--number']//strong")).getText();
        price = Double.parseDouble(textPrice.replace(" ","").replace(",",".").replace("UAH",""));
//        System.out.println(price);
        Boolean bool = false;
        if (price > 1000 & price < 10000){
            bool = true;
        }else{
            bool = false;
        }
        Assert.assertTrue( bool,"Oops");
//        Thread.sleep(5000);
    }
    @Test
    public void checkProzoroRegionSearchFilter() throws InterruptedException {
        driver.get("https://prozorro.gov.ua/tender/search/");
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Регіон']")));
        driver.findElement(By.xpath("//*[text()='Регіон']")).click();
        WebElement we = driver.findElement(By.xpath("//*[@class='selectize-dropdown-content']//div[contains(text(),'Луганська область')]"));
        action.moveToElement(we).perform();
        driver.findElement(By.xpath("//*[@class='selectize-dropdown-content']//div[contains(text(),'Луганська область')]")).click();
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Знайдено: ']")));
        driver.findElement(By.xpath("(//*[@class='items-list']//*[@class='items-list--header'])[1]")).click();
        Boolean bool = false;
        if(driver.findElements(By.xpath("//*[contains(text(),'Луганська')]")).size() != 0){
            bool = true;
        }else{
            bool = false;
        }
        Assert.assertTrue( bool,"Oops");

//        Thread.sleep(5000);
    }
    @Test
    public void checkProzoroStatusSearchFilter() throws InterruptedException {
        driver.get("https://prozorro.gov.ua/tender/search/");
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Статус']")));
        driver.findElement(By.xpath("//*[text()='Статус']")).click();
        WebElement we = driver.findElement(By.xpath("//*[@class='selectize-dropdown-content']//div[contains(text(),'Період уточнень')]"));
        action.moveToElement(we).perform();
        driver.findElement(By.xpath("//*[@class='selectize-dropdown-content']//div[contains(text(),'Період уточнень')]")).click();
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Знайдено: ']")));
        driver.findElement(By.xpath("(//*[@class='items-list']//*[@class='items-list--header'])[1]")).click();
        Boolean bool = false;
        if(driver.findElements(By.xpath("//*[contains(text(),'Період уточнень')]")).size() != 0){
            bool = true;
        }else{
            bool = false;
        }
        Assert.assertTrue( bool,"Oops");

//        Thread.sleep(5000);
    }
    @Test
    public void checkProzoroProcedureSearchFilter() throws InterruptedException {
        driver.get("https://prozorro.gov.ua/tender/search/");
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Процедура']")));
        driver.findElement(By.xpath("//*[text()='Процедура']")).click();
        WebElement we = driver.findElement(By.xpath("//*[@class='block block-procedure_t']//div[contains(text(),'Допорогові закупівлі')]"));
        action.moveToElement(we).perform();
        driver.findElement(By.xpath("//*[@class='block block-procedure_t']//div[contains(text(),'Допорогові закупівлі')]")).click();
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Знайдено: ']")));
        driver.findElement(By.xpath("(//*[@class='items-list']//*[@class='items-list--header'])[1]")).click();
        Boolean bool = false;
        if(driver.findElements(By.xpath("//*[contains(text(),'Допорогові закупівлі')]")).size() != 0){
            bool = true;
        }else{
            bool = false;
        }
        Assert.assertTrue( bool,"Oops");

//        Thread.sleep(5000);
    }

//    @Test
//    public void checkProzoroDatesSearchFilter1() throws InterruptedException {
//        driver.get("https://prozorro.gov.ua/tender/search/");
//        Actions action = new Actions(driver);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Дата']")));
//        driver.findElement(By.xpath("//*[text()='Дата']")).click();
//
//        Thread.sleep(2000);
//
//        WebElement we = driver.findElement(By.xpath("(//*[@class=' table-condensed']//td[text()='1'])[1]"));
//        action.moveToElement(we).perform();
//
//        driver.findElement(By.xpath("(//tbody//td[text()='1'])[1]")).click();
//        Thread.sleep(2000);
//        WebElement we1 = driver.findElement(By.xpath("//*[@class=' table-condensed']//*[text()='28' and @class!='old day']"));
//        action.moveToElement(we1).perform();
//
//        Date date = new Date();
//        System.out.println(date);
//
//        driver.findElement(By.xpath("//*[@class=' table-condensed']//*[text()='28' and @class!='old day']")).click(); //(//*[@class=' table-condensed']//td[text()='28'])[4]
//
//        Thread.sleep(2000);
//
////        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Знайдено: ']")));
//
////        driver.findElement(By.xpath("(//*[@class='items-list']//*[@class='items-list--header'])[1]")).click();
////        Boolean bool = false;
////        if(driver.findElements(By.xpath("//*[contains(text(),'Допорогові закупівлі')]")).size() != 0){
////            bool = true;
////        }else{
////            bool = false;
////        }
////        Assert.assertTrue( bool,"Oops");
//
//        Thread.sleep(5000);
//    }
}
