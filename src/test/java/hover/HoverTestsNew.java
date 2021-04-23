package hover;

import base.BaseTests;
import base.BaseTestsNew;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;
import pages.HoversPageNew;

public class HoverTestsNew extends BaseTestsNew {

    @Test
    public void testHoverUser1() {

        HoversPageNew hoversPageNew = homePageNew.clickHoversNew();
        HoversPageNew.PictureCaption caption = hoversPageNew.hoverOverPicture(0);
        Assert.assertTrue(caption.captionIsDisplayed());
        Assert.assertEquals(caption.getHeaderText(), "name: user1", "Wrong user title");
        Assert.assertEquals(caption.getLinkText(), "View profile", "Wrong link text");
        Assert.assertEquals(caption.getLinkHref(), "/users/1", "Wrong link href attribute");
    }

}
