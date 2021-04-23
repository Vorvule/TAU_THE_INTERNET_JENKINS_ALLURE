package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

import static org.testng.Assert.assertEquals;

public class KeysTests extends BaseTests {

    @Test
    public void testBackspace() {
        KeyPressesPage keyPage = homePage.clickKeyPresses();
        keyPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPage.getResult(), "You entered: BACK_SPACE");
    }

    @Test
    public void testPi() {
        KeyPressesPage keyPage = homePage.clickKeyPresses();
        keyPage.enterPi();
    }

    @Test
    public void testUndo() {
        KeyPressesPage keyPage = homePage.clickKeyPresses();
        keyPage.enterText("Hello!");
        keyPage.enterText(Keys.chord(Keys.CONTROL, "z"));
        assertEquals(keyPage.getResult(), "You entered: Z");
        assertEquals(keyPage.getInputValue(), "Hello");
    }

}
