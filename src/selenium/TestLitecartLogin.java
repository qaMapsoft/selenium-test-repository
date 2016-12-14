package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;

import java.util.concurrent.TimeUnit;



/**
 * Created by agembitsky on 14.12.2016.
 */
public class TestLitecartLogin {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","c:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/litecart/admin");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testHello() {

        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        driver = null;
    }
}
