package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by agembitsky on 14.12.2016.
 */
public class TestHello {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://selenium2.ru");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testHello() {
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
        driver = null;
    }
}
