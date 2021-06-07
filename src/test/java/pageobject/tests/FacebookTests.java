package pageobject.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FacebookTests extends BaseTests {
    private static final String FACEBOOK_LINK = "https://www.facebook.com/avicshop/";

    @Test
    public void checkFacebookLink() {
        getHomePage().clickOnContactPageLink();
        getContactPage().waitForPageLoadingComplete(30);
        assertTrue(getContactPage().getLinksList().equals(FACEBOOK_LINK));
    }
}
