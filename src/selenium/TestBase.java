package selenium;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected int i,j,menuCount,submenuCount,productCount;
	
	@Before
	public void setUp() {
		
	    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    driver = new ChromeDriver(capabilities);		
		wait = new WebDriverWait(driver, 10/* seconds */);
		driver.get("http://localhost:7080/litecart");
		driver.manage().window().maximize();
	
	}

	@After
	public void tearDown() throws Exception {
		 driver.quit();
		 driver = null;
	}		 
	protected void loginLitecart() {
		driver.get("http://localhost:7080/litecart/admin");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		waitPage();
	}

	protected void waitPage() {
		wait.until(presenceOfElementLocated(By.cssSelector("#platform")));
	}

	protected List<WebElement> findMenu() {
		return driver.findElements(By.xpath("//li[contains(@id,'app-')]"));
	}
	
	protected List<WebElement> findSubMenu() {
		return driver.findElements(By.xpath(".//ul[@class='docs']/li"));
	}

	protected void titlePagePresent() {
    titleIs(driver.getTitle());
	}

	protected List<WebElement> findProduct() {
		return driver.findElements(By.xpath("//li[contains(@class,'product')]/a[@class='link']/div[1]"));
		
	}

}
