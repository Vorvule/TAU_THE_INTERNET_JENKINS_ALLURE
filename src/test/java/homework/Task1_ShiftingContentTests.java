package homework;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Example1Page;
import pages.ShiftingContentPage;

public class Task1_ShiftingContentTests extends BaseTests {

    @Test
    public void testMenuListSize() {
        ShiftingContentPage shiftingContentPage = homePage.clickShiftingContent();
        Example1Page example1Page = shiftingContentPage.clickExample1Link();
        Assert.assertEquals(example1Page.getMenuListSize(), 5, "Wrong menu size");
    }

}
