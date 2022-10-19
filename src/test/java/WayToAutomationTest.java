import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.testng.Assert.assertTrue;

public class WayToAutomationTest {
    private final By FIRST_NAME = By.name("name");
    private final By LAST_NAME = By.xpath("(//input[@type=\"text\"])[2]");
    private final By MARRIED_STATUS = By.name("m_status");
    private final By HOBBY_READING = By.xpath("(//input[@type=\"checkbox\"])[2]");
    private final By PHONE_ENTRY = By.xpath("(//input[@name=\"phone\"])[1]");
    private final By LOGIN_ENTRY = By.xpath("(//input[@name=\"username\"])[1]");
    private final By EMAIL_ENTRY = By.xpath("(//input[@name=\"email\"])[1]");
    private final By PASSWORD_ENTRY = By.xpath("(//input[@name=\"password\"])[1]");
    private final By PASSWORD_CHECK = By.name("c_password");
    private final By SUBMIT_BUTTON = By.cssSelector("[value=\"submit\"]");

    @Test
    public void correctRegistration() {

        ChromeOptions options = new ChromeOptions();
        // options.setHeadless(true);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");

        browser.findElement(FIRST_NAME).sendKeys("Rada");
        browser.findElement(LAST_NAME).sendKeys("RadaR");
        browser.findElement(MARRIED_STATUS).click();
        browser.findElement(HOBBY_READING).click();
        browser.findElement(PHONE_ENTRY).sendKeys("+375 00089649");
        browser.findElement(LOGIN_ENTRY).sendKeys("Radomir");
        browser.findElement(EMAIL_ENTRY).sendKeys("rada@sandbox.com");
        browser.findElement(PASSWORD_ENTRY).sendKeys("Rada789");
        browser.findElement(PASSWORD_CHECK).sendKeys("Rada789");
        browser.findElement(SUBMIT_BUTTON).click();
        if (browser.findElements(By.xpath("//label[contains(text(),'This field is required.')]")).size() == 0) {
            System.out.println("SUCCESSFUL REGISTRATION");
        }
    }

    @Test
    public void emptyFields() {

        ChromeOptions options = new ChromeOptions();
        // options.setHeadless(true);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");

        browser.findElement(FIRST_NAME).sendKeys("Rada");
        browser.findElement(LAST_NAME).sendKeys("RadaR");
        browser.findElement(MARRIED_STATUS).click();
        browser.findElement(HOBBY_READING).click();
        browser.findElement(PHONE_ENTRY).sendKeys(" ");
        browser.findElement(LOGIN_ENTRY).sendKeys("Radomir");
        browser.findElement(EMAIL_ENTRY).sendKeys(" ");
        browser.findElement(PASSWORD_ENTRY).sendKeys("Rada789");
        browser.findElement(PASSWORD_CHECK).sendKeys("Rada789");
        browser.findElement(SUBMIT_BUTTON).click();
        boolean registrationFailed = browser.findElement(By.xpath("//label[contains(text(),'This field is required.')]")).isDisplayed();
        assertTrue(registrationFailed, "Registration passed but the required fields were left unfilled");
    }
}