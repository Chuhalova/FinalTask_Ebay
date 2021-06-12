package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopByCategoryPage extends BasePage{

    @FindBy(xpath = "//a[contains(@class, 'b-visualnav')]")
    private List<WebElement> categories;

    public ShopByCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFirstCategory(){
        categories.get(0).click();
    }
}
