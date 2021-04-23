package navigation;

import base.BaseTests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigator() {
        homePage.clickDynamicLoading().clickExample1Link();
        getWindowManager().goBack();
        getWindowManager().reFresh();
        getWindowManager().goForward();
        getWindowManager().goTo("https://tut.by");
    }

    // Multiple Windows
    @Test
    public void testSwitchTab() {
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }

    // Home Work
    @Test
    public void testCtrlClick() {
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoading();
        dynamicLoadingPage.ctrllickExample2Link();

        getWindowManager().switchToLastTab();
        Assert.assertTrue(dynamicLoadingPage.checkStartButtonPresence());
    }
}
