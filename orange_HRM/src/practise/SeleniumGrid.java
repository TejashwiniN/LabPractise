package practise;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class SeleniumGrid
{
WebDriver Driver;
WebDriver driver;
String BaseURL1;
String BaseURL2;
String NodeURL1;
String NodeURL2;
DesiredCapabilities Capability;
DesiredCapabilities Capabilitychrome;
@BeforeClass
public void SetUp() throws MalformedURLException 
{
	BaseURL1 = "http://www.espncricinfo.com/";
	BaseURL2 = "http://classroom:90/qahrm";
	NodeURL1 = "http://192.168.0.105:5555/wd/hub";
	NodeURL2 = "http://192.168.0.105:5555/wd/hub";
	
	Capability =  DesiredCapabilities.firefox();
	Capability.setBrowserName("firefox");
	Capability.setPlatform(Platform.WINDOWS);
	

	Driver = new RemoteWebDriver(new URL(NodeURL1), Capability);
	driver = new RemoteWebDriver(new URL(NodeURL2), Capability);

}
@AfterClass
public void AfterTest() 
{
	Driver.quit();
	driver.quit();
}

@Test
public void ApplicationAccess1() throws Exception
{
	Driver.get(BaseURL1);
	Driver.manage().window().maximize();
	Thread.sleep(10000);
	if(Driver.getTitle().equals("Live cricket scores, commentary, match coverage | Cricket news, statistics | ESPN Cricinfo"))
	{
		System.out.println("Pass");
	}
	else
	{
		System.out.println("Fail");
	}
	Driver.close();
}

@Test
public void ApplicationAccess2() throws MalformedURLException, InterruptedException {
	driver.get(BaseURL2);
	Thread.sleep(10000);
	driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
	driver.findElement(By.name("txtPassword")).sendKeys("user1");
	driver.findElement(By.name("Submit")).click();
	Thread.sleep(2000);
	if (driver.getTitle().equals("OrangeHRM"))
	{
		System.out.println("Pass");
	}
	else
	{
		System.out.println("Fail");
	}
	driver.findElement(By.linkText("Logout")).click();
	Thread.sleep(2000);
	driver.close();
}
}