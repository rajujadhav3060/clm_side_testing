package clm_side_testing1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import clm_side_testing1.DataDrivenTest;

public class AdminDemo extends DataDrivenTest {

	public static void admin() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement drpdwn = driver.findElement(By.xpath("(//span[text()='Contract Ops'])[1]"));

		drpdwn.click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[text()='Admin']")).click();

		Thread.sleep(3000);

		if (str.equals("IN")) {

			WebElement search = driver.findElement(By.xpath("//input[@id='ctl00_SmallSearchInputBox1_csr_sbox']"));

			search.clear();

			Thread.sleep(1000);

			search.sendKeys("Matrix");

			search.sendKeys(Keys.ENTER);

			Thread.sleep(4000);

			boolean t = driver.findElement(By.xpath("//div[text()='Result type']")).isDisplayed();

			boolean n = true;

			Assert.assertEquals(t, n);

			driver.navigate().back();

		}
		
		driver.findElement(By.xpath("(//span[text()='Users'])[1]")).click();

		driver.findElement(By.xpath("//button[text()='Add User']")).click();

	}
}
