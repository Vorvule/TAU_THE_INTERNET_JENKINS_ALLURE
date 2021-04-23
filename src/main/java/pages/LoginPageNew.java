package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageNew {

    private WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button[class='radius']");

    public LoginPageNew(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String userName) {
        driver.findElement(usernameField).sendKeys(userName);
    }

    public void setPassWord(String passWord) {
        driver.findElement(passwordField).sendKeys(passWord);
    }

    public SecureAreaPageNew clickLoginButton() {
        driver.findElement(loginButton).click();
        return new SecureAreaPageNew(driver);
    }
}
