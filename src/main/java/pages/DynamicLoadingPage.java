package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage {

    private final WebDriver driver;
    private final By example1Link = By.linkText("Example 1: Element on page that is hidden");
    private final By example2Link = By.linkText("Example 2: Element rendered after the fact");
    private final By startButton = By.cssSelector("#start button");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public Example1Page clickExample1Link() {
        driver.findElement(example1Link).click();
        return new Example1Page(driver);
    }

    public Example2Page clickExample2Link() {
        driver.findElement(example2Link).click();
        return new Example2Page(driver);
    }


    public void ctrlClickExample2Link() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL).click(driver.findElement(example2Link)).perform();
    }

    public Boolean checkStartButtonPresence() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(startButton));
        return driver.findElement(startButton).isDisplayed();
    }


    public static class Example1Page {

        private final WebDriver driver;
        private final By startButton = By.cssSelector("#start button");
        private final By loadingIndicator = By.id("loading");
        private final By loadedText = By.id("finish");

        public Example1Page(WebDriver driver) {
            this.driver = driver;
        }

        // loadedText element is present but hidden, may be checked immediately
        public void clickStartButton() {
            driver.findElement(startButton).click();

            /*
            WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
            webDriverWait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
            */

            FluentWait wait = new FluentWait(driver)
                    .withTimeout(Duration.ofSeconds(5))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
        }

        public String getLoadedText() {
            return driver.findElement(loadedText).getText();
        }
    }


    public static class Example2Page {

        private final WebDriver driver;
        private final By startButton = By.cssSelector("#start button");
        private final By loadedText = By.id("finish");

        public Example2Page(WebDriver driver) {
            this.driver = driver;
        }

        // loadedText element is absent, may not be checked immediately because it needs time to appear
        public void clickStartButton() {
            driver.findElement(startButton).click();
            WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(loadedText));
        }

        public String getLoadedText() {
            return driver.findElement(loadedText).getText();
        }
    }

}
