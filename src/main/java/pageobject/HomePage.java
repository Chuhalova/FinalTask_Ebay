package pageobject;

import net.bytebuddy.description.type.TypeDescription;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[text()='register']")
    private WebElement registerLink;

    @FindBy(xpath = "//a[text()='Sign out']")
    private WebElement signOutLink;

    @FindBy(xpath = "//button[@id='gh-ug']")
    private WebElement userMenuBtn;

    @FindBy(xpath = "//div[@id='gh-eb-u-o']")
    private WebElement userMenuPopup;

    @FindBy(xpath = "//a[@id='gh-uid']")
    private WebElement userMenuLink;

    @FindBy(xpath = "//span[@id='gh-ug']//a[text()='Sign in']")
    private WebElement signInLink;

    @FindBy(xpath = "//input[contains(@class, 'gh-tb')]")
    private WebElement searchInput;

    @FindBy(xpath = "//a[@class='hl-item__link']")
    private List<WebElement> clickableProducts;

    @FindBy(xpath = "//h3[@class='hl-popular-destinations-name' and text()='Korean beauty']")
    private WebElement koreanBeautyLink;

    @FindBy(xpath = "//li[@class='hl-cat-nav__js-tab']//a[contains(text(), 'Electronics')]")
    private WebElement electronicsLink;

    @FindBy(xpath = "//li[@class='hl-cat-nav__js-tab']//a[contains(text(), 'Fashion')]")
    private WebElement fashionLink;

    @FindBy(xpath = "//a[@class='hl-item__link']")
    private List<WebElement> dailyDealsProds;

    @FindBy(xpath = "//button[@id='gh-shop-a']")
    private WebElement buttonToCategories;

    @FindBy(xpath = "//div[@id='gh-sbc-o']")
    private WebElement popupWithCategories;

    @FindBy(xpath = "//div[@id='gh-sbc-o']//a[contains(@href, 'Collectibles-Art')]")
    private WebElement collectiblesAndArtLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickOnRegisterLink() {
        registerLink.click();
    }

    public void clickOnSignInLink() {
        signInLink.click();
    }

    public void clickOnSignOutLink() {
        signOutLink.click();
    }

    public void clickOnUserMenuBtn() {
        userMenuBtn.click();
    }

    public WebElement getUserMenuPopup() {
        return userMenuPopup;
    }

    public void clickOnUserMenuLink() {
        userMenuLink.click();
    }

    public void sendKeysToSearchInput(String searchInputText) {
        searchInput.sendKeys(searchInputText, Keys.ENTER);
    }

    public void clickOnFirstProductFromClickableProducts() {
        clickableProducts.get(0).click();
    }

    public void clickOnKoreanBeautyLink() {
        koreanBeautyLink.click();
    }

    public void clickOnElectronicsLink() {
        electronicsLink.click();
    }

    public void clickOnFirstDailyDealsProduct() {
        dailyDealsProds.get(2).click();
    }

    public void clickOnButtonToCategories() {
        buttonToCategories.click();
    }

    public WebElement getPopupWithCategories() {
        return popupWithCategories;
    }

    public void clickOnCollectiblesAndArtLink() {
        collectiblesAndArtLink.click();
    }
}
