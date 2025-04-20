package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest 
{
WebDriver driver;
@BeforeClass
void setup()
{
	driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
}
@Test

void testLogin()
{
	
	LoginPage lp= new LoginPage(driver);
	lp.setUsername("Admin");
	lp.setPassword("admin123");
	lp.clickLogin();
	Assert.assertEquals(driver.getTitle(), "OrangeHRM");
}
@AfterClass
void tearDown()
{
	driver.quit();
}
}
