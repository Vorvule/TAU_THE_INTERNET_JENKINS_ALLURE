package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageNew {

    private final WebDriver driver;

    public HomePageNew(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement clickLink(String linkText) {
        return driver.findElement(By.linkText(linkText));
    }

    public LoginPageNew clickFormAuthentication() {
        clickLink("Form Authentication").click();
        return new LoginPageNew(driver);
    }
    /*
    public DropdownPage clickDropdown() {
        clickLink("Dropdown").click();
        return new DropdownPage(driver);
    }
    */
    public HoversPageNew clickHoversNew() {
        clickLink("Hovers").click();
        return new HoversPageNew(driver);
    }

    public KeyPressesPageNew clickKeyPressesNew() {
        clickLink("Key Presses").click();
        return new KeyPressesPageNew(driver);
    }

    public AlertsPageNew clickJavaScriptAlerts() {
        clickLink("JavaScript Alerts").click();
        return new AlertsPageNew(driver);
    }

    public EntryAdPageNew clickEntryAd() {
        clickLink("Entry Ad").click();
        return new EntryAdPageNew(driver);
    }
}
