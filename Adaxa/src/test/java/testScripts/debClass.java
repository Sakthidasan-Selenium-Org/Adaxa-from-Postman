package testScripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.selector.BasicContextSelector;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import resources.base;

public class debClass extends base {
	public WebDriver driver;
	
	public static Logger log =LogManager.getLogger(debClass.class.getName());

	@Test
	public void openGoogle() throws IOException
	{
		System.out.println("Debug output:"+base.class.getName());
		
		driver = initialiseDriver();
		log.info("Logged into Google");
		driver.get("http://www.google.com");
		log.info("Navigation Bar is displayed");
		log.debug("Debug message");
		log.warn("This is warning");
	}
}
