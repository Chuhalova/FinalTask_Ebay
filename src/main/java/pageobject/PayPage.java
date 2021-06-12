package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;

public class PayPage extends BasePage {

    @FindBy(xpath = "//tr[@data-test-id='SUB_TOTAL']//td[@class='amount']//span[@class!='text-display']")
    private WebElement spanPrice;

    @FindBy(xpath = "//div[@class='item-title']//span[@class!='text-display']")
    private WebElement titleProd;

    public PayPage(WebDriver driver) {
        super(driver);
    }

    public String getSpanPrice() {
        return spanPrice.getText().toLowerCase();
    }

    public String getTitleProd() {
        return titleProd.getText();
    }
}
