package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    @FindBy(xpath = "//a[contains(@class, 'js_addMessage_btn')]")
    private WebElement addMessageButton;

    @FindBy(id = "js_addMessage")
    private WebElement jsAddMessagePopup;

    @FindBy(xpath = "//form[@data-recipient-name='Директору магазина']//input[@name='user_name']")
    private WebElement userNameInLetterToDirectorPopupInput;

    @FindBy(xpath = "//form[@data-recipient-name='Директору магазина']//input[@name='user_email']")
    private WebElement emailInLetterToDirectorPopupInput;

    @FindBy(xpath = "//form[@data-recipient-name='Директору магазина']//textarea")
    private WebElement textInLetterToDirectorPopupInput;

    @FindBy(xpath = "//form[@data-recipient-name='Директору магазина']//button")
    private WebElement sendMessageToDirectorButton;

    @FindBy(id = "js_addThanksMessage")
    private WebElement jsAddThanksMessagePopup;

    @FindBy(xpath = "//div[@id='js_addThanksMessage']//div[contains(@class, 'color-green')]")
    private WebElement thanksMessage;

    @FindBy(xpath = "//ul[contains(@class, 'header-top')]//a[text()='Контакты']")
    private WebElement contactPageLink;

    @FindBy(xpath = "//span[@class='sidebar-item']")
    private WebElement sidebarItem;

    @FindBy(xpath = "//ul[contains(@class,'sidebar-list')]//a[contains(@href,'game-zone')]")
    private WebElement gameZoneLink;

    @FindBy(xpath = "//form[contains(@class, 'subscribe-form')]//input[@name='name']")
    private WebElement nameInputInRequestForCorpClientForm;

    @FindBy(xpath = "//form[contains(@class, 'subscribe-form')]//input[@name='email']")
    private WebElement emailInputInRequestForCorpClientForm;


    @FindBy(xpath = "//button[contains(text(), 'Отправить заявку')]")
    private WebElement sendRequestBtn;

    @FindBy(id = "modalAlert")
    private WebElement modalAlert;

    @FindBy(xpath = "//div[contains(@class, 'js_title')]")
    private WebElement modalAlertTitle;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddMessageButton() {
        addMessageButton.click();
    }

    public WebElement getJsAddMessagePopup() {
        return jsAddMessagePopup;
    }

    public void enterUserNameInLetterToDirectorPopup(String userName) {
        userNameInLetterToDirectorPopupInput.sendKeys(userName);
    }

    public void enterEmailInLetterToDirectorPopup(String email) {
        emailInLetterToDirectorPopupInput.sendKeys(email);
    }

    public void enterTextInLetterToDirectorPopup(String text) {
        textInLetterToDirectorPopupInput.sendKeys(text);
    }

    public void sendMessageToDirector() {
        sendMessageToDirectorButton.click();
    }

    public WebElement getJsAddThanksMessagePopup() {
        return jsAddThanksMessagePopup;
    }

    public String getTextOfThanksMessage() {
        return thanksMessage.getText();
    }

    public void clickOnContactPageLink() {
        contactPageLink.click();
    }

    public void clickOnSideBarItem() {
        sidebarItem.click();
    }

    public void clickOnGameZoneLink() {
        gameZoneLink.click();
    }

    public void enterNameInRequestForCorpClientForm(String name) {
        nameInputInRequestForCorpClientForm.sendKeys(name);
    }

    public void enterEmailInRequestForCorpClientForm(String email) {
        emailInputInRequestForCorpClientForm.sendKeys(email);
    }

    public void clickOnSendRequestBtn() {
        sendRequestBtn.click();
    }

    public WebElement getModalAlert() {
        return modalAlert;
    }

    public String getModalAlertTitle() {
        return modalAlertTitle.getText();
    }
}
