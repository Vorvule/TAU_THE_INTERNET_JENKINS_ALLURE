package frames;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WysiwygEditorPage;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwyg() {
        WysiwygEditorPage wysiwygEditorPage = homePage.clickWysiwygEditor();
        wysiwygEditorPage.clearTextArea();

        String text1 = "Hello ";
        String text2 = "world!";

        wysiwygEditorPage.setTextArea(text1);
        wysiwygEditorPage.decreaseIndentation();
        wysiwygEditorPage.setTextArea(text2);

        Assert.assertEquals(wysiwygEditorPage.getTextFromEditor(), text1 + text2, "Text is wrong");
    }
}
