package testNGWebElements;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTest {

	WebDriver driver;
	
	@BeforeClass
	public void setup() 
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/irakl/Desktop/postman-Rest docs/webDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}
	
	@Test (priority=1)
	public void logoTest() {
		WebElement logo = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img"));
		Assert.assertTrue(logo.isDisplayed(),"logo is not displayed");
	}
	
	@Test (priority=2)
	public void titleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google");
	}
	
	@Test (priority=3) 
	public void loginTest() throws InterruptedException {
		 driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
		 .sendKeys("youtube");
		 driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).click();

			Assert.assertEquals(driver.getTitle(), "youtube - Google ძებნა");

	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}


	
}
