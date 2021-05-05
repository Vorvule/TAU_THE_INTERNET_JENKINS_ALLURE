package javascript;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LargeAndDeepDomPage;

public class JavaScripTests extends BaseTests {

    // DOM element is present
    @Test
    public void testScrollToTable() {
        // homePage.clickLargeAndDeepDom().scrollToTable();
        LargeAndDeepDomPage largeAndDeepDomPage = homePage.clickLargeAndDeepDom();
        largeAndDeepDomPage.scrollToTable();
    }

    // DOM element is absent
    @Test
    public void testScrollToFifthParagraph() {
        // make a breakpoint inside of this method
        homePage.clickInfiniteScroll().scrollToTextBlock(5);
    }
}
