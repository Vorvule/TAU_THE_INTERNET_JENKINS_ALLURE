package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AlertsPage;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.acceptPopup();
        assertEquals(alertsPage.getResult(), "You successfully clicked an alert", "You unsuccessfully clicked an alert");
    }

    @Test
    public void testTextFromConfirm() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.getConfirmText();
        alertsPage.dismissPopup();
        assertEquals(text, "I am a JS Confirm", "Confirm text is wrong");
    }

    @Test
    public void testSetPromptInput() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text = "Hey there!";
        alertsPage.setPromptInput(text);
        alertsPage.acceptPopup();
        assertEquals(alertsPage.getResult(), "You entered: " + text, "Text is wrong");
    }
}
