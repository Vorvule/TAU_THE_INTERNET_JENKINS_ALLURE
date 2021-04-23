package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KeyPressesPageNew {

    private WebDriver driver;
    private By target = By.id("target");
    private By result = By.id("result");

    public KeyPressesPageNew(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(String text) {
        driver.findElement(target).sendKeys(text);
    }

    public String getResult() {
        return driver.findElement(result).getText();
    }

    public String getTargetValue() {
        return driver.findElement(target).getAttribute("value");
    }

}
