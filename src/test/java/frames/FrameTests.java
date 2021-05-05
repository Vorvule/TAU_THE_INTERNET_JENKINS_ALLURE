package frames;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FramesPage;
import pages.WysiwygEditorPage;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwyg() {
        WysiwygEditorPage wysiwygEditorPage = homePage.clickWysiwygEditor();
        wysiwygEditorPage.clearEditArea();

        String text1 = "Hello ";
        String text2 = "world!";

        wysiwygEditorPage.setEditAreaText(text1);
        wysiwygEditorPage.increaseIndent();
        wysiwygEditorPage.setEditAreaText(text2);

        Assert.assertEquals(wysiwygEditorPage.getEditAreaText(), text1 + text2, "Text is wrong");
    }

    @Test
    public void testMiddleAndBottomFrames() {
        FramesPage framesPage = homePage.clickFrames();
        FramesPage.NestedFramesPage nestedFramesPage = framesPage.visitNestedFramesPage();
        Assert.assertEquals(nestedFramesPage.getMiddleText(), "MIDDLE", "Wrong middle text");
        Assert.assertEquals(nestedFramesPage.getBottomText(), "BOTTOM", "Wrong bottom text");
    }
}
