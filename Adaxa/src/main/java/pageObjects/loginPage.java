package pageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class loginPage extends base{
	WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	public loginPage(WebDriver driver)
	{
		this.driver = driver;
	}

	By userName = By.xpath("//input[@placeholder = 'UserName']");
	By password = By.xpath("//input[@placeholder = 'Password']");
	By selectRole = By.xpath("//label[text() = 'Select Role']/preceding-sibling::input");
	By rememberMe = By.xpath("//label[text() = 'Remember Me']/preceding-sibling::input");
	By signIn = By.xpath("//button[contains(@text(), Sign)]");
	
	public WebElement getUserName()
	{
		return driver.findElement(userName);
		 
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
		 
	}
	
	
	
	
	public WebElement getRole()
	{
		return driver.findElement(selectRole);
		 
	}
	
	public WebElement getSignIn()
	{
		return driver.findElement(signIn);
		 
	}

	public void login() throws IOException
	{
		
		System.out.println("Entered into Login Method");
		this.prop = getdata();
		System.out.println(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		log.info("Successfully hit URL: "+prop.getProperty("url"));
		
		getUserName().sendKeys(prop.getProperty("userName"));
		getPassword().sendKeys(prop.getProperty("password"));
		
		getRole().click();
		getSignIn().click();
	}

}
