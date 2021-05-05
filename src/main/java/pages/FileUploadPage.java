package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {

    private final WebDriver driver;

    private final By inputField    = By.id("file-upload");
    private final By uploadButton  = By.id("file-submit");
    private final By uploadedFiles = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) { this.driver = driver; }

    public void uploadFile(String absoluteFilePath) {
        driver.findElement(inputField).sendKeys(absoluteFilePath);
        clickUploadButton();
    }

    public void clickUploadButton() {
        driver.findElement(uploadButton).click();
    }

    public String getUploadFiles() {
        return driver.findElement(uploadedFiles).getText();
    }

}
