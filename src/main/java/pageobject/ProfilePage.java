package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    @FindBy(xpath = "//a[@class='mbg-id']")
    private WebElement profileName;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getProfileNameText() {
        return profileName.getText();
    }
}
