package manager;

import org.openqa.selenium.WebDriver;
import pageobject.*;

public class PageFactoryManager {

    private static WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public static HomePage getHomePage() {
        return new HomePage(driver);
    }

    public static SignUpPage getSignUpPage() {
        return new SignUpPage(driver);
    }

    public static ProfilePage getProfilePage() {
        return new ProfilePage(driver);
    }

    public static SignInPage getSignInPage() {
        return new SignInPage(driver);
    }

    public static LogOutPage getLogOutPage() {
        return new LogOutPage(driver);
    }

    public static ProductsPage getProductsPage() {
        return new ProductsPage(driver);
    }

    public static ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public static CartPage getCartPage() {
        return new CartPage(driver);
    }

    public static KoreanBeautyProductsPage getKoreanBeautyProductsPage() {
        return new KoreanBeautyProductsPage(driver);
    }

    public static ShopByCategoryPage getShopByCategoryPage() {
        return new ShopByCategoryPage(driver);
    }

    public static PayPage getPayPage() {
        return new PayPage(driver);
    }

    public static CategoryPage getCategoryPage() {
        return new CategoryPage(driver);
    }

    public static StampsPage getStampsPage() {
        return new StampsPage(driver);
    }
}
