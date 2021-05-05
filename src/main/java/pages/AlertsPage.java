package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private final WebDriver driver;

    private final By alertButton   = By.xpath(".//button[text()='Click for JS Alert']");
    private final By confirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private final By promptButton  = By.xpath(".//button[text()='Click for JS Prompt']");
    private final By results = By.id("result");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void triggerAlert() {
        driver.findElement(alertButton).click();
    }
    public void triggerConfirm() {
        driver.findElement(confirmButton).click();
    }
    public void triggerPrompt() {
        driver.findElement(promptButton).click();
    }

    // for all the Alerts, Confirms and Prompts
    public void acceptPopup() {
        driver.switchTo().alert().accept();
    }
    public void dismissPopup() {
        driver.switchTo().alert().dismiss();
    }

    public String getResultText() {
        return driver.findElement(results).getText();
    }
    public String getConfirmText() {
        return driver.switchTo().alert().getText();
    }
    public void setPromptInput(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
}
