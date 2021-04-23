package keys;

import base.BaseTestsNew;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KeyPressesPageNew;

public class KeyTestsNew extends BaseTestsNew {

    @Test
    public void testBackspace() {
        KeyPressesPageNew keyPressesPageNew = homePageNew.clickKeyPressesNew();
        keyPressesPageNew.enterText("Hello World!" + Keys.BACK_SPACE);
        Assert.assertEquals(keyPressesPageNew.getResult(), "You entered: BACK_SPACE", "Result is wrong");
    }

    @Test
    public void testShortcuts() {
        KeyPressesPageNew keyPressesPageNew = homePageNew.clickKeyPressesNew();
        keyPressesPageNew.enterText("Hello World!" + Keys.chord(Keys.CONTROL, "z"));
        Assert.assertEquals(keyPressesPageNew.getTargetValue(), "Hello World", "Wrong value");
    }

}
