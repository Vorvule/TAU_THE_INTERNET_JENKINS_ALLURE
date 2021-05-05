package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EntryAdPage {

    private final WebDriver driver;

    private final By modalTitle = By.cssSelector(".modal-title h3");
    private final By modalClose = By.cssSelector(".modal-footer p");
    private final By modalHeader = By.cssSelector(".example h3");
    private final By modalWindow = By.id("modal");

    public EntryAdPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getModalTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        // wait for the modal window appearance
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(modalWindow)));
        return driver.findElement(modalTitle).getText();
    }

    public void closeModal() {
        driver.findElement(modalClose).click();
    }

    public String getModalHeader() {
        return driver.findElement(modalHeader).getText();
    }

}
