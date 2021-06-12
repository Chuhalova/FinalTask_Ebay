package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href,'Stamps')]")
    private List<WebElement> stampsLinks;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnStampsLink() {
        stampsLinks.get(0).click();
    }
}
