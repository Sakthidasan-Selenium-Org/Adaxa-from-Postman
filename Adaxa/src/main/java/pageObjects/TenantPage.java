package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import resources.base;

public class TenantPage {

WebDriver driver;
	
public static Logger log =LogManager.getLogger(base.class.getName());

	public TenantPage(WebDriver driver)
	{
		this.driver = driver;
	}

	By changePassword = By.xpath("//button[text() = 'Change Password']");
	By ok = By.xpath("//button[text() = 'OK']");
	By cancel = By.xpath("//button[text() = 'Cancel']");
	
	By date = By.xpath("//span[text()='Date']/parent::div //span[contains(@class,'editor-box-group-button')]");
	
	
	
	public WebElement getChangePassword()
	{
		return driver.findElement(changePassword);
		 
	}
	
	public void getDropdown(String dropdownLabel, String value)
	{
		driver.findElement(By.xpath("//span[text()='"+dropdownLabel+"']/parent::div //a[@class='z-combobox-button']")).click();
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'z-combobox-popup')]"))).build().perform();
		driver.findElement(By.xpath("//li[contains(@class,'z-comboitem')]/span[contains(text(),'"+value+"')]")).click();
		log.info("Selected Dropdwon value");
	}
	
	public String getDropdownValue(String dropdownLabel)
	{
		String dropDownValue = driver.findElement(By.xpath("//span[text()='"+dropdownLabel+"']/parent::div //input")).getAttribute("value");
		
		return dropDownValue;
		
	}
	
	public WebElement getOkButton()
	{
		return driver.findElement(ok);
	}

}
