package home;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTests extends BaseTests {

    @Test
    public void testTitle() {
        Assert.assertEquals(homePage.getTitle(), "The Internet", "Title is wrong");
    }

    @Test
    public void testAllLinksAmount() {
        Assert.assertEquals(homePage.getAllLinksAmount(), 46, "Wrong number of all links");
    }

    @Test
    public void testUlLinksAmount() {
        Assert.assertEquals(homePage.getUlLinksAmount(), 44, "Wrong number of all links");
    }
}
