package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testForgotPasswordMessage() {
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPasswordPageLink();
        Assert.assertEquals(forgotPasswordPage.retrievePassword().getMessageText(), "Internal Server Error",
                "Wrong error message");
    }
}
