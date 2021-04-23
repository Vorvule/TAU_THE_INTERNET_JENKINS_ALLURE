package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {

    private WebDriver driver;
    private By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    // 1-based index
    public void scrollToParagraph(int Index) {
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
        while (getNumberOfParagraphsPresent() < Index) {
            javascriptExecutor.executeScript(script);
        }
    }

    private int getNumberOfParagraphsPresent() {
        return driver.findElements(textBlocks).size();
    }
}
