package pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {
    Actions act = new Actions(driver);

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstnameInputInRegistrationForm;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastnameInputInRegistrationForm;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailInputInRegistrationForm;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInputInRegistrationForm;

    @FindBy(xpath = "//button[@id='EMAIL_REG_FORM_SUBMIT']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//div[@class='global-header']")
    private WebElement headerOnRegistrationPage;

    @FindBy(xpath = "//div[contains(@class, 'reclaim')]//h1")
    private WebElement failedRegistrationTitle;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void sendKeysToOnFirstnameInputInRegistrationForm(String firstnameForRegistrationForm) {
        firstnameInputInRegistrationForm.sendKeys(firstnameForRegistrationForm);
    }

    public void sendKeysToOnLastnameInputInRegistrationForm(String lastnameForRegistrationForm) {
        lastnameInputInRegistrationForm.sendKeys(lastnameForRegistrationForm);
    }

    public void sendKeysToOnEmailInputInRegistrationForm(String emailForRegistrationForm) {
        emailInputInRegistrationForm.sendKeys(emailForRegistrationForm);
    }

    public void sendKeysToOnPasswordInputInRegistrationForm(String passwordForRegistrationForm) {
        passwordInputInRegistrationForm.sendKeys(passwordForRegistrationForm);
    }

    public WebElement getCreateAccountButton() {
        return createAccountButton;
    }

    public void clickOnCreateAccountButton() {
        createAccountButton.click();
    }

    public String getTextFromFailedRegistrationTitle() {
        return failedRegistrationTitle.getText();
    }
}
