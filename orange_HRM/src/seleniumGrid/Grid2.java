package seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Grid2
{
	WebDriver driver;
	WebDriver Driver;
	String baseURL;
	String baseURL1;
	String nodeURL;
	String nodeURL1;
	DesiredCapabilities capability;
	DesiredCapabilities capability1;
	@BeforeClass
	public void setUp() throws MalformedURLException
	{
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		
		baseURL="https://www.flipkart.com/";
		 baseURL1="http://apps.qaplanet.in/qahrm/login.php";
		 nodeURL="http://192.168.0.114:5555/wd/hub";
		 nodeURL1="http://192.168.0.114:5555/wd/hub";
		 
		 capability=DesiredCapabilities.chrome();
		 capability.setBrowserName("chrome");
		 capability.setPlatform(Platform.WINDOWS);
		
		driver=new RemoteWebDriver(new URL(nodeURL),capability);
		Driver=new RemoteWebDriver(new URL(nodeURL1),capability);
		
	}
	@AfterClass
	public void close()
	{
		driver.close();
		Driver.close();
	}
	@Test
	public void applicationAccess1() throws InterruptedException
	{
		driver.get(baseURL);
	
		Thread.sleep(10000);
		WebElement title=driver.findElement(By.xpath("/html/body/div[1]/div/header/div[1]/div[2]/div/div/div[1]/a/img"));
		if (title.isDisplayed())
		{
		System.out.println("pass");	
		}
		else
		{
			System.out.println("Fail");
		}
		
	}
	@Test
	public void applicationAccess2() throws InterruptedException
	{
		Driver.get(baseURL1);
		Thread.sleep(1000);
		Driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
		Driver.findElement(By.name("txtPassword")).sendKeys("lab1");
		Driver.findElement(By.name("Submit")).click();
		
		Thread.sleep(2000);
		if (Driver.getTitle().equals("OrangeHRM"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		Driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
	}
}
