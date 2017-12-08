package vtiger_CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_3_EditLead 
{
	static WebDriver driver;
	WebDriverWait wait;
	WebElement E;
	@BeforeSuite
	public  void grr1() throws Exception {	
		System.out.println("Hi the test is about to start");
	}
	
	@AfterSuite
	public  void grr2() throws Exception {	
		System.out.println("Hi the test is Finished");

	}
	
	@BeforeTest
	public  void LaunchingTheBrowser() throws Exception 
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver.exe" );
		
		 driver=new ChromeDriver();
		//driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@AfterTest
	public  void ClosingTheBrowser() throws Exception 
	{
		driver.close();
		driver.quit();
	}

	@BeforeClass
	public void setUp() throws Exception 
	{
		driver.get("http://classroom:8888/");
		Thread.sleep(2000);
		driver.findElement(By.name("user_name")).sendKeys("qaplanet1");
		driver.findElement(By.name("user_password")).sendKeys("user1");
		driver.findElement(By.id("submitButton")).click();
		//------------------------------------------------------------------------------
		

	}

	@AfterClass
	public void SignOut() throws Exception
	{

		Actions Act=new Actions(driver);
		WebElement obj_user1=driver.findElement(By.xpath("html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img"));
		Act.moveToElement(obj_user1).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(5000);
		/*//verify home page
		 boolean Homepage=wait.until(ExpectedConditions.titleIs("vtiger CRM 5 - Commercial Open Source CRM"));
		 if (Homepage) 
		 {
			System.out.println("Home Page is Displayed");
		 }*/
	}

	@Test
	public void test() throws Exception
	{
		//find lead module and click on it
				driver.findElement(By.linkText("Leads")).click();Thread.sleep(2000);
				//to edit
			    WebElement obj_massEdit=driver.findElement(By.xpath("html/body/table[4]/tbody/tr/td[2]/div[4]/form/table/tbody/tr[1]/td/table[2]/tbody/tr/td/input[2]"));
			    obj_massEdit.click();
			    Thread.sleep(2000);
			    driver.switchTo().alert().accept();Thread.sleep(2000);
			WebElement obj_Search=driver.findElement(By.name("search_text"));
			obj_Search.clear();
			obj_Search.sendKeys("Teja");
			    E=driver.findElement(By.name("search_field"));	
			    Select sel=new Select(E);
			    sel.selectByVisibleText("Last Name");Thread.sleep(2000);
			    driver.findElement(By.name("submit")).click(); Thread.sleep(4000);
			    driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/div[4]/form/table/tbody/tr[1]/td/div/table/tbody/tr[3]/td[1]/input")).click(); Thread.sleep(4000); 
			    driver.findElement(By.xpath("html/body/table[4]/tbody/tr/td[2]/div[4]/form/table/tbody/tr[1]/td/table[2]/tbody/tr/td/input[2]")).click();  Thread.sleep(2000);
			    driver.findElement(By.xpath("html/body/div[17]/table/tbody/tr/td[3]/img")).click();Thread.sleep(2000);
			   int rc= driver.findElements(By.xpath("html/body/table[4]/tbody/tr/td[2]/div[4]/form/table/tbody/tr[1]/td/div/table/tbody/tr/td")).size();
			   System.out.println(rc);
			   Thread.sleep(4000);
			    for(int i=1;i<=rc;i++)
			    {
			    	System.out.println(rc);
			    	WebElement obj_webTable=driver.findElement(By.xpath("html/body/table[4]/tbody/tr/td[2]/div[4]/form/table/tbody/tr[1]/td/div/table/tbody/tr["+i+"]/td[3]"));
			    	
			    	obj_webTable.click();Thread.sleep(4000);
			    	if (obj_webTable.isDisplayed()) {
						
					System.out.println("editing in progress...");
					}
			    	break;
			    }

			    
			    //to delete
			 /*   
			    driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/div[4]/form/table/tbody/tr[1]/td/table[2]/tbody/tr/td/input[1]")).click();
			    Thread.sleep(2000);
			    driver.switchTo().alert().accept();
			    Thread.sleep(4000);*/
			    
		
		
	}

}
