package clm_side_testing1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class KnowledgeCentre extends DataDrivenTest {

	public static void knowledge() throws Exception {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(//span[contains(text(),'Configuration Center')])[1]")).click();

		if (str.equals("IN")) {

			WebElement search = driver
					.findElement(By.xpath("//input[@id='ctl00_PlaceHolderSearchArea_SmallSearchInputBox1_csr_sbox']"));

			search.clear();

			search.sendKeys("matrix");

			search.sendKeys(Keys.ENTER);

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			boolean actual = driver.findElement(By.xpath("//div[text()='Result type']")).isDisplayed();

			boolean expect = true;

			Assert.assertEquals(actual, expect);

			driver.navigate().back();
		}
		
		driver.findElement(By.xpath("//span[text()='User Wizard']")).click();

	}

}
