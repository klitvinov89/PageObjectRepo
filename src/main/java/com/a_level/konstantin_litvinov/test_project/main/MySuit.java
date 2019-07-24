package com.a_level.konstantin_litvinov.test_project.main;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MySuit {
    @Test
    public void checkGoogle(){
        System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");

        Boolean bool = driver.findElement(By.xpath("//*[@alt='Google']")).isDisplayed();
        System.out.println(bool);
        System.out.println("First test was DONE!!!");

        Assert.assertTrue(true,"OOPS");
        driver.quit();
    }
    @Test
    public void checkUkrNetByID(){
        System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.ukr.net");

        driver.findElement(By.id("search-input")).sendKeys("search");
        driver.findElement(By.id("id-input-login")).sendKeys("login@mail.com");
        driver.findElement(By.id("id-input-password")).sendKeys("password");

//        Assert.assertTrue(true,"OOPS");
        driver.quit();
    }
    @Test
    public void checkRozetkaByClass(){
        System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://rozetka.com.ua");

        System.out.println(driver.findElements(By.className("menu-categories__item")).size());
//        List<WebElement> classes = driver.findElements(By.className("menu-categories__item"));


//        Assert.assertTrue(true,"OOPS");
        driver.quit();
    }
    @Test
    public void checkRozetkaByTag(){
        System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://rozetka.com.ua");

        List <WebElement> imgs = driver.findElements(By.tagName("img"));
        System.out.println(imgs.size());

//        Assert.assertTrue(true,"OOPS");
        driver.quit();
    }
    @Test
    public void checkRozetkaByName(){
        System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://rozetka.com.ua");
        driver.findElement(By.name("search")).sendKeys("search");;

//        Assert.assertTrue(true,"OOPS");
        driver.quit();
    }
    @Test
    public void checkGoogleByLinkText(){
        System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com.ua");
        driver.findElement(By.linkText("українська")).click();

//        Assert.assertTrue(true,"OOPS");
        driver.quit();
    }
    @Test
    public void checkRozetkaByCSS(){
        System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://rozetka.com.ua");
        driver.findElement(By.cssSelector("html body app-root div div div header")).getSize();
        WebElement header = driver.findElement(By.cssSelector("header > div"));

//        Assert.assertTrue(true,"OOPS");
        driver.quit();
    }
}
