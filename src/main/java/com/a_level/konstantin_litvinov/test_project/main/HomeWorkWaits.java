package com.a_level.konstantin_litvinov.test_project.main;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HomeWorkWaits {
    @Test
    public void checkDouSearch(){
        System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dou.ua/");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='inp']")));
        driver.findElement(By.xpath("//*[@class='inp']")).sendKeys("test");
        driver.findElement(By.xpath("//*[@class='inp']")).sendKeys(Keys.ENTER);
        Boolean bool = driver.findElement(By.xpath("//*[contains(text(),'Найдено результатов:')]")).isDisplayed();
        System.out.println(bool);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        driver.findElement(By.xpath("(//*[@class='gsc-results gsc-webResult']//*[@class='gsc-webResult gsc-result']//a)[1]")).click();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        String newTab = tabs.get(1);
        driver.switchTo().window(newTab);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Boolean bool1 = driver.findElement(By.xpath("//h1[contains(text(),'Test')]")).isDisplayed();
        Assert.assertTrue( bool,"Oops");
        System.out.println(bool1);
        driver.quit();
    }
}
