import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Attachment;

public class HomeWorkTestNG {

        WebDriver driver;

        @BeforeTest(groups = {"1st_scope","2nd_scope"})
        public void precondition() {
            System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @AfterTest(groups = {"1st_scope","2nd_scope"})
        public void close() {
            driver.quit();
        }
        @DataProvider(name = "ProviderData", parallel = false)
        public Object [][] justForProviderTest (){
        return new Object[][]{
                {null},
                {"test"},
                {"закуп"},
        };
    }
        @Attachment(type = "image/png")
            public byte[] takeScreenshot(WebDriver driver){
            byte[] result = null;
            if (driver != null) result = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            return result;
    }


    @Test(groups = {"1st_scope"},dataProvider = "ProviderData")
        public void checkProzoroKeyWordSearchFilter(String str) throws InterruptedException {
            driver.get("https://prozorro.gov.ua/tender/search/");
            Actions action = new Actions(driver);
            driver.findElement(By.xpath("//*[text()='Ключове слово']")).click();
            takeScreenshot(driver);
            driver.findElement(By.xpath("//*[@class='block block-query' and .//*[text()='Ключове слово']]//input")).sendKeys(str);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            takeScreenshot(driver);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Знайдено: ']")));
            takeScreenshot(driver);
            driver.findElement(By.xpath("(//*[@class='items-list']//*[@class='items-list--header'])[1]")).click();
            Boolean bool = false;
            if (driver.findElements(By.xpath("//*[contains(text(),'"+str+"')]")).size() != 0) {
                bool = true;
            } else {
                bool = false;
            }
            Assert.assertTrue(bool, "Oops");
            takeScreenshot(driver);
//        Thread.sleep(5000);
        }

        @Test(groups = {"1st_scope"})
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
            price = Double.parseDouble(textPrice.replace(" ", "").replace(",", ".").replace("UAH", ""));
//        System.out.println(price);
            Boolean bool = false;
            if (price > 1000 & price < 10000) {
                bool = true;
            } else {
                bool = false;
            }
            Assert.assertTrue(bool, "Oops");
            takeScreenshot(driver);
//        Thread.sleep(5000);
        }

        @Test(groups={"2nd_scope"})
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
            if (driver.findElements(By.xpath("//*[contains(text(),'Луганська')]")).size() != 0) {
                bool = true;
            } else {
                bool = false;
            }
            Assert.assertTrue(bool, "Oops");
            takeScreenshot(driver);

//        Thread.sleep(5000);
        }

        @Test(groups={"2nd_scope"})
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
            if (driver.findElements(By.xpath("//*[contains(text(),'Період уточнень')]")).size() != 0) {
                bool = true;
            } else {
                bool = false;
            }
            Assert.assertTrue(bool, "Oops");
            takeScreenshot(driver);

//        Thread.sleep(5000);
        }

        @Test(groups={"2nd_scope"})
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
            if (driver.findElements(By.xpath("//*[contains(text(),'Допорогові закупівлі')]")).size() != 0) {
                bool = true;
            } else {
                bool = false;
            }
            Assert.assertTrue(bool, "Oops");
            takeScreenshot(driver);

//        Thread.sleep(5000);
        }
}
