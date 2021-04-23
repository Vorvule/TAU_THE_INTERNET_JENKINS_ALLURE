package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EntryAdPage {

    private WebDriver driver;
    private By modalTitle = By.cssSelector(".modal-title h3");
    private By modalClose = By.cssSelector(".modal-footer p");
    private By header = By.cssSelector(".example h3");
    private By modal = By.id("modal");

    public EntryAdPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getModalTitle() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(modal))); // not header
        return driver.findElement(modalTitle).getText();
    }

    public void closeModal() {
        driver.findElement(modalClose).click();
    }

    public String getHeader() {
        return driver.findElement(header).getText();
    }

}
