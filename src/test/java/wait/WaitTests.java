package wait;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;

public class WaitTests extends BaseTests {

    @Test
    public void testWaitUntilHidden() {
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoading();
        DynamicLoadingPage.Example1Page example1Page = dynamicLoadingPage.clickExample1Link();
        example1Page.clickStartButton();

        Assert.assertEquals(example1Page.getLoadedText(), "Hello World!", "Wrong loaded text");
    }

    @Test
    public void testWaitUntilDisplayed() {
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoading();
        DynamicLoadingPage.Example2Page example2Page = dynamicLoadingPage.clickExample2Link();
        example2Page.clickStartButton();

        Assert.assertEquals(example2Page.getLoadedText(), "Hello World!", "Wrong loaded text");

    }
}
