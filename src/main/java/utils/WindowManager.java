package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowManager {

    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack() {
        navigate.back();
    }

    public void goForward() {
        navigate.forward();
    }

    public void reFresh() {
        navigate.refresh();
    }

    public void goTo(String url) {
        navigate.to(url);
    }


    // Multiple Windows Example
    public void switchToTab(String tabTitle) {
        Set<String> windows = driver.getWindowHandles();

        System.out.println("Number of tabs: " + windows.size());
        System.out.println("Window handles:");
        windows.forEach(System.out::println);

        for (String window : windows) {
            System.out.println("Switching to window " + window);
            driver.switchTo().window(window);

            System.out.println("Current window title is " + driver.getTitle());
            if (tabTitle.equals(driver.getTitle())) {
                break;
            }
        }
    }

    // ctrl click tests
    public void switchToLastTab() {
        Set<String> windows = driver.getWindowHandles();
        int windowsQuantity = windows.size();
        driver.switchTo().window((String) windows.toArray()[windowsQuantity - 1]);
    }

}
