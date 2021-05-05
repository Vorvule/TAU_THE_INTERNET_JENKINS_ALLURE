package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.acceptPopup();
        Assert.assertEquals(alertsPage.getResultText(), "You successfully clicked an alert", "You unsuccessfully clicked an alert");
    }

    @Test
    public void testTextFromConfirm() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.getConfirmText();
        alertsPage.dismissPopup();
        Assert.assertEquals(text, "I am a JS Confirm", "Confirm text is wrong");
        Assert.assertEquals(alertsPage.getResultText(), "You clicked: Cancel", "Wrong confirm text");
    }

    @Test
    public void testSetPromptInput() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text = "Hey there!";
        alertsPage.setPromptInput(text);
        alertsPage.acceptPopup();
        Assert.assertEquals(alertsPage.getResultText(), "You entered: " + text, "Text is wrong");
    }
}
