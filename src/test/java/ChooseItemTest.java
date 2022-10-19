import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ChooseItemTest {

    @Test
    public void searchForItem() {
        // 1. Открыть браузер
        // 2. Зайти на сайт
        ChromeOptions options = new ChromeOptions();
        // options.setHeadless(true);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("https://mile.by");
        browser.findElement(By.cssSelector("[class=\"header-search\"]")).sendKeys("замок");
        browser.findElement(By.cssSelector("[type=\"submit\"]")).click();//div[contains(text(),'7.6')]
        String result = browser.findElement(By.xpath("//h1[contains(text(),'Результаты по запросу: замок')]")).getText();
        // System.out.println(result);
        assertEquals(result, "Результаты по запросу: замок", "Ops, something went wrong");
        browser.quit();
    }

    @Test
    public void chooseItem() {
        // 1. Открыть браузер
        // 2. Зайти на сайт
        ChromeOptions options = new ChromeOptions();
        // options.setHeadless(true);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("https://mile.by");
        browser.findElement(By.xpath("//span[contains(text(),'каталог')]")).click();
        browser.findElement(By.xpath("//a[contains(text(),'Отделочные материалы')]")).click();
        browser.findElement(By.xpath("//h2[contains(text(),'Напольные покрытия')]")).click();
        browser.findElement(By.xpath("//h2[contains(text(),'Искусственная трава')]")).click();
        browser.findElement(By.cssSelector("[title=\"Искусственная трава Ricco ПП 12 DECO 30 м x 1,33 м\"]")).click();
        browser.findElement(By.xpath("//span[contains(text(),'В корзину')]")).click();
        boolean isOpened = browser.findElement(By.xpath("//div[contains(text(),'Товар добавлен в корзину')]")).isDisplayed();
        assertTrue(isOpened, "message was not opened");
        browser.quit();
    }

    @Test
    public void switchToPage() {
        // 1. Открыть браузер
        // 2. Зайти на сайт
        ChromeOptions options = new ChromeOptions();
        // options.setHeadless(true);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("https://mile.by");
        browser.findElement(By.xpath("//span[contains(text(),'каталог')]")).click();
        browser.findElement(By.xpath("//a[contains(text(),'Спорт и активный отдых')]")).click();
        String newPage = browser.findElement(By.xpath("//h1[contains(text(),'Спорт и активный отдых')]")).getText();
        // System.out.println(result);
        assertEquals(newPage, "Спорт и активный отдых", "Ops, something went wrong");
    }
}
