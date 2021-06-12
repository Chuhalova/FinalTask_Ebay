package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[@id='vi-atl-lnk']//a")
    private WebElement addToWatchListButton;

    @FindBy(xpath = "//div[@id='msgPanel']")
    private WebElement msgWithInfoAboutWatchlistPanel;

    @FindBy(xpath = "//span[@id='w1-7-_lmsg']")
    private WebElement messageInWatchlistInfoPanel;

    @FindBy(xpath = "//a[@id='w1-7-_rmv']")
    private WebElement removeBtnInWatchlistInfoPanel;

    @FindBy(xpath = "//a[@id='isCartBtn_btn']")
    private WebElement cartBtn;

    @FindBy(xpath = "//h1[@class='it-ttl']")
    private WebElement productsTitle;

    @FindBy(xpath = "//a[@id='binBtn_btn']")
    private WebElement buyBtn;

    @FindBy(xpath = "//span[@id='prcIsum']")
    private WebElement price;

    @FindBy(xpath = "//a[@id='boBtn_btn']")
    private WebElement makeOfferLink;

    @FindBy(xpath = "//div[@class='oly_container']")
    private WebElement olyPopup;

    @FindBy(xpath = "//input[@id='price-input']")
    private WebElement priceInput;

    @FindBy(xpath = "//button[@id='button-primary']")
    private WebElement reviewOfferBtn;

    @FindBy(xpath = "//button[@aria-label='Submit offer']")
    private WebElement submitOfferBtn;

    @FindBy(xpath = "//div[@id='bstofr']")
    private WebElement reviewOfferPopup;

    @FindBy(xpath = "//a[contains(text(), 'retract your offer')]")
    private WebElement finishBtn;

    @FindBy(xpath = "//span[contains(@class, 'bestofferlayer-offer')]//span")
    private WebElement finishMakingOfferTitle;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToWatchListButton() {
        addToWatchListButton.click();
    }

    public WebElement getMsgWithInfoAboutWatchlistPanel() {
        return msgWithInfoAboutWatchlistPanel;
    }

    public String getMessageInWatchListInfoPanel() {
        return messageInWatchlistInfoPanel.getText();
    }

    public void clickOnRemoveBtnInWatchlistInfoPanel() {
        removeBtnInWatchlistInfoPanel.click();
    }

    public void clickOnCartButton() {
        cartBtn.click();
    }

    public String getProductsTitle() {
        return productsTitle.getText();
    }

    public void clickOnBuyBtn() {
        buyBtn.click();
    }

    public String getPrice() {
        return price.getText().toLowerCase();
    }

    public void clickOnMakeOfferLink() {
        makeOfferLink.click();
    }

    public WebElement getOlyPopup() {
        return olyPopup;
    }

    public void sendKeysToPriceInput(String price) {
        priceInput.sendKeys(price);
    }

    public void clickOnReviewOfferBtn() {
        reviewOfferBtn.click();
    }

    public void clickOnSubmitOfferBtn() {
        submitOfferBtn.click();
    }

    public WebElement getSubmitOfferBtn() {
        return submitOfferBtn;
    }

    public WebElement getReviewOfferPopup() {
        return reviewOfferPopup;
    }

    public String getFinishMakingOfferTitle() {
        return finishMakingOfferTitle.getText().toLowerCase();
    }

    public WebElement getFinishBtn() {
        return finishBtn;
    }
}
