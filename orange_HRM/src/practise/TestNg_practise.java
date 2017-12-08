package practise;



import org.testng.Assert;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;




public class TestNg_practise 
{
	WebDriver driver;
	WebDriverWait wait;

	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver.exe" );
		driver=new ChromeDriver();
		wait= new WebDriverWait(driver,60);
		driver.manage().window().maximize();
	}
	
	public void ShutDown()
	{
		driver.close();
		driver.quit();
	}
	
	public void HomePage()
	{
		
		driver.get("http://classroom:8888/");
		//verify home page
		 boolean Homepage=wait.until(ExpectedConditions.titleIs("vtiger CRM 5 - Commercial Open Source CRM"));
		 if (Homepage) 
		 {
			System.out.println("Home Page is Displayed");
		}
		 //verify username
		WebElement obj_UN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("user_name")));
		
		Assert.assertTrue(obj_UN.isDisplayed());
		Reporter.log("username is displayed");
		
	
		//verify password
		WebElement obj_PW=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("user_password")));
		if (obj_PW.isDisplayed()) 
		{
			System.out.println("password  is displayed");
		}
		//enter UN,PW and login
		String UN="qaplanet1";
		String PWD="user1";
		obj_UN.sendKeys(UN);
		obj_PW.sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
	}
	
	public void Verify_Elements()
	{
		boolean obj_Title=wait.until(ExpectedConditions.titleIs("user1 - Home - vtiger CRM 5 - Commercial Open Source CRM"));
		
		if (driver.getTitle().equals("user1 - Home - vtiger CRM 5 - Commercial Open Source CRM"))
		{
			System.out.println("Home page displayed");
		}
		WebElement obj_Home=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText( "Home")));
		WebElement obj_Calendar=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText( "Calendar")));
		WebElement obj_Leads=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText( "Leads")));
		WebElement obj_Org=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText( "Organizations")));
		WebElement obj_Opportunities=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText( "Opportunities")));
		WebElement obj_Products=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText( "Products")));
		WebElement obj_Documents=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText( "Documents")));
		WebElement obj_Email=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText( "Email")));
		if (obj_Home.isDisplayed() && obj_Calendar.isDisplayed() && obj_Leads.isDisplayed() &&  obj_Org.isDisplayed() && obj_Opportunities.isDisplayed() &&obj_Products.isDisplayed() &&obj_Email.isDisplayed()) 
		{
			System.out.println("all fields are displayed");
		}
	}
	
	public void logout()throws Exception
	{
		Actions Act=new Actions(driver);
		WebElement obj_user1=driver.findElement(By.xpath("html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img"));
		Act.moveToElement(obj_user1).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(5000);
		//verify home page
		 boolean Homepage=wait.until(ExpectedConditions.titleIs("vtiger CRM 5 - Commercial Open Source CRM"));
		 if (Homepage) 
		 {
			System.out.println("Home Page is Displayed");
		}
		
	}

	public void Lead()throws Exception
	{
		driver.findElement(By.linkText("Leads")).click();Thread.sleep(2000);
		WebElement obj_lead=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Leads")));
		if (obj_lead.isDisplayed()) 
		{
			System.out.println("leads page is displayed");
		}
		driver.findElement(By.xpath("html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
		boolean obj_LeadPage=wait.until(ExpectedConditions.titleIs("user1 - Leads - vtiger CRM 5 - Commercial Open Source CRM"));
		if (obj_LeadPage)
		{
			System.out.println("Lead page verified");
		}
		driver.findElement(By.xpath("html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
		WebElement obj_createLead=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/table[4]/tbody/tr/td[2]/div/span")));
		if (obj_createLead.isDisplayed())  
		{
			System.out.println("creating lead is dispalyed");
		}
		
		driver.findElement(By.xpath("//table[@class='small']/tbody/tr[4]/td[2]/input")).sendKeys("Teja");
		driver.findElement(By.xpath("//table[@class='small']/tbody/tr[5]/td[2]/input")).sendKeys("company");
		//click on save
		driver.findElement(By.xpath("//table[@class='small']/tbody/tr[1]/td/div/input[1]")).click();Thread.sleep(2000);
		
		
		
	}
	

	
}
