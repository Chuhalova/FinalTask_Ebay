package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage extends BasePage {

    @FindBy(xpath = "//div[@id='signout-banner-text']//h1")
    private WebElement signOutH1;

    @FindBy(xpath = "//div[@id='signout-banner-text']//p")
    private WebElement signOutParagraph;

    public LogOutPage(WebDriver driver) {
        super(driver);
    }

    public String getSignOutH1() {
        return signOutH1.getText();
    }

    public String getSignOutParagraph() {
        return signOutParagraph.getText();
    }
}
