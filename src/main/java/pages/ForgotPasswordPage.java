package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private final WebDriver driver;
    private final By emailInputField = By.tagName("input");
    private final By retrievePasswordButton = By.tagName("i");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public RetrievePasswordPage retrievePassword() {
        String email = "email@email.ru";
        driver.findElement(emailInputField).sendKeys(email);
        driver.findElement(retrievePasswordButton).click();
        return new RetrievePasswordPage();
    }

    public class RetrievePasswordPage {
        private final By message = By.xpath("//h1[contains(text(),'Internal Server Error')]");

        public String getMessageText () {
            return driver.findElement(message).getText();
        }
    }
}