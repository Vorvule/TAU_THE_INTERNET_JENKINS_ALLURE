package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPageNew {

    private WebDriver driver;
    private By messageField = By.id("flash");

    public SecureAreaPageNew(WebDriver driver) {
        this.driver = driver;
    }

    public String getMessage() {
        return driver.findElement(messageField).getText();
    }
}
