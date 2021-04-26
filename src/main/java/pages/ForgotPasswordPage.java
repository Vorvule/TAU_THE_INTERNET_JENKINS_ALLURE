package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;
    private By emailInputField = By.tagName("input");
    private By retrievePasswordButton = By.tagName("i");
    private String email = "email@email.ru";

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public RetrievePasswordPage retrievePassword() {
        driver.findElement(emailInputField).sendKeys(email);
        driver.findElement(retrievePasswordButton).click();
        return new RetrievePasswordPage();
    }

    public class RetrievePasswordPage {
        private By message = By.xpath("//h1[contains(text(),'Internal Server Error')]");

        public String getMessageText () {
            return driver.findElement(message).getText();
        }
    }
}