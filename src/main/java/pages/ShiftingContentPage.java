package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShiftingContentPage {

    private WebDriver driver;
    private By menu1 = By.linkText("Example 1: Menu Element");


    public ShiftingContentPage(WebDriver driver) {
        this.driver = driver;
    }

    public Example1Page clickExample1Link() {
        driver.findElement((menu1)).click();
        return new Example1Page(driver);
    }


}
