package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//span[@class='BOLD']")
    private List<WebElement> titlesOfProducts;

    @FindBy(xpath = "//button[@data-test-id='cart-remove-item']")
    private List<WebElement> btnRemoveProduct;

    @FindBy(xpath = "//i[@id='gh-cart-n']")
    private WebElement cartNum;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleOfProduct() {
        return titlesOfProducts.get(0).getText().toLowerCase();
    }

    public void removeLastProduct() {
        btnRemoveProduct.get(0).click();
    }

    public String getCartNum() {
        return cartNum.getText();
    }
}
