package generic;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;



public class BaseTest implements IAutoContsant {
	
	public static WebDriver driver;
	@BeforeMethod
	
	public void openApplication()
	{
	 driver= new FirefoxDriver();
	String url=Lib.getProperty(CONFIG_PATH, "URL");
	driver.get(url);
	String ITO =Lib.getProperty(CONFIG_PATH, "ImplicitTimoeOut");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
		
	}
	@AfterMethod
	public void closeApplication()
	{
		driver.close();
	}

public void takeScreenshot(String testname)
{
	
	Date d= new Date();
	String currentdate = d.toString().replaceAll(":", "_");
	TakesScreenshot ts=(TakesScreenshot) driver;
	File srcFile = ts.getScreenshotAs(OutputType.FILE);
	File destfile=new File(".\\Screenshot\\"+currentdate+"\\"+testname+"_screenshot.png");
	try{
	FileUtils.copyFile(srcFile, destfile);
	}catch(Exception e)
	{
		
	}
}
}