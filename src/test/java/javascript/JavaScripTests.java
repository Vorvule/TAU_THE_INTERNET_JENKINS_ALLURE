package javascript;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LargeAndDeepDomPage;

public class JavaScripTests extends BaseTests {

    @Test
    public void testScrollToTable() {
        LargeAndDeepDomPage largeAndDeepDomPage = homePage.clickLargeAndDeepDom();
        largeAndDeepDomPage.scrollToTable();
        // homePage.clickLargeAndDeepDom().scrollToTable();
    }

    @Test
    public void testScrollToFifthParagraph() {
        homePage.clickInfiniteScroll().scrollToParagraph(5);
        // make a breakpoint inside of this method
    }
}
