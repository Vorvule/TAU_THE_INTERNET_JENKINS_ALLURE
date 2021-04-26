package alerts;

import base.BaseTestsNew;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPageNew;

public class AlertTestsNew extends BaseTestsNew {

    @Test
    public void testAlert() {
        AlertsPageNew alertsPageNew = homePageNew.clickJavaScriptAlerts();
        alertsPageNew.clickAlertButton();
        alertsPageNew.acceptPopup();
        Assert.assertEquals(alertsPageNew.getResultText(), "You successfully clicked an alert", "Wrong result text");
    }

    @Test
    public void testConfirm() {
        AlertsPageNew alertsPageNew = homePageNew.clickJavaScriptAlerts();
        alertsPageNew.clickConfirmButton();
        String confirmText = alertsPageNew.getConfirmText();
        alertsPageNew.dismissPopup();
        Assert.assertEquals(confirmText, "I am a JS Confirm", "Wrong confirm text");
        Assert.assertEquals(alertsPageNew.getResultText(), "You clicked: Cancel", "Wrong confirm text");
    }

    @Test
    public void testPrompt() {
        AlertsPageNew alertsPageNew = homePageNew.clickJavaScriptAlerts();
        alertsPageNew.clickPromptButton();
        String text = "Hey there!";
        alertsPageNew.setPromptInput(text);
        alertsPageNew.acceptPopup();
        Assert.assertEquals(alertsPageNew.getResultText(), "You entered: " + text, "Wrong prompt text");
    }
}
