package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage {

    private WebDriver driver;
    private By table = By.id("large-table");

    public LargeAndDeepDomPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToTable() {
        WebElement tableElement = driver.findElement(table);
        // tableElement. => no method available
        String script = "arguments[0].scrollIntoView()";
        // arguments[0] is a tableElement's placeholder cause we can't use it
        ((JavascriptExecutor) driver).executeScript(script, tableElement);
        // tableElement replaces placeholder arguments[0]
    }
}
