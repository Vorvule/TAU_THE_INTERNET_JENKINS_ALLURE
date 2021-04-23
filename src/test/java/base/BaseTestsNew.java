package base;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePageNew;

public class BaseTestsNew {
    private ChromeDriver driver;
    private String link = "http://the-internet.herokuapp.com/";
    protected HomePageNew homePageNew;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        goHome();
        homePageNew = new HomePageNew(driver);
        // System.out.println("Page title is " + driver.getTitle());
    }

    @BeforeMethod
    public void goHome() {
        driver.get(link);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}







        /*
        WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
        String href = inputsLink.getAttribute("href");
        System.out.println(href);

        WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
        inputsLink.click();
        driver.navigate().back();

        // homework task 1
        WebElement shiftingContentLink = driver.findElement(By.linkText("Shifting Content"));
        shiftingContentLink.click();

        WebElement example1Link = driver.findElement(By.linkText("Example 1: Menu Element"));
        example1Link.click();

        List<WebElement> menuItems = driver.findElements(By.tagName("li"));
        System.out.println("Menu items quantity is " + menuItems.size());

        */
