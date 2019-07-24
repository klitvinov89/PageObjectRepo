package PageObjectHW.Feature;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

public class WebDriverMy {
    protected static WebDriver driver;

    public WebDriverMy() {
        System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }


}
