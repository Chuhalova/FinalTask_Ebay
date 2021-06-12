package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StampsPage extends BasePage {

    @FindBy(xpath = "//a[@class='b-guidancecard__link' and contains(@href, 'Europe')]")
    private WebElement subcategoryEurope;

    public StampsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSubcategory() {
        subcategoryEurope.click();
    }
}
