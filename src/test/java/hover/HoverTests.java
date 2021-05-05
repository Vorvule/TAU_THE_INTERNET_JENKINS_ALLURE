package hover;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;

public class HoverTests extends BaseTests {

    @Test
    public void testHoverUser1() {
        HoversPage hoversPage = homePage.clickHovers();
        HoversPage.FigureCaption caption = hoversPage.hoverOverFigure(1);
        Assert.assertTrue(caption.captionIsDisplayed(), "Caption is not displayed");
        Assert.assertEquals(caption.getHeaderText(), "name: user1", "Caption title is wrong");
        Assert.assertEquals(caption.getLinkText(), "View profile", "Caption link text is wrong");
        Assert.assertTrue(caption.getLinkReference().endsWith("/users/1"), "Link is wrong");
    }
}
