package base;

import com.google.common.io.Files;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver; // private EventFiringWebDriver driver;
    protected HomePage homePage;
    private String link = "http://the-internet.herokuapp.com/";

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        goHome();
        homePage = new HomePage(driver);

                // driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
                // driver = new EventFiringWebDriver(new ChromeDriver());
                // driver.register(new EventReporter());

                // driver.manage().window().maximize();
                // driver.manage().window().setSize(new Dimension(360, 720));
                // Thread.sleep(2000);
                // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                // driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
                // driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
                // System.out.println("Page title is " + driver.getTitle());

                // driver.get(link);

                // setCooKie();

        /*
        WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
        inputsLink.click();
        driver.navigate().back();

        // homework task 1
        WebElement shiftingContentLink = driver.findElement(By.linkText("Shifting Content"));
        shiftingContentLink.click();

        WebElement example1Link = driver.findElement(By.linkText("Example 1: Menu Element"));
        example1Link.click();

        List<WebElement> menuItems = driver.findElements(By.tagName("li"));
        System.out.println("Menus quantity is " + menuItems.size());

        */
    }

    /*
    public static void main(String[] args) {
        BaseTests test = new BaseTests();
        test.setUp();
    }
    */


    @BeforeMethod
    public void goHome() {
        driver.get(link);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    // @AfterMethod
    public void takeScreenshot(ITestResult result) {
        TakesScreenshot camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        // com.google.common.io
        try {
            Files.move(screenshot, new File("src/test/resources/screenshots/" + result.getName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(result);
        }
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        // options.setHeadless(true);
        return options;
    }

    private void setCooKie() {
        Cookie cookie = new Cookie.Builder("alex" , "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
}
