package seleniumGrid;



import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class GridPractise
{
	WebDriver driver;
	//WebDriver driver1;
	WebDriver Driver;
	String BaseURL1;
	String BaseURL2;
	String NodeURL1;
	String NodeURL2;
	DesiredCapabilities Capability;
	DesiredCapabilities Capability1;
	@BeforeClass
	public void SetUp() throws MalformedURLException
	{
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","D:\\tet\\Selenium_Demp\\geckodriver.exe");
		
		//driver=new ChromeDriver();
		BaseURL1="https://www.flipkart.com/";
		BaseURL2="http://apps.qaplanet.in/qahrm/login.php";
		NodeURL1="http://192.168.0.120:5555/wd/hub";
		NodeURL2="http://192.168.0.120:5555/wd/hub";
		
		Capability=DesiredCapabilities.chrome();
		Capability.setBrowserName("chrome");
		Capability.setPlatform(Platform.WINDOWS);
		
		
		Capability1=DesiredCapabilities.firefox();
		Capability1.setBrowserName("firefox");
		Capability1.setPlatform(Platform.WINDOWS);
		

		driver=new RemoteWebDriver(new URL(NodeURL1),Capability);
		Driver=new RemoteWebDriver(new URL(NodeURL2),Capability1);
	}
	@AfterClass
	public void AfterTest()
	{
		//driver.quit();
		//Driver.quit();
	}
	@Test
	public void ApplicationAccess1() throws Exception
	{
		driver.get(BaseURL1);
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
		driver.close();
		Thread.sleep(2000);
		
	}
	@Test
	public void ApplicationAccess2() throws InterruptedException
	{
		Driver.get(BaseURL2);
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
		Driver.close();
		Thread.sleep(2000);
		
	}
	
}
