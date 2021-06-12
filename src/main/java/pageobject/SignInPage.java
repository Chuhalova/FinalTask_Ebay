package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[@id='userid']")
    private WebElement emailInputInLoginForm;


    @FindBy(xpath = "//input[@id='pass']")
    private WebElement passwordInputInLoginForm;

    @FindBy(xpath = "//button[@id='signin-continue-btn']")
    private WebElement continueLoginButton;


    @FindBy(xpath = "//button[@id='sgnBt']")
    private WebElement finalizeLoginButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void sendKeysToEmailInputInLoginForm(String emailForLoginForm) {
        emailInputInLoginForm.sendKeys(emailForLoginForm);
    }

    public void sendKeysToPasswordInputInLoginForm(String passwordForLoginForm) {
        passwordInputInLoginForm.sendKeys(passwordForLoginForm);
    }

    public void clickOnContinueLoginButton() {
        continueLoginButton.click();
    }

    public void clickOnFinalizeLoginButton() {
        finalizeLoginButton.click();
    }
}
