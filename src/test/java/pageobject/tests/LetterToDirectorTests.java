package pageobject.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LetterToDirectorTests extends BaseTests {
    private static final String USER_NAME = "TestName";
    private static final String EMAIL = "testEmail@gmail.com";
    private static final String TEXT = "Test message.";
    private static final String THANKS_MESSAGE = "Сообщение успешно отправлено";

    @Test
    public void checkSuccessMessageWhenSendingLetterToDirector() {
        getHomePage().clickOnAddMessageButton();
        getHomePage().waitForVisibilityElement(10, getHomePage().getJsAddMessagePopup());
        getHomePage().enterUserNameInLetterToDirectorPopup(USER_NAME);
        getHomePage().enterEmailInLetterToDirectorPopup(EMAIL);
        getHomePage().enterTextInLetterToDirectorPopup(TEXT);
        getHomePage().sendMessageToDirector();
        getHomePage().waitForVisibilityElement(10, getHomePage().getJsAddThanksMessagePopup());
        assertEquals(getHomePage().getTextOfThanksMessage(), THANKS_MESSAGE);
    }
}
