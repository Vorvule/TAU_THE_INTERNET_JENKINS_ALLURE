package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Example1Page {

    private final WebDriver driver;
    private final By menuItems = By.tagName("li");

    public  Example1Page(WebDriver driver) {
        this.driver = driver;
    }

    public int getMenuListSize() {
        List<WebElement> menuItems = driver.findElements(By.tagName("li"));
        // System.out.println("Menus quantity is " + menuItems.size());
        return menuItems.size();
    }

}
