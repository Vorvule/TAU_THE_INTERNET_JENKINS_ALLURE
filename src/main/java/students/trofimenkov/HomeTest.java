package students.trofimenkov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomeTest  {
    private WebDriver driver;
    private String link = "https://the-internet.herokuapp.com/";
    // private String link = "https://www.bing.com/";

    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(link);
        driver.manage().window().maximize();
        List<WebElement> aLinks = driver.findElements(By.xpath("//ul//a"));
        System.out.println("A-links quantity is " + aLinks.size());
    }

    public void tearDown() {
        driver.quit();
    }

    public static void main(String[] args) {
        HomeTest test = new HomeTest();
        try {
            test.setUp();
            test.tearDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
