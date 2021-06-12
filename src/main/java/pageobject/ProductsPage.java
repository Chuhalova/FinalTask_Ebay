package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//h3[@class='s-item__title']")
    private List<WebElement> productsTitles;

    @FindBy(xpath = "//li[contains(@class, 's-item')]")
    private List<WebElement> productsLinkedContainers;

    @FindBy(xpath = "//a[@class='s-item__link']")
    private List<WebElement> productsLinks;

    @FindBy(xpath = "//ul[@class='srp-results srp-list clearfix']")
    private WebElement containerWithProds;

    @FindBy(xpath = "//a[@class='s-item__link']//h3[contains(text(), 'Germany very nice of perfin stamps 24pf POL.')]")
    private WebElement stampsLink;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductsTitles() {
        List<String> productsTitlesText = new ArrayList<>();
        for (WebElement productTitle : productsTitles) {
            productsTitlesText.add(productTitle.getText().toLowerCase());
        }
        return productsTitlesText;
    }

    public void clickOnFirstProduct() {
        productsLinkedContainers.get(0).click();
    }

    public void clickOnContainer() {
        containerWithProds.click();
    }

    public void clickOnStampsLink() {
        stampsLink.click();
    }
}
