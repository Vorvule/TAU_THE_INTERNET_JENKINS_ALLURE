package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {

    private final WebDriver driver;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public NestedFramesPage visitNestedFramesPage() {
        driver.findElement(By.linkText("Nested Frames")).click();
        return new NestedFramesPage(driver);
    }


    public static class NestedFramesPage {

        private final WebDriver driver;

        private final By frameTop    = By.cssSelector("frame[name=\"frame-top\"]");
        private final By frameMiddle = By.cssSelector("frame[name=\"frame-middle\"]");
        private final By middleText  = By.id("content");
        private final By frameBottom = By.cssSelector("frame[name=\"frame-bottom\"]");
        private final By bottomText  = By.tagName("body");

        public NestedFramesPage(WebDriver driver) {
            this.driver = driver;
        }

        public String getMiddleText() {
            driver.switchTo().frame(driver.findElement(frameTop));
            driver.switchTo().frame(driver.findElement(frameMiddle));
            String text = driver.findElement(middleText).getText();
            driver.switchTo().parentFrame();
            driver.switchTo().parentFrame();
            return text;
        }

        public String getBottomText() {
            driver.switchTo().frame(driver.findElement(frameBottom));
            String text = driver.findElement(bottomText).getText();
            driver.switchTo().parentFrame();
            return text;
        }

    }

}
