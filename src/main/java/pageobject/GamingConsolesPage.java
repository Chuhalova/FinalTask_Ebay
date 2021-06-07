package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class GamingConsolesPage extends BasePage {
    public GamingConsolesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'filter-area')]//a[contains(@href, 'proizvoditel--sony')]")
    private WebElement sonyGamingConsolesLink;

    @FindBy(xpath = "//div[@class='prod-cart__descr']")
    private List<WebElement> sonyProducts;

    public void clickOnSonyGamingConsolesLink() {
        sonyGamingConsolesLink.click();
    }

    public List<String> getSonyProductsDesc() {
        List<String> sonyProductsDesc = new ArrayList<>();
        for (WebElement prod : sonyProducts) {
            sonyProductsDesc.add(prod.getText().toLowerCase());
        }
        return sonyProductsDesc;
    }
}
