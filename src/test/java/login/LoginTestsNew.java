package login;

import base.BaseTestsNew;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.SecureAreaPageNew;

public class LoginTestsNew extends BaseTestsNew {

    @Test
    public void testSuccessfulLogin() {

        LoginPageNew loginPageNew = homePageNew.clickFormAuthentication();

        loginPageNew.setUserName("tomsmith");
        loginPageNew.setPassWord("SuperSecretPassword!");
        SecureAreaPageNew secureAreaPageNew = loginPageNew.clickLoginButton();

        Assert.assertEquals
                (secureAreaPageNew.getMessage(), "You logged into a secure area!\n×", "Message is wrong");

    }
}
