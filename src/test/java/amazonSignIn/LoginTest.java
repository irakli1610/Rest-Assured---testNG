package amazonSignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:/Users/irakl/Desktop/postman-Rest docs/webDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		driver.manage().window().maximize();
	}
	
	@Test
	public void loginCheck() throws InterruptedException {
		driver.findElement(By.id("ap_email")).sendKeys("+995595918642");;
		driver.findElement(By.cssSelector("input#continue")).click();
		
		driver.findElement(By.cssSelector("input#ap_password")).sendKeys("freezer6");
		driver.findElement(By.cssSelector("span#auth-signin-button")).click();
		
		
		Thread.sleep(10000);
		
		
		Assert.assertEquals(driver.getTitle(),"Amazon.com. Spend less. Smile more.");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
