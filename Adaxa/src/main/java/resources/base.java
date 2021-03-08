package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {

	
	public WebDriver driver;
	public Properties prop;
	
	public Properties getdata() throws IOException
	{
	 prop = new Properties();
	FileInputStream fis = new FileInputStream("E:\\Yoga\\Selenium Project\\Adaxa\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	return prop;
	
	}
	public WebDriver initialiseDriver() throws IOException
	{
		
		this.prop = getdata();		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Yoga\\chromedriver.exe");
			ChromeOptions options =new ChromeOptions();
			 if(browserName.contains("headless"))
			 {
			  options.addArguments("headless");
			 }
		driver= new ChromeDriver(options);
			
			driver.manage().window().maximize();
			
		}
		else if(browserName.equals("Internet Explorer"))
		{
			//Add IE driver here
			
		}
		else if(browserName.equals("FireFox"))
		{
			//Add Gecko driver here
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		System.out.println(System.getProperty("user.dir"));
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}
}
