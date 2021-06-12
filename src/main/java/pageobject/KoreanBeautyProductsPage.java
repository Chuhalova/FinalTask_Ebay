package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class KoreanBeautyProductsPage extends BasePage {


    @FindBy(xpath = "//a[@class='b-tile']")
    private List<WebElement> bestSellerProducts;

    public KoreanBeautyProductsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnProductFromBestSellerProducts() {
        bestSellerProducts.get(0).click();
    }
}
