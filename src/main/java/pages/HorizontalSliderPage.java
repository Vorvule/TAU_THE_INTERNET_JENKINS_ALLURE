package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {

    private final WebDriver driver;
    private final By slider = By.xpath(".//input[@type=\"range\"]");
    private final By range = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moveSliderRight(int times) {
        for (int i = 0; i < times + 1; i++) {
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getRange() {
        return driver.findElement(range).getText();
    }
}
