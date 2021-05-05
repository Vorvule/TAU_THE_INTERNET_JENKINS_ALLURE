package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {

    private final WebDriver driver;

    private final By editArea = By.id("tinymce");
    private final By increaseIndentButton = By.xpath(".//button[@title='Increase indent']");

    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clearEditArea() {
        switchToEditArea();
        driver.findElement(editArea).clear();
        switchToMainArea();
    }

    public void setEditAreaText(String text) {
        switchToEditArea();
        driver.findElement(editArea).sendKeys(text);
        switchToMainArea();
    }

    public String getEditAreaText() {
        switchToEditArea();
        String text = driver.findElement(editArea).getText();
        switchToMainArea();
        return text;
    }

    public void increaseIndent() {
        driver.findElement(increaseIndentButton).click();
    }

    private void switchToEditArea() {
        String editorIframeId = "mce_0_ifr";
        driver.switchTo().frame(editorIframeId);
    }

    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }
}
