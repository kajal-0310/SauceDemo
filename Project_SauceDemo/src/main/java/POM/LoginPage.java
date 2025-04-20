package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
 
{
	WebDriver driver;
    LoginPage(WebDriver driver)
	{
	this.driver=driver;
	}
	By txt_username_loc=By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");
	By txt_password_loc=By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");
	By btn_login_loc=By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");

	
	public void setUsername(String user)
	{
		driver.findElement(txt_username_loc).sendKeys("user");
	}
	
	public void setPassword(String pwd)
	{
		driver.findElement(txt_password_loc).sendKeys("pwd");
	}
	public void clickLogin()
	{
		driver.findElement(btn_login_loc).click();
	}
	
}
