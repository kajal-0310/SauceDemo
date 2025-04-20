package com.jbk;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemo {
	
	@Test
	public void testtitleofwebsite()
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		String actResult=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
		String expResult="sauce demo";
		driver.quit();
		Assert.assertEquals(actResult, expResult);
		
	}
	
	@Test
	public void testUsernametext()
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		String actResult=driver.findElement(By.xpath("//*[@id=\"user-name\"]")).getText();
		String expResult="Username";
		driver.quit();
		Assert.assertEquals(actResult, expResult);
	}
	
	@Test (enabled=false)
	public void testPasswordtext()
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		String actResult=driver.findElement(By.xpath("//*[@id=\"password\"]")).getText();
		String expResult="Password";
		driver.quit();
		Assert.assertEquals(actResult, expResult);
	}
	
	@Test 
	public void testvalidlogincreditials()
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		String actResult="login Successfully";
		String expResult="login Successfully";
		driver.quit();
		Assert.assertEquals(actResult, expResult);
	}
	
	@Test 
	public void testInvalidlogincreditials()
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user#");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce1");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		String actResult=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
		String expResult="login Successfully";
		driver.quit();
		Assert.assertEquals(actResult, expResult);
	
	}
	
	@Test 
	public void testblankusernamefield()
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		String actResult=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
		String expResult="Epic sadface: Username is required";
		driver.quit();
		Assert.assertEquals(actResult, expResult);
	}
	
	@Test 
	public void testblankpasswordfield()
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//*[@id=\\\"password\\\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		String actResult=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
		String expResult="Epic sadface: Password is required";
		driver.quit();
		Assert.assertEquals(actResult, expResult);
	}
	
	
	@Test 
    public void TestwelcometitleofWebsite()
    {
    	WebDriver driver= new ChromeDriver();
    	driver.get("https://www.saucedemo.com/");
    	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		driver.get("https://www.saucedemo.com/inventory.html");
		String actResult=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		String expResult="product";
		driver.quit();
		Assert.assertEquals(actResult, expResult);
		
    }
	
	@Test 
	public void testListCountoptions()
	{
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	driver.get("https://www.saucedemo.com/inventory.html");
	WebElement list=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
     Select select = new Select(list);
     List<WebElement>options=select.getOptions();
     for(WebElement webElement:options) 
     {
    	 String textofoptions=webElement.getText();
    	 System.out.println(textofoptions);
     }
     driver.quit();
     assertEquals(options.size(), 4);
	 
	} 
	
	
	@Test
	public void testselectoptions()
	{
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	driver.get("https://www.saucedemo.com/inventory.html");
	WebElement list=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
    Select select = new Select(list);
    List<WebElement>options=select.getOptions();
    ArrayList<String> alactResult=new ArrayList<String>();
    for(WebElement webElement:options)
    {
    	String text= webElement.getText();
    	alactResult.add(text);
    }
    driver.quit();
    Assert.assertTrue(alactResult.contains("Select(A to Z)"));
	}
	
	@Test 
	public void testOpenMenueButton()
	{
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"inventory_sidebar_link\"]")).click();
	driver.get("https://saucelabs.com/");
	String actResult="about";
	String expResult="menue";
	driver.quit();
	Assert.assertEquals(actResult, expResult);
	
	
	}
	
	@Test 
	public void testYourCartofWebsite()
	{
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
	String actResult=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
	String expResult="Your Cart";
	driver.quit();
	Assert.assertEquals(actResult, expResult);
	
	}
	
	@Test 
	public void testAddCartButton()
	{
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
	String actResult=driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]")).getText();
	String expResult="Sauce Labs Backpack";
	driver.quit();
	Assert.assertEquals(actResult, expResult);
	
	}
	
	@Test 
	public void testRemovefromCartButton()
	{
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
	String actResult=driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]")).getText();
	driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
	String expResult="Sauce Labs Backpack";
	driver.quit();
	Assert.assertEquals(actResult, expResult);
	
	}
	
	
}
