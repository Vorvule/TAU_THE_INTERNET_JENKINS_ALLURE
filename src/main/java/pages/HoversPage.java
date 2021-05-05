package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {

    private final WebDriver driver;
    private final By figureBox  = By.className("figure");
    private final By boxCapiton = By. className("figcaption");

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    public FigureCaption hoverOverFigure(int index) {
        WebElement figure = driver.findElements(figureBox).get(index - 1);

        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();

        return new FigureCaption(figure.findElement(boxCapiton));
    }

    public static class FigureCaption {

        private final WebElement caption;
        private final By header = By.tagName("h5");
        private final By link = By.tagName("a");

        public  FigureCaption(WebElement caption) {
            this.caption = caption;
        }

        public boolean captionIsDisplayed() {
            return caption.isDisplayed();
        }

        public String getHeaderText() {
            return caption.findElement(header).getText();
        }

        public String getLinkReference() {
            return caption.findElement(link).getAttribute("href");
        }

        public String getLinkText() {
            return caption.findElement(link).getText();
        }
    }
}
