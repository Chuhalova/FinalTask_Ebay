package pageobject.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class RequestForCorpClientTests extends BaseTests {
    private static final String NAME = "TestName";
    private static final String EMAIL = "testEmail@gmail.com";

    //    private static final String MODAL_TITLE = "Успешно!";
    @Test
    public void checkSuccessMessageWhenSendingRequestForCorpClients() {
        getHomePage().enterNameInRequestForCorpClientForm(NAME);
        getHomePage().enterEmailInRequestForCorpClientForm(EMAIL);
        getHomePage().clickOnSendRequestBtn();
        getHomePage().waitForVisibilityElement(10, getHomePage().getModalAlert());
        assertFalse(getHomePage().getModalAlertTitle().isEmpty());
//        assertEquals(getHomePage().getModalAlertTitle(), MODAL_TITLE);
    }
}
