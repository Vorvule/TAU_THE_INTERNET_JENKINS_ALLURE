package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private WebDriver driver;

    private By triggerAlertButton = By.xpath(".//button[text()=\"Click for JS Alert\"]");
    private By results = By.id("result");

    private By triggerConfirmButton = By.xpath(".//button[text()=\"Click for JS Confirm\"]");
    private By triggerPromptButton = By.xpath(".//button[text()=\"Click for JS Prompt\"]");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void triggerAlert() {
        driver.findElement(triggerAlertButton).click();
    }
    public void triggerConfirm() {
        driver.findElement(triggerConfirmButton).click();
    }
    public void triggerPrompt() {
        driver.findElement(triggerPromptButton).click();
    }

    // for Alerts and Confirms
    public void acceptPopup() {
        driver.switchTo().alert().accept();
    }
    public void dismissPopup() {
        driver.switchTo().alert().dismiss();
    }

    public String getResult() {
        return driver.findElement(results).getText();
    }
    public String getConfirmText() {
        return driver.switchTo().alert().getText();
    }
    public void setPromptInput(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
}
