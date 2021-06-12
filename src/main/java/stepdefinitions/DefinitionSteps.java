package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.*;


import java.util.Arrays;
import java.util.List;


import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class DefinitionSteps {
    private WebDriver driver;
    PageFactoryManager pageFactoryManager;
    private static final String EBAY_COM = "https://www.ebay.com/";
    private static final long STANDART_TIME_TO_WAIT = 30;
    private static final String FIRST_NAME_FOR_AUTH = "Pamela";
    private static final String LAST_NAME_FOR_AUTH = "Ward";
    private static final String EMAIL_FOR_SIGN_UP = "pam.e.l.awar.d.tx@gmail.com";
    private static final String EMAIL_FOR_SIGN_IN = "p.a.m.e.l.awardtx@gmail.com";
    private static final String PASSWORD_FOR_AUTH = "123$%^QWErty";
    public static final String LOGOUT_H1 = "signed out";
    public static final String LOGOUT_PARAGRAPH = "return to your account to enjoy buying and selling";
    public static final String LOGOUT_URL = "logout";
    public static final String FAILED_REGISTRATION_MSG = "an account already exists";
    public static final String SUCCESS_OFFER_TITLE = "Thanks! We've sent your offer";
    public String productsTitle;
    public String phoneTitle;
    public String price;

    HomePage homePage;
    SignUpPage signUpPage;
    ProfilePage profilePage;
    SignInPage signInPage;
    LogOutPage logOutPage;
    ProductsPage productsPage;
    ProductPage productPage;
    CartPage cartPage;
    KoreanBeautyProductsPage koreanBeautyProductsPage;
    ShopByCategoryPage shopByCategoryPage;
    PayPage payPage;
    CategoryPage categoryPage;
    StampsPage stampsPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens homepage")
    public void userOpensHomepage() {
        homePage = PageFactoryManager.getHomePage();
        homePage.openHomePage(EBAY_COM);
    }

    @And("User opens registration page")
    public void userOpensRegistrationPage() {
        homePage.clickOnRegisterLink();
        signUpPage = PageFactoryManager.getSignUpPage();
        signUpPage.implicitWait(STANDART_TIME_TO_WAIT * 5);
        signUpPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
    }

    @When("User fills the registration form with the correct values")
    public void userFillsTheRegistrationFormWithTheCorrectValues() {
        signUpPage.sendKeysToOnFirstnameInputInRegistrationForm(FIRST_NAME_FOR_AUTH);
        signUpPage.sendKeysToOnLastnameInputInRegistrationForm(LAST_NAME_FOR_AUTH);
        signUpPage.sendKeysToOnEmailInputInRegistrationForm(EMAIL_FOR_SIGN_UP);
        signUpPage.sendKeysToOnPasswordInputInRegistrationForm(PASSWORD_FOR_AUTH);
    }

    @And("User clicks on button to finalize registration")
    public void userClicksOnButtonToFinalizeRegistration() {
        signUpPage.waitForEnabledElement(STANDART_TIME_TO_WAIT, signUpPage.getCreateAccountButton());
        signUpPage.clickOnCreateAccountButton();
    }

    @Then("User goes to homepage and opens menu popup")
    public void userGoesToHomepageAndOpensMenuPopup() {
        homePage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
        homePage.implicitWait(STANDART_TIME_TO_WAIT);
        homePage.clickOnUserMenuBtn();
        homePage.waitVisibilityOfElement(STANDART_TIME_TO_WAIT, homePage.getUserMenuPopup());
    }

    @And("User checks the registration success and profile information")
    public void userChecksTheRegistrationSuccessAndProfileInformation() {
        homePage.clickOnUserMenuLink();
        profilePage = PageFactoryManager.getProfilePage();
        profilePage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
        String url = driver.getCurrentUrl();
        String profileNameText = profilePage.getProfileNameText();
        assertTrue(url.contains(profileNameText));
    }

    @And("User opens login page")
    public void userOpensLoginPage() {
        homePage.clickOnSignInLink();
        signInPage = PageFactoryManager.getSignInPage();
        signInPage.implicitWait(STANDART_TIME_TO_WAIT * 5);
        signInPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
    }

    @When("User fills forms and clicks on button to finalize login")
    public void userFillsFormsAndClicksOnButtonToFinalizeLogin() {
        signInPage.sendKeysToEmailInputInLoginForm(EMAIL_FOR_SIGN_IN);
        signInPage.clickOnContinueLoginButton();
        signInPage.implicitWait(STANDART_TIME_TO_WAIT);
        signInPage.sendKeysToPasswordInputInLoginForm(PASSWORD_FOR_AUTH);
        signInPage.clickOnFinalizeLoginButton();
    }

    @And("User clicks logout button")
    public void userClicksLogoutButton() {
        homePage.clickOnSignOutLink();
    }

    @And("User checks success of logging out")
    public void userChecksSuccessOfLoggingOut() {
        logOutPage = PageFactoryManager.getLogOutPage();
        logOutPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
        String logoutH1 = logOutPage.getSignOutH1().toLowerCase();
        String logoutParagraph = logOutPage.getSignOutParagraph().toLowerCase();
        String logoutUrl = driver.getCurrentUrl();
        assertTrue(logoutH1.contains(LOGOUT_H1.toLowerCase()));
        assertTrue(logoutParagraph.contains(LOGOUT_PARAGRAPH.toLowerCase()));
        assertTrue(logoutUrl.contains(LOGOUT_URL.toLowerCase()));
    }

    @When("User search {string}")
    public void userSearchProduct(String searchInputText) {
        homePage.sendKeysToSearchInput(searchInputText);
    }

    @Then("User gets page with products")
    public void userGetsPageWithProducts() {
        productsPage = PageFactoryManager.getProductsPage();
        productsPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
    }

    @And("User checks the correctness of the {string}")
    public void userChecksTheCorrectnessOfTheSearchOutput(String keywords) {
        List<String> keysFromSearchInput = Arrays.asList(keywords.split(","));
        List<String> productsTitles = productsPage.getProductsTitles();
        for (String productTitle : productsTitles) {
            for (String keyword : keysFromSearchInput
            ) {
                assertTrue(productTitle.contains(keyword));
            }
        }
    }

    @And("User opens products page from the homepage")
    public void userOpensProductsPageFromTheHomepage() {
        homePage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
        homePage.implicitWait(STANDART_TIME_TO_WAIT);
        homePage.clickOnFirstProductFromClickableProducts();
        productPage = PageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
    }

    @And("User adds to watchlist product")
    public void userAddsToWatchlistProduct() {
        productPage.clickOnAddToWatchListButton();
    }

    @Then("User checks the correctness of adding product to the list")
    public void userChecksTheCorrectnessOfAddingProductToTheList() {
        productPage.waitVisibilityOfElement(STANDART_TIME_TO_WAIT, productPage.getMsgWithInfoAboutWatchlistPanel());
        assertTrue(productPage.getMessageInWatchListInfoPanel().toLowerCase().contains("added to your"));
    }

    @And("User removes the product from the watchlist")
    public void userRemovesTheProductFromTheWatchlist() {
        productPage.clickOnRemoveBtnInWatchlistInfoPanel();
    }

    @And("User opens koreanProductsPage")
    public void userOpensKoreanProductsPage() {
        homePage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
        homePage.implicitWait(STANDART_TIME_TO_WAIT);
        homePage.clickOnKoreanBeautyLink();
        koreanBeautyProductsPage = PageFactoryManager.getKoreanBeautyProductsPage();
        koreanBeautyProductsPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
    }

    @And("User clicks on product from the bestsellers products")
    public void userClicksOnProductFromTheBestsellersProducts() {
        koreanBeautyProductsPage.clickOnProductFromBestSellerProducts();
    }

    @And("User adds to cart product")
    public void userAddsToCartProduct() {
        productPage = PageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
        productsTitle = productPage.getProductsTitle();
        productPage.clickOnCartButton();
    }

    @Then("User checks the correctness of adding product to the cart")
    public void userChecksTheCorrectnessOfAddingProductToTheCart() {
        cartPage = PageFactoryManager.getCartPage();
        cartPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
        assertTrue(cartPage.getTitleOfProduct().contains(productsTitle.toLowerCase()));
    }

    @And("User removes last product from the cart")
    public void userRemovesLastProductFromTheCart() {
        cartPage.removeLastProduct();
    }

    @When("User fills the registration form with the incorrect values")
    public void userFillsTheRegistrationFormWithTheIncorrectValues() {
        signUpPage.sendKeysToOnFirstnameInputInRegistrationForm(FIRST_NAME_FOR_AUTH);
        signUpPage.sendKeysToOnLastnameInputInRegistrationForm(LAST_NAME_FOR_AUTH);
        signUpPage.sendKeysToOnEmailInputInRegistrationForm(EMAIL_FOR_SIGN_IN);
        signUpPage.sendKeysToOnPasswordInputInRegistrationForm(PASSWORD_FOR_AUTH);
    }

    @Then("User checks the registration fail")
    public void userChecksTheRegistrationFail() {
        signUpPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
        assertTrue(signUpPage.getTextFromFailedRegistrationTitle().toLowerCase().contains(FAILED_REGISTRATION_MSG));
    }

    @And("User goes to the page with phones from the menu")
    public void userGoesToThePageWithPhonesFromTheMenu() {
        homePage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
        homePage.implicitWait(STANDART_TIME_TO_WAIT);
        homePage.clickOnElectronicsLink();
        shopByCategoryPage = PageFactoryManager.getShopByCategoryPage();
        for (int i = 0; i < 2; i++) {
            shopByCategoryPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
            shopByCategoryPage.clickOnFirstCategory();
        }
    }

    @And("User click opens phone page")
    public void userClickOpensPhonePage() {
        productsPage = PageFactoryManager.getProductsPage();
        productsPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
        productsPage.clickOnFirstProduct();
    }

    @And("User clicks on buy button")
    public void userClicksOnBuyButton() {
        productPage = PageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
        price = productPage.getPrice();
        phoneTitle = productPage.getProductsTitle();
        productPage.clickOnBuyBtn();
    }

    @Then("User checks ordered product")
    public void userChecksOrderedProduct() {
        payPage = PageFactoryManager.getPayPage();
        payPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
        assertTrue(payPage.getSpanPrice().contains(price));
        assertTrue(payPage.getTitleProd().contains(phoneTitle));
    }

    @And("User clicks on the first daily deals product")
    public void userClicksOnTheFirstDailyDealsProduct() {
        homePage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
        homePage.implicitWait(STANDART_TIME_TO_WAIT);
        homePage.clickOnFirstDailyDealsProduct();
    }

    @Then("User checks the cart num")
    public void userChecksTheCartNum() {
        cartPage = PageFactoryManager.getCartPage();
        cartPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
        assertTrue(cartPage.getCartNum().contains("1"));
    }

    @And("User goes to products page")
    public void userGoesToProductsPage() {
        productsPage.clickOnContainer();
        productsPage.clickOnFirstProduct();
        productPage = PageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);

    }

    @And("User opens product page from shop by category popup")
    public void userOpensProductPageFromShopByCategoryPopup() {
        homePage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
        homePage.implicitWait(STANDART_TIME_TO_WAIT);
        homePage.clickOnButtonToCategories();
        homePage.waitVisibilityOfElement(STANDART_TIME_TO_WAIT, homePage.getPopupWithCategories());
        homePage.clickOnCollectiblesAndArtLink();
        categoryPage = PageFactoryManager.getCategoryPage();
        categoryPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
        categoryPage.clickOnStampsLink();
        stampsPage = PageFactoryManager.getStampsPage();
        stampsPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
        stampsPage.clickOnSubcategory();
        productsPage = PageFactoryManager.getProductsPage();
        productsPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
        productsPage.clickOnStampsLink();
        productPage = PageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(STANDART_TIME_TO_WAIT);
    }

    @And("User makes offer")
    public void userMakesOffer() {
        productPage.clickOnMakeOfferLink();
        productPage.waitVisibilityOfElement(STANDART_TIME_TO_WAIT, productPage.getOlyPopup());
        productPage.sendKeysToPriceInput("100");
        productPage.clickOnReviewOfferBtn();
        productPage.waitVisibilityOfElement(STANDART_TIME_TO_WAIT, productPage.getSubmitOfferBtn());
        productPage.clickOnSubmitOfferBtn();
        productPage.waitVisibilityOfElement(STANDART_TIME_TO_WAIT, productPage.getFinishBtn());
    }

    @Then("User checks the correctness of making offer")
    public void userChecksTheCorrectnessOfMakingOffer() {
        assertTrue(productPage.getFinishMakingOfferTitle().contains(SUCCESS_OFFER_TITLE.toLowerCase()));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}

