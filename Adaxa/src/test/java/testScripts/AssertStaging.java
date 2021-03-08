package testScripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.TenantPage;
import pageObjects.loginPage;
import resources.base;

public class AssertStaging extends base {
	
	public static Logger log =LogManager.getLogger(AssertStaging.class.getName());
	loginPage lp;
	public WebDriver driver;
	
	@Test
	public void createStaging() throws IOException, InterruptedException
	{
		driver = initialiseDriver();
		lp = new loginPage(driver);
		lp.login();
		
		TenantPage tp = new TenantPage(driver);
		Thread.sleep(600);
		
		Assert.assertTrue(tp.getChangePassword().isDisplayed(), "Landed in Tenant Page Successfully...!");
		log.info("Landed on Tenant Page Successfully");
		
		this.prop = getdata();
		tp.getDropdown(prop.getProperty("dropDown"), prop.getProperty("dropDownValue"));
		String actualDropDwonValue = tp.getDropdownValue(prop.getProperty("dropDownToVerify"));
		
		Assert.assertEquals(actualDropDwonValue, prop.getProperty("dropDownValueToVerify"));
		tp.getOkButton().click();
		
		Thread.sleep(400);
		
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='SuperUser@BCMM AM.AM/AM ICT User']")).isDisplayed());
		
		log.info("Loggged in as Tenant Successfully. Test Case Passed..!");
		
	}
	
	@AfterTest
	public void tearDownDriver()
	{
		driver.quit();
	}
}
