package selenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestLitecartComents extends TestBase {

	/**
	 * Created by agembitsky on 14.12.2016.
	 */
	WebElement product;

	@Test
	public void testComents() {

		productCount = findProduct().size();
		i = 0;
		while (i < productCount) {
			product = findProduct().get(i);
			Assert.assertEquals(product.findElements(By.xpath(".//div[contains(@class,'sticker')]")).size(), 1);
			i++;
		}
	}
}