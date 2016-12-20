package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by agembitsky on 14.12.2016.
 */
public class TestLitecartLogin {

	private WebDriver driver;
	private WebElement menu;
	private List<WebElement> id, submenu;
	private WebDriverWait wait;
	private int i, j, idS, submenuS;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 20/* seconds */);

	}

	@Test
	public void testHello() {
		driver.get("http://localhost:7080/litecart/admin");
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();

		wait.until(presenceOfElementLocated(By.cssSelector("#platform")));
		/* ищем меню */
		menu = driver.findElement((By.xpath("//ul[contains(@id,'box-apps-menu')]/li")));
		/* ищем пункты меню */
		id = menu.findElements(By.xpath("//span[contains(@class,'name')]"));
		idS = id.size();
		if (idS != 0) {
			i = 0;
			while (i < idS) { /* нажимаем пункт */
				driver.findElements(By.xpath("//span[contains(@class,'name')]")).get(i).click();
				/* ждем открытия страницы */
				wait.until(presenceOfElementLocated(By.cssSelector("#platform")));
				/* ищем подменю */
				submenu = driver.findElements(By.xpath("//ul[contains(@class,'docs')]/li"));
				submenuS = submenu.size();
				if (submenuS != 0) {
					j = 0;
					while (j < submenuS) {
						/* нажимаем подпункт */
						driver.findElements(By.xpath("//ul[contains(@class,'docs')]/li")).get(j).click();
						/* ждем открытия страницы */
						wait.until(presenceOfElementLocated(By.cssSelector("#platform")));
						j++;
					}

				}
				i++;
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
		// driver = null;
	}
}
