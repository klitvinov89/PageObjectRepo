package com.a_level.konstantin_litvinov.test_project.main;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class LectionActions {
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
    public void checkDouMenuHoverStyle() {
        driver.get("https://dou.ua/");
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//*[text()='Зарплаты']"));
        action.moveToElement(we).build().perform();
        String color  = we.getCssValue("color");
        System.out.println(color);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("rgba(255, 0, 0, 1)",we.getCssValue("color"));
        driver.quit();
    }
    @Test
    public void checkGmailMailSend() throws InterruptedException {
        driver.get("https://accounts.google.com");
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("k.litvinov89@gmail.com");
        driver.findElement(By.xpath("//*[text()='Далее']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
//        System.out.println(element);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("QSEawd_321");
        driver.findElement(By.xpath("//*[text()='Далее']")).click();
        driver.get("https://mail.google.com/mail/u/0/#inbox");
        driver.findElement(By.xpath(("(//a[contains(text(),'Войти')])[2]"))).click();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.findElement(By.xpath("//*[text()='Konstantin Litvinoff']")).click();
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Compose']")));
        driver.findElement(By.xpath("//*[text()='Compose']")).click();
        driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("k.litvinov89@gmail.com");
        driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys(Keys.TAB);
        driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("this is best subject");
        driver.findElement(By.xpath("//*[text()='Send']")).click();
        Thread.sleep(2000);
        WebElement title = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@tabindex]//*[@data-legacy-thread-id and text()='this is best subject']"))));
        System.out.println(title);
        Boolean bool = driver.findElement(By.xpath(".//*[@tabindex]//*[@data-legacy-thread-id and text()='this is best subject']")).isDisplayed();
//        System.out.println(bool);
        Assert.assertTrue( bool,"Oops");
    }
}
