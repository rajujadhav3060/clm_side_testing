package clm_side_testing1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import clm_side_testing1.KnowledgeCentre;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTest {

	static WebDriver driver;
	static String str ;

	@BeforeClass
	public void setup() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.navigate().refresh();

	}

	@Test(dataProvider = "LoginData", dataProviderClass = Data_Provider_Excel.class)
	public void loginTest(String url, String title, String Condition, String  Search) throws Exception {

		str = Search;
		
		driver.get(url);

		driver.navigate().refresh();
		
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

		Thread.sleep(6000);

		String actual_title = driver.getTitle();

		Assert.assertEquals(actual_title, title);

		if (Condition == "true") 
			AdminDemo.admin();
		else
		{
			KnowledgeCentre.knowledge();
		}

	}

	@AfterClass
	void closeBrowser() {

		driver.close();

	}

}
