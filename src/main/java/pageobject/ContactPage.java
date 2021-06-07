package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactPage extends BasePage {

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class='list-soc']//a")
    private List<WebElement> linksList;

    public String getLinksList() {
        return linksList.get(0).getAttribute("href");
    }
}
