package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {

    private final WebDriver driver;
    private final By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    // 1-based index
    public void scrollToTextBlock(int Index) {
        // scrollHeight changes with scroll down
        String script = "window.scrollTo(0, document.body.scrollHeight)";

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        while (getTextBlocksCount() < Index) {
            javascriptExecutor.executeScript(script);
        }
    }

    private int getTextBlocksCount() {
        return driver.findElements(textBlocks).size();
    }
}
