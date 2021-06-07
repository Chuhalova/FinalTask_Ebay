package pageobject.tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class SonyProductsTests extends BaseTests {
    private static final String PROD_NAME = "sony";
    private static final int WAIT_TIME = 30;

    @Test
    public void checkProdDescContainsSonyOnPageFilteredBySonyProds() {
        getHomePage().clickOnSideBarItem();
        getHomePage().clickOnGameZoneLink();
        getGameZonePage().waitForPageLoadingComplete(WAIT_TIME);
        getGameZonePage().clickOnGamingConsoles();
        getGamingConsolesPage().waitForPageLoadingComplete(WAIT_TIME);
        getGamingConsolesPage().clickOnSonyGamingConsolesLink();
        getGamingConsolesPage().implicitWait(WAIT_TIME);
        List<String> sonyProdDescs = getGamingConsolesPage().getSonyProductsDesc();
        for (String prodDesc : sonyProdDescs) {
            assertTrue(prodDesc.contains(PROD_NAME));
        }
    }
}
