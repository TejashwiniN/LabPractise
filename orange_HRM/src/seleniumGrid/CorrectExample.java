package seleniumGrid;


	
	import java.net.MalformedURLException;
	import java.net.URL;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Platform;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	public class CorrectExample
	{
	WebDriver Driver;
	WebDriver driver;
	WebDriver driver1;
	String BaseURL1;
	String BaseURL2;
	String BaseURL3;
	String NodeURL1;                                  
	String NodeURL2;
	DesiredCapabilities Capability;
	DesiredCapabilities Capabilitychrome;
	@BeforeClass
	public void SetUp() throws MalformedURLException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		driver1=new ChromeDriver();
		BaseURL1 = "http://www.espncricinfo.com/";
		BaseURL2 = "http://apps.qaplanet.in/qahrm/login.php";
		BaseURL3 = "http://apps.qaplanet.in/qahrm/login.php";
		NodeURL1 = "http://192.168.0.116:5555/wd/hub";
		NodeURL2 = "http://192.168.0.120:5555/wd/hub";
		
		Capability =  DesiredCapabilities.chrome();
		Capability.setBrowserName("chrome");
		Capability.setPlatform(Platform.WINDOWS);
		

		driver = new RemoteWebDriver(new URL(NodeURL1), Capability);
		Driver = new RemoteWebDriver(new URL(NodeURL2), Capability);

	}
	@AfterClass
	public void AfterTest() 
	{
		//Driver.quit();
		//driver.quit();
	}

	@Test
	public void ApplicationAccess1() throws Exception
	{
		driver1.get(BaseURL1);
		//Driver.manage().window().maximize();
		Thread.sleep(10000);
		if(driver1.getTitle().equals("Live cricket scores, commentary, match coverage | Cricket news, statistics | ESPN Cricinfo"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		driver1.close();
	}

	@Test
	public void ApplicationAccess2() throws Exception
	{
		driver.get(BaseURL2);
		Thread.sleep(10000);
		driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
		driver.findElement(By.name("txtPassword")).sendKeys("lab1");
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
	
	@Test
	public void ApplicationAccess3() throws Exception
	{
		Driver.get(BaseURL3);
		Thread.sleep(10000);
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
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

