package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage {

    private final WebDriver driver;
    private final By largeTable = By.id("large-table");

    public LargeAndDeepDomPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToTable() {
        WebElement tableElement = driver.findElement(largeTable);
        // arguments[0] is a placeholder for the tableElement we can't use
        String script = "arguments[0].scrollIntoView()";
        // tableElement replaces placeholder arguments[0]
        ((JavascriptExecutor) driver).executeScript(script, tableElement);
    }
}
