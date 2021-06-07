package pageobject.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageobject.ContactPage;
import pageobject.GameZonePage;
import pageobject.GamingConsolesPage;
import pageobject.HomePage;

public class BaseTests {
    private WebDriver driver;
    private static final String AVIC_URL = "https://avic.ua/";

    @BeforeTest
    public void profileSetUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();//создаем экзаемпляр хром драйвера
        driver.manage().window().maximize();//открыли браузер на весь экран
        driver.get(AVIC_URL); //открыли сайт
    }

    @AfterMethod
    public void tearDown() {
        driver.close();//закрытие драйвера
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public ContactPage getContactPage() {
        return new ContactPage(getDriver());
    }

    public GameZonePage getGameZonePage() {
        return new GameZonePage(getDriver());
    }

    public GamingConsolesPage getGamingConsolesPage() {
        return new GamingConsolesPage(getDriver());
    }
}
