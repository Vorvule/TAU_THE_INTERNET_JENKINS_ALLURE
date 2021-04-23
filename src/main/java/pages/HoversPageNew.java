package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPageNew {

    private WebDriver driver;

    private By picture = By.className("figure");
    private By caption = By.className("figcaption");

    public HoversPageNew(WebDriver driver) {
        this.driver = driver;
    }

    public PictureCaption hoverOverPicture(int index) {
        WebElement image = driver.findElements(picture).get(index);

        Actions action = new Actions(driver);
        action.moveToElement(image).perform();
        return new PictureCaption(image.findElement(caption));
    }

    public class PictureCaption {

        private WebElement caption;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");

        public PictureCaption(WebElement caption) {
            this.caption = caption;
        }

        public boolean captionIsDisplayed() {
            return caption.isDisplayed();
        }

        public String getHeaderText() {
            return caption.findElement(header).getText();
        }

        public String getLinkText() {
            return caption.findElement(link).getText();
        }

        public String getLinkHref() {
            return caption.findElement(link).getAttribute("href");
        }

    }

}
