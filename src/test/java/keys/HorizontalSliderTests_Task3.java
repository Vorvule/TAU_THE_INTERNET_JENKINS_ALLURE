package keys;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

public class HorizontalSliderTests_Task3 extends BaseTests {

    @Test
    public void testSlider() {
        HorizontalSliderPage horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.moveSliderRight(7);
        Assert.assertEquals(horizontalSliderPage.getRange(), "4", "The range is wrong");
    }
}
