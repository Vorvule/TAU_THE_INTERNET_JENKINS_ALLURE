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

    private WebDriver driver;
    private By example1Link = By.xpath(".//a[contains(text(), \"Example 1\")]");
    private By example2Link = By.xpath(".//a[contains(text(), \"Example 2\")]");

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


    // ctrl click test
    private By startButton = By.cssSelector("#start button");
    public void ctrllickExample2Link() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL).click(driver.findElement(example2Link)).perform();
    }
    public Boolean checkStartButtonPresence() {
        return driver.findElement(startButton).isDisplayed();
    }


    public class Example1Page {

        private WebDriver driver;
        private By startButton = By.cssSelector("#start button");
        private By loadingIndicator = By.id("loading");
        private By loadedText = By.id("finish");

        public Example1Page(WebDriver driver) {
            this.driver = driver;
        }

        public void clickStartButton() {
            driver.findElement(startButton).click();
            /*
            WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
            webDriverWait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
            */
            // fluent wait
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


    public class Example2Page {

        private WebDriver driver;
        private By startButton = By.cssSelector("#start button");
        private By loadingIndicator = By.id("loading");
        private By loadedText = By.id("finish");

        public Example2Page(WebDriver driver) {
            this.driver = driver;
        }

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
