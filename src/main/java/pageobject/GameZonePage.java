package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GameZonePage extends BasePage {

    public GameZonePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='brand-box__title']//a[contains(@href, 'igrovie-pristavki')]")
    private WebElement gamingConsoles;

    public void clickOnGamingConsoles() {
        gamingConsoles.click();
    }
}
